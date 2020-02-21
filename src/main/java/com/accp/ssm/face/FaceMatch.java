package com.accp.ssm.face;

import com.accp.ssm.util.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.accp.ssm.token.AuthService;
import com.accp.ssm.util.Base64Util;
import com.accp.ssm.util.FaceV3Bean;
import com.accp.ssm.util.FaceV3MatchBean;
import com.accp.ssm.util.FileUtil;
import com.accp.ssm.util.GsonUtils;

import java.util.*;

/**
* 人脸对比
*/
public class FaceMatch {
	private static final String FACE_MATCH = "https://aip.baidubce.com/rest/2.0/face/v3/match";
	
	/**
	 * 获取照片对比分数值
	 * @param imgStr1 人脸识别拍摄的base64图片数据
	 * @param imgStr2 已注册的用户照片本地路径
	 * @return
	 */
	public static double getScore(String imgStr1,String imgStr2) {
		String f=FaceMatch(imgStr1, imgStr2, AuthService.getToken());
		FaceV3MatchBean faceV3MatchBean = JSON.parseObject(f, FaceV3MatchBean.class);
		// FaceV3MatchBean faceV3MatchBean = JSONObject.toJavaObject(JSON.parseObject(f), FaceV3MatchBean.class);
		 return faceV3MatchBean.getResult().getScore();
	}
	
	public static void main(String[] args) {
		String f=FaceMatch("E:\\face\\img2.jpg", "E:\\face\\img1.jpg", AuthService.getToken());
		//System.out.println(FaceMatch("D:\\1577156826583.png", "E:\\face\\be8e8f46-10fa-466a-9b5e-c718223c8722.png", AuthService.getToken()));
                FaceV3MatchBean faceV3MatchBean = JSONObject.toJavaObject(JSON.parseObject(f), FaceV3MatchBean.class);
                System.out.println("对比分数值:"+faceV3MatchBean.getResult().getScore());
	}

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
	/**
	 * 人脸对比示例代码
	 * @param path1 图片本地路径1
	 * @param path2 图片本地路径1
	 * @param token AccessToken
	 * @return
	 */
	public static String FaceMatch(String imgStr1,String path2,String token) {
        try {
            // 本地文件路径
            //String filePath1 = path1;
            String filePath2 = path2;
           //byte[] imgData1 = FileUtil.readFileByBytes(filePath1);
            byte[] imgData2 = FileUtil.readFileByBytes(filePath2);
            //String imgStr1 = Base64Util.encode(imgData1);
            String imgStr2 = Base64Util.encode(imgData2);
            List faceMatchs = new ArrayList();
            FaceV3Bean faceMatch1 = new FaceV3Bean(imgStr1,"BASE64");
            FaceV3Bean faceMatch2 = new FaceV3Bean(imgStr2,"BASE64");
            faceMatchs.add(faceMatch1);
            faceMatchs.add(faceMatch2);
            String param = JSONObject.toJSONString(faceMatchs);
            System.out.println("======"+param);
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = token;
            String result = HttpUtil.post(FACE_MATCH, accessToken, param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
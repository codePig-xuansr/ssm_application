package com.accp.ssm.face;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.accp.ssm.util.Base64Util;
import com.accp.ssm.util.FileUtil;
import com.accp.ssm.util.GsonUtils;
import com.accp.ssm.util.HttpUtil;

import java.net.URLEncoder;

/**
* 人脸探测
*/
	public class FaceDetect  {
	    /**
	     * 重要提示代码中所需工具类
	     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
	     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
	     * 下载
	     */
	    public static String detect() throws IOException {
	        // 请求url
	        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
	        String Filepath = "E:\\face\\img1.jpg";
	        String image = Base64Util.encode(FileUtil.readFileByBytes(Filepath));
	        try {
	            Map<String, Object> map = new HashMap<>();
	            map.put("image", image);
	            map.put("face_field", "faceshape,facetype,age,beauty");
	            map.put("image_type", "BASE64");

	            String param = GsonUtils.toJson(map);

	            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
	            String accessToken = "24.bcce30cf12888dda1b50c3527941965a.2592000.1579599469.282335-18080970";

	            String result = HttpUtil.post(url, accessToken, "application/json", param);
	            System.out.println(result);
	            return result;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public static void main(String[] args) throws IOException {
	        FaceDetect.detect();
	    }
	}

 //返回参数a
//    log_id	uint64	是	日志id
//    result_num	uint32	是	人脸数目
//    result	object[]	是	人脸属性对象的集合
//    +age	double	否	年龄。face_fields包含age时返回
//    +beauty	double	否	美丑打分，范围0-100，越大表示越美。face_fields包含beauty时返回
//    +location	object	是	人脸在图片中的位置
//    ++left	uint32	是	人脸区域离左边界的距离
//    ++top	uint32	是	人脸区域离上边界的距离
//    ++width	uint32	是	人脸区域的宽度
//    ++height	uint32	是	人脸区域的高度
//    +face_probability	double	是	人脸置信度，范围0-1
//    +rotation_angle	int32	是	人脸框相对于竖直方向的顺时针旋转角，[-180,180]
//    +yaw	double	是	三维旋转之左右旋转角[-90(左), 90(右)]
//    +pitch	double	是	三维旋转之俯仰角度[-90(上), 90(下)]
//    +roll	double	是	平面内旋转角[-180(逆时针), 180(顺时针)]
//    +expression	uint32	否	表情，0，不笑；1，微笑；2，大笑。face_fields包含expression时返回
//    +expression_probability	double	否	表情置信度，范围0~1。face_fields包含expression时返回
//    +faceshape	object[]	否	脸型置信度。face_fields包含faceshape时返回
//    ++type	string	是	脸型：square/triangle/oval/heart/round
//    ++probability	double	是	置信度：0~1
//    +gender	string	否	male、female。face_fields包含gender时返回
//    +gender_probability	double	否	性别置信度，范围[0~1]，face_fields包含gender时返回
//    +glasses	uint32	否	是否带眼镜，0-无眼镜，1-普通眼镜，2-墨镜。face_fields包含glasses时返回
//    +glasses_probability	double	否	眼镜置信度，范围[0~1]，face_fields包含glasses时返回
//    +landmark	object[]	否	4个关键点位置，左眼中心、右眼中心、鼻尖、嘴中心。face_fields包含landmark时返回
//    ++x	uint32	否	x坐标
//    ++y	uint32	否	y坐标
//    +landmark72	object[]	否	72个特征点位置，face_fields包含landmark时返回
//    ++x	uint32	否	x坐标
//    ++y	uint32	否	y坐标
//    +race	string	否	yellow、white、black、arabs。face_fields包含race时返回
//    +race_probability	double	否	人种置信度，范围[0~1]，face_fields包含race时返回
//    +qualities	object	否	人脸质量信息。face_fields包含qualities时返回
//    ++occlusion	object	是	人脸各部分遮挡的概率，范围[0~1]，0表示完整，1表示不完整
//    +++left_eye	double	是	左眼遮挡比例
//    +++right_eye	double	是	右眼遮挡比例
//    +++nose	double	是	鼻子遮挡比例
//    +++mouth	double	是	嘴巴遮挡比例
//    +++left_cheek	double	是	左脸颊遮挡比例
//    +++right_cheek	double	是	右脸颊遮挡比例
//    +++chin	double	是	下巴遮挡比例
//    ++blur	double	是	人脸模糊程度，范围[0~1]，0表示清晰，1表示模糊
//    ++illumination	-	是	取值范围在[0~255],表示脸部区域的光照程度
//    ++completeness	-	是	人脸完整度，0或1, 0为人脸溢出图像边界，1为人脸都在图像边界内
//    ++type	object	是	真实人脸/卡通人脸置信度
//    +++human	-	是	真实人脸置信度，[0~1]，大于0.5可以判断为人脸
//    +++cartoon	-	是	卡通人脸置信度，[0~1]

 
 

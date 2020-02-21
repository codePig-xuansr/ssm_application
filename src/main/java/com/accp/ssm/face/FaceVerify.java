package com.accp.ssm.face;

import java.util.HashMap;
import java.util.Map;

import com.accp.ssm.token.AuthService;
import com.accp.ssm.util.GsonUtils;
import com.accp.ssm.util.HttpUtil;

/**
 * 在线活体检测
 * @author 轩然
 *
 */
public class FaceVerify {
	
		/**
	 	 * 调用摄像头拍照进行活体检测
	 	 * @param imgStr 拍照传输的base64格式信息
	 	 * @return
	 	 */
		public static String getVerifyScore(String imgStr) {
			return FaceVerify.faceVerify(imgStr);
		}

	 	/**
	 	 * 调用摄像头拍照进行活体检测
	 	 * @param image 拍照传输的base64格式信息
	 	 * @return
	 	 */
	    public static String faceVerify(String image) {
	        // 请求url
	        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceverify";
	        try {
	        	 Map<String, Object> map = new HashMap<>();
		            map.put("image", image);
		            map.put("face_field", "faceshape,facetype,age,beauty");
		            map.put("image_type", "BASE64");
	            String param = GsonUtils.toJson(map);

	            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
	            String accessToken = AuthService.getToken();

	            String result = HttpUtil.post(url, accessToken, "application/json", param);
	            System.out.println(result);
	            return result;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	/*
	 * public static void main(String[] args) { FaceVerify.faceVerify(""); }
	 */
}

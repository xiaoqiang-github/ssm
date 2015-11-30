package com.ywq.ssm.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 校验工具类
 * @author yangWeiQiang
 *
 */
public class CheckUtils {

	private static final String SHA1 = "SHA-1";
	/**
	 *  加密/校验流程如下：
		1. 将token、timestamp、nonce三个参数进行字典序排序
		2. 将三个参数字符串拼接成一个字符串进行sha1加密
		3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
	 * @param signature 微信发来的加密后的签名
	 * @param token token
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @return 校验是否相等
	 */
	public static boolean checkSignature(String signature,String token,String timestamp,String nonce){
		String[] paramArr = new String[]{token,timestamp,nonce};
		Arrays.sort(paramArr);
		
		String decript = paramArr[0]+paramArr[1]+paramArr[2];
		String localSignature = sha1(decript);
		
		return signature.equals(localSignature);
	}
	
	public static String sha1(String decript){
		try {
			MessageDigest digest = MessageDigest.getInstance(SHA1);
			digest.update(decript.getBytes());
			byte[] msgDigestArr = digest.digest();
			StringBuffer sb = new StringBuffer();
			// 字节数组转换为 十六进制 数
            for (int i = 0; i < msgDigestArr.length; i++) {
                String shaHex = Integer.toHexString(msgDigestArr[i] & 0xFF);
                if (shaHex.length() < 2) {
                	sb.append(0);
                }
                sb.append(shaHex);
            }
            return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

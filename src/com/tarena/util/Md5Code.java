package com.tarena.util;

import java.security.MessageDigest;
import sun.misc.BASE64Encoder;
public class Md5Code {

	public static String createMd5Code(String code) throws Exception {
		// ��ȡMd5����
		MessageDigest digest = MessageDigest.getInstance("MD5");
       //�ַ���ת����hashcodeֵ
		byte[] b=digest.digest(code.getBytes());
		//sun��˾�����㷨,����ȫ��������ʹ��
		BASE64Encoder encoder=new BASE64Encoder();
		return encoder.encode(b);
	}
}

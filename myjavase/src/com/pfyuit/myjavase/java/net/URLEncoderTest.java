package com.pfyuit.myjavase.java.net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Operations for URLEncoder
 * @author yupengfei
 */
public class URLEncoderTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws UnsupportedEncodingException {
		String encodedUrl = URLEncoder.encode("http://www.pfyuit.com?state=����");
		System.out.println(encodedUrl);
		String encodedUrl1 = URLEncoder.encode("http://www.pfyuit.com?state=����", "UTF8");
		System.out.println(encodedUrl1);
	}

}

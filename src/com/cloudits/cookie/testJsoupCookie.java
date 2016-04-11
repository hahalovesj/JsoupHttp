package com.cloudits.cookie;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class testJsoupCookie {
	
	public void testJsoup(){	
		try {
			Connection conn = Jsoup.connect("http://passport.jd.com/new/login.aspx");
			conn.data("loginname","15801303088");
			conn.data("nloginpwd","3339677sj");
			conn.timeout(50000);
			conn.method(Method.POST);//指定HTTP的request的method，默认get			
			Response response =conn.execute();// Execute the request.throws IOException
			Map<String,String> cookies =response.cookies();
		
			Document doc = Jsoup.connect("http://order.jd.com/center/list.action")
					.cookies(cookies)
					.timeout(50000)
					.get();
			System.out.println(doc);		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	public static void main(String[] args) {
	testJsoupCookie tjcookie = new testJsoupCookie();
	tjcookie.testJsoup();	
	}
}

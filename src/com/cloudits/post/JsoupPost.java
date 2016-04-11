package com.cloudits.post;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.cloudits.get.JsoupGet;

public class JsoupPost {
	Document doc =null;
	//带1个参数的post方法
		public Document PostUrl(String url,String parame1){
			//http://yuedu.baidu.com/search?word=%D4%C6%B2%E3&pbook=0
			//百度阅读，搜索云层，提交的链接。
			try {
				// 
				Connection conn =  Jsoup.connect(url);
				conn.timeout(5000);//5秒超时
				conn.data("theRegionCode", parame1);
				doc = conn.post();
				
			} catch (IOException e) {			
				e.printStackTrace();
			}
			return doc;
		}
		//带2个参数的post方法
			public Document PostUrl(String url,String kword,String pbook){
				//http://yuedu.baidu.com/search?word=%D4%C6%B2%E3&pbook=0
				//百度阅读，搜索云层，提交的链接。
				try {
					// 
					Connection conn =  Jsoup.connect(url);
					conn.data("word", kword);
					conn.data("pbook", pbook);
					doc = conn.post();
					
				} catch (IOException e) {			
					e.printStackTrace();
				}
				return doc;
			}

	public static void main(String[] args) {
		JsoupPost myPost = new JsoupPost();
		Document doc;
		//调用带参的类方法
				doc = myPost.PostUrl("http://yuedu.baidu.com/search", "云层","0");
		//http://ws.webxml.com.cn/WebServices/WeatherWs.asmx/getSupportCityString 
				doc = myPost.PostUrl("http://ws.webxml.com.cn/WebServices/WeatherWs.asmx/getSupportCityString","上海");                        
				System.out.println(doc);
	}

}

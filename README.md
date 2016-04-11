# JsoupHttp
通过云层接口视频，学习JsoupGet，jsoupPost
package com.cloudits.get;

import java.io.IOException;

import javax.swing.plaf.synth.SynthScrollBarUI;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.Messaging.SyncScopeHelper;

public class JsoupGet {
	Document doc =null;
	//无参数get方式
	public Document GetUrl(String url){
		try {
			// 抓取页面
			doc = (Document) Jsoup.connect(url).get();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return doc;
	}
	//带参数的get方法
	public Document GetUrl(String url,String param1,String param2){
		//http://yuedu.baidu.com/search?word=%D4%C6%B2%E3&pbook=0
		//百度阅读，搜索云层，提交的链接。
		try {
			// 
			Connection conn =  Jsoup.connect(url);
			conn.data("word", param1);
			conn.data("pbook", param2);
			doc = conn.get();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return doc;
	}	
	
	public static void main(String[] args) {
		
		/* 如果需要使用fiddler的mockserver ，则设置如下
		 * System.setProperty("http.proxySet", "ture");
		 * System.setProperty("http.proxyHost", "127.0.0.1");
		 * System.setProperty("http.proxyPort", "8888");		  
		 * */
		
		
		JsoupGet myGet = new JsoupGet();
		Document doc;
		doc = myGet.GetUrl("http://www.baidu.com");//不带参数方法
				
		//doc = myGet.GetUrl("http://yuedu.baidu.com/search", "云层","0");//带参数方法
		
		//利用css获取内容，用select做断言
		Elements elements = doc.select(".mnav");
		
		//获得第一个元素first，获得指定序列的元素get
		System.out.println(elements.first().toString());
		System.out.println(elements.get(1).toString());
		//获取第一个元素
		Element element =elements.first();
		
		if (element.toString().contains("糯米"))
			System.out.println("断言成功");
		else
			System.out.println("断言失败");
		
		
	}
		
}

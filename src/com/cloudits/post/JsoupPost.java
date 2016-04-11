package com.cloudits.post;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.cloudits.get.JsoupGet;

public class JsoupPost {
	Document doc =null;
	//��1��������post����
		public Document PostUrl(String url,String parame1){
			//http://yuedu.baidu.com/search?word=%D4%C6%B2%E3&pbook=0
			//�ٶ��Ķ��������Ʋ㣬�ύ�����ӡ�
			try {
				// 
				Connection conn =  Jsoup.connect(url);
				conn.timeout(5000);//5�볬ʱ
				conn.data("theRegionCode", parame1);
				doc = conn.post();
				
			} catch (IOException e) {			
				e.printStackTrace();
			}
			return doc;
		}
		//��2��������post����
			public Document PostUrl(String url,String kword,String pbook){
				//http://yuedu.baidu.com/search?word=%D4%C6%B2%E3&pbook=0
				//�ٶ��Ķ��������Ʋ㣬�ύ�����ӡ�
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
		//���ô��ε��෽��
				doc = myPost.PostUrl("http://yuedu.baidu.com/search", "�Ʋ�","0");
		//http://ws.webxml.com.cn/WebServices/WeatherWs.asmx/getSupportCityString 
				doc = myPost.PostUrl("http://ws.webxml.com.cn/WebServices/WeatherWs.asmx/getSupportCityString","�Ϻ�");                        
				System.out.println(doc);
	}

}

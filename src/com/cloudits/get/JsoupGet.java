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
	//�޲���get��ʽ
	public Document GetUrl(String url){
		try {
			// ץȡҳ��
			doc = (Document) Jsoup.connect(url).get();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return doc;
	}
	//��������get����
	public Document GetUrl(String url,String param1,String param2){
		//http://yuedu.baidu.com/search?word=%D4%C6%B2%E3&pbook=0
		//�ٶ��Ķ��������Ʋ㣬�ύ�����ӡ�
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
		
		/* �����Ҫʹ��fiddler��mockserver ������������
		 * System.setProperty("http.proxySet", "ture");
		 * System.setProperty("http.proxyHost", "127.0.0.1");
		 * System.setProperty("http.proxyPort", "8888");		  
		 * */
		
		
		JsoupGet myGet = new JsoupGet();
		Document doc;
		doc = myGet.GetUrl("http://www.baidu.com");//������������
				
		//doc = myGet.GetUrl("http://yuedu.baidu.com/search", "�Ʋ�","0");//����������
		
		//����css��ȡ���ݣ���select������
		Elements elements = doc.select(".mnav");
		
		//��õ�һ��Ԫ��first�����ָ�����е�Ԫ��get
		System.out.println(elements.first().toString());
		System.out.println(elements.get(1).toString());
		//��ȡ��һ��Ԫ��
		Element element =elements.first();
		
		if (element.toString().contains("Ŵ��"))
			System.out.println("���Գɹ�");
		else
			System.out.println("����ʧ��");
		
		
	}
		
}

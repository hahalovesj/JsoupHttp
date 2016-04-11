package com.testng.jsoup;

import org.jsoup.nodes.Document;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cloudits.get.JsoupGet;

public class testJsoupGet {
	//数据驱动
	@DataProvider
	public Object[][] mydatasource(){
		return new Object[][]{{"http://www.baidu.com"},{"http://www.sina.com"}};
		
	}
  @Test(dataProvider = "mydatasource")
  public void f(String url) {
	  JsoupGet myget = new JsoupGet();	  
	  Document doc = myget.GetUrl(url);
	  Assert.assertTrue(doc.toString().contains("百度"));
  }
}

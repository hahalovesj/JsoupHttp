package com.cloudits.calc;
//������һ����͵ķ���
public class Calc {
	
    public int add(int x,int y){
    	return(x+y);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c; 
		a =10;
		b = 20;
		Calc calc = new Calc();
		c = calc.add(10, 20);
		if(c==30)
			System.out.println("���Գɹ�");
		else
			System.out.println("����ʧ��");
	}

}

package com.testng.add;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cloudits.calc.Calc;

public class testCalcAdd {
  @Test
  public void f() {
	  Calc calc = new Calc();
	  int actual = calc.add(10, 20);
	  int expected =30;
	  Assert.assertEquals(actual, expected);
  }
}

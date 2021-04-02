package com.rk.junit.firstapp.mockito;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockitoSpyTest {

	@Test
	public void testSpy() {
		// @Spy or the spy() method can be used to wrap a real object. Every call,
		// unless specified otherwise, is delegated to the object.

		Properties p = new Properties();
		Properties spyP = Mockito.spy(p);
		
		Mockito.doReturn("42").when(spyP).get("ABC");
		
		String val = (String) spyP.get("ABC");
		Assertions.assertEquals("42", val);
	}
	
	@Test
	public void testLinkedListSypCorrect()
	{
		List<String> list=new LinkedList<>();
		List<String> spyList=Mockito.spy(list);
		
		Mockito.doReturn("foo").when(spyList).get(0);
		
		Assertions.assertEquals("foo",spyList.get(0));
	}
	
	
}

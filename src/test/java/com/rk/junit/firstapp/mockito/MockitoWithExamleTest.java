package com.rk.junit.firstapp.mockito;


import java.util.Iterator;
import java.util.Properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoWithExamleTest {

	@Mock
	Iterator<String> i;

	Comparable<String> c;

	@Test
	public void testMoreThanOneReturns() {
		Mockito.when(i.next()).thenReturn("A").thenReturn("B").thenReturn("C");
		String results = i.next() + i.next() + i.next() + i.next();
//		System.out.println(results);
		Assertions.assertEquals("ABCC", results);
	}

	@Test
	public void testReturnValueBasedOnMethodParam(@Mock Comparable<String> c)
	{
		Mockito.when(c.compareTo("ABC")).thenReturn(1);
		Mockito.when(c.compareTo("XYZ")).thenReturn(2);
		
		Assertions.assertEquals(1, c.compareTo("ABC"));
		Assertions.assertEquals(2, c.compareTo("XYZ"));
	}

	@Test
	public void testReturnValueBasedOnMethodParam1(@Mock Comparable<Integer> c)
	{
		Mockito.when(c.compareTo(ArgumentMatchers.isA(Integer.class))).thenReturn(0);
		Assertions.assertEquals(0, c.compareTo(Integer.valueOf(5)));
	}
	
	
	@Test
	public void testMockitoThrows()
	{
		Properties prop=Mockito.mock(Properties.class);
		Mockito.when(prop.get(Mockito.anyString())).thenThrow(new IllegalArgumentException("stuff"));
		Throwable exception =Assertions.assertThrows(IllegalArgumentException.class, ()->prop.get("A"));
		Assertions.assertEquals("stuff", exception.getMessage());
	}
}

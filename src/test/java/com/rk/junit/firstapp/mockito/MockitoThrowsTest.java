package com.rk.junit.firstapp.mockito;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MockitoThrowsTest {
//The doThrow variant can be used for methods which return void to throw an exception.

//	@Mock
//	OutputStream ops;
	
	@Test
	public void testForIOException() throws IOException {

		OutputStream ops = Mockito.mock(OutputStream.class);
		Mockito.doThrow(new IOException()).when(ops).close();

		OutputStreamWriter steamWritr = new OutputStreamWriter(ops);
		Assertions.assertThrows(IOException.class, () -> steamWritr.close());
	}
}

package com.rk.junit.firstapp.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
	
	@Mock
	Database databaseMock;

	@Test
	public void testQuery()
	{
		Assertions.assertNotNull(databaseMock);
		Mockito.when(databaseMock.isAvailable()).thenReturn(true);
		Service t = new Service(databaseMock);
		boolean check=t.query("* from t");
		Assertions.assertEquals(check, true);
		Assertions.assertTrue(check);
		
	}
}

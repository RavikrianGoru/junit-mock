package com.rk.junit.firstapp.mockito;

import org.mockito.Mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoVerifyTest {
	@Test
	public void testVerify(@Mock Database database) {
		// create and configure mock
		Mockito.when(database.getUniqueId()).thenReturn(43);

		// call method testing on the mock with parameter 12
		database.setUniqueId(12);
		database.getUniqueId();
		database.getUniqueId();

		// now check if method testing was called with the parameter 12
		Mockito.verify(database).setUniqueId(ArgumentMatchers.eq(12));

		// was the method called twice?
		Mockito.verify(database, Mockito.times(2)).getUniqueId();

		// other alternatives for verifiying the number of method calls for a method
		Mockito.verify(database, Mockito.never()).isAvailable();
		Mockito.verify(database, Mockito.never()).setUniqueId(13);
		Mockito.verify(database, Mockito.atLeastOnce()).setUniqueId(12);
		Mockito.verify(database, Mockito.atLeast(2)).getUniqueId();

		// more options are
		// times(numberOfTimes)
		// atMost(numberOfTimes)
		// This let's you check that no other methods where called on this object.
		// You call it after you have verified the expected method calls.
		Mockito.verifyNoMoreInteractions(database);
	}

}

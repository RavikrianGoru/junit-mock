package com.rk.junit.firstapp.mockito.injectmock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ArticleManagerTest {

	@Mock User user;
	@Mock ArticleDatabase database;
	
	@InjectMocks
	private ArticleManager manager;
	
	@Test
	public void testInjectMock() {
		// calls addListener with an instance of ArticleListener
		manager.initialize();
		// validate that addListener was called

		Mockito.verify(database).addListener(Mockito.any(ArticleListener.class));

	}

}

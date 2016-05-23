/*package com.foodmood.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.foodmood.models.Wine;
import com.foodmood.services.WineService;

public class wineTest {
	@InjectMocks
	private WineService wineService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateWine() {
		MockHttpServletRequest request = new MockHttpServletRequest();
	    MockHttpServletResponse response = new MockHttpServletResponse();
	    request.addHeader(HttpHeaders.HOST, "myhost.com");
	    request.setLocalPort(8081);
	    request.setRemoteAddr("127.0.0.1"); 
	    
	    request.setParameter("wineSort", "wineTest");
	    request.setParameter("numberOfGrapes", "1");
	    request.setParameter("grape1", "testGrape");
	    for(int i = 1; i <= 35; i++){
	    	request.setParameter("score"+i, "1"+i);
	    }
	    
	    
	    Wine wine = wineService.createWine(request);
	    assertEquals("wineTest", wine.getWineSort());
	    assertEquals("testGrape", wine.getGrapes().get(0));
	    assertEquals(Integer.valueOf(15), wine.getScoreForFoodTag().get(4));
	}

}
*/

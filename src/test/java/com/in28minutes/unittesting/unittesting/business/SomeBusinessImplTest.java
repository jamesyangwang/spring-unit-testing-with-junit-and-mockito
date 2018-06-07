package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplTest {

//	private SomeBusinessImpl business = new SomeBusinessImpl();
	@InjectMocks
	SomeBusinessImpl business;
	
//	private SomeDataService dataServiceMock = mock(SomeDataService.class);
	@Mock
	SomeDataService dataServiceMock;

	@Before
	public void before() {
		business.setSomeDataService(dataServiceMock);		
	}
	
	@Test
	public void calculateSumUsingDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
		assertTrue(6 == business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertTrue(0 == business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1});
		assertTrue(1 == business.calculateSumUsingDataService());
	}
}

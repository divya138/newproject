package com.hcl.busbooking.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.busbooking.dto.BusSearchDto;
import com.hcl.busbooking.model.BusRoute;
import com.hcl.busbooking.service.BusRouteServiceImpl;



@RunWith(MockitoJUnitRunner.Silent.class)
public class BusRouteControllerTest {
	@InjectMocks
	BusRouteController busRouteController;
	@Mock
	BusRouteServiceImpl busRouteServiceImpl;
	
	static BusSearchDto dto=new BusSearchDto();
	static BusRoute route=null;
	@BeforeClass
	public static void setUp() {
		
		route =new BusRoute();
		route.setSource("kandukur");
		route.setDestination("chennai");
		route.setDate(new Date());
		dto.setSource("kandukur1");
		dto.setDestination("chennai");
		dto.setJourneyDate(new Date());
		
	}
	@Test
	public void testSearchBus() {
		List<BusRoute> routes=new ArrayList<BusRoute>();
		routes.add(route);
		Mockito.when(busRouteServiceImpl.searchBuses(dto)).thenReturn(routes);
		ResponseEntity<List<BusRoute>> b1=busRouteController.searchBuses(dto);
		Assert.assertEquals(HttpStatus.FOUND, b1.getStatusCode());
		
	}
	@Test
	public void testSearchBusForPositive() {
		List<BusRoute> routes=new ArrayList<BusRoute>();
		routes.add(route);
		Mockito.when(busRouteServiceImpl.searchBuses(dto)).thenReturn(routes);
         busRouteController.searchBuses(dto);
		Assert.assertEquals(route.getDestination(),dto.getDestination());
		
	}
	@AfterClass
	public static void tearDown() {
		route=null;
		
	}

}

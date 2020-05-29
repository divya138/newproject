package com.hcl.busbooking.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.busbooking.dao.BusRouteRepository;
import com.hcl.busbooking.dto.BusSearchDto;
import com.hcl.busbooking.exception.BusNotFoundException;
import com.hcl.busbooking.model.BusRoute;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BusRouteServiceImplTest {
	@InjectMocks
	BusRouteServiceImpl busRouteServiceImpl;
	@Mock
	BusRouteRepository busRouteRepository;
	static BusRoute route=null;
	@BeforeClass
	public static void setUp() {
	
		route=new BusRoute();
		route.setBusName("kaveri");
		route.setSource("kandukur");
		route.setDestination("vizag");
		route.setDate(new Date());
	
		
	}
	@Test(expected=BusNotFoundException.class)
	public void testSearchBusForException() {
		List<BusRoute> routes=new ArrayList<BusRoute>();
		BusSearchDto dto=new BusSearchDto();
		dto.setSource("vizag");
		routes.add(route);
		Mockito.when(busRouteRepository.findBySourceAndDestinationAndDate(route.getSource(), route.getDestination(), route.getDate())).thenReturn(routes);
		busRouteServiceImpl.searchBuses(dto);
		
	}
	@Test
	public void testForSearchBus() {
		List<BusRoute> routes=new ArrayList<BusRoute>();
		BusSearchDto dto=new BusSearchDto();
		dto.setSource("kandukur");
		dto.setDestination("vizag");
		dto.setJourneyDate(new Date());
		routes.add(route);
		Mockito.when(busRouteRepository.findBySourceAndDestinationAndDate(dto.getSource(), dto.getDestination(), dto.getJourneyDate())).thenReturn(routes);
		busRouteServiceImpl.searchBuses(dto);
		
	}
	@Test
	public void testForSearchBusPositive() {
		List<BusRoute> routes=new ArrayList<BusRoute>();
		BusSearchDto dto=new BusSearchDto();
		dto.setSource("kandukur");
		dto.setDestination("vizag");
		dto.setJourneyDate(new Date());
		routes.add(route);
		Mockito.when(busRouteRepository.findBySourceAndDestinationAndDate(dto.getSource(), dto.getDestination(), dto.getJourneyDate())).thenReturn(routes);
		busRouteServiceImpl.searchBuses(dto);
		Assert.assertEquals(route.getSource(), dto.getSource());
		
	}

}

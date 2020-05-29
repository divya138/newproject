package com.hcl.busbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.busbooking.dao.BusRouteRepository;
import com.hcl.busbooking.dto.BusSearchDto;
import com.hcl.busbooking.exception.BusNotFoundException;
import com.hcl.busbooking.model.BusRoute;
@Service
public class BusRouteServiceImpl implements BusRouteService {
	
	@Autowired
	private BusRouteRepository busRouteRepository;

	@Override
	public List<BusRoute> searchBuses(BusSearchDto dto) throws BusNotFoundException{
		
		List<BusRoute> buses=busRouteRepository.findBySourceAndDestinationAndDate(dto.getSource(),dto.getDestination(),dto.getJourneyDate());
		if(buses.isEmpty()) {
			 throw new BusNotFoundException("sorry,buses are not available");
		}
		 return buses;
		
	}

	
}

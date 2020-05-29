package com.hcl.busbooking.service;

import java.util.List;

import com.hcl.busbooking.dto.BusSearchDto;
import com.hcl.busbooking.exception.BusNotFoundException;
import com.hcl.busbooking.model.BusRoute;

public interface BusRouteService {
	
	public List<BusRoute> searchBuses(BusSearchDto dto) throws BusNotFoundException;

}

package com.hcl.busbooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.busbooking.dto.BusSearchDto;
import com.hcl.busbooking.model.BusRoute;
import com.hcl.busbooking.service.BusRouteService;

@RestController
public class BusRouteController {
@Autowired
	private BusRouteService busRouteService;

@PostMapping("/search")
     public ResponseEntity<List<BusRoute>> searchBuses(@Valid @RequestBody BusSearchDto dto){
	   List<BusRoute> buses=busRouteService.searchBuses(dto);
	   return new ResponseEntity<List<BusRoute>>(buses, HttpStatus.FOUND);
    	 
     }
}

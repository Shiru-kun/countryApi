package com.cthshiru.mz.countries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cthshiru.mz.countries.CountryBean;
import com.cthshiru.mz.countries.model.Country;
import com.cthshiru.mz.countries.services.CountryServices;

@RestController
@RequestMapping("/api")
public class CountryController {

	@Autowired
	private CountryServices countryService;
	
	

	@CrossOrigin
	@PostMapping("/country")
	public  ResponseEntity<?> save(@RequestBody CountryBean countryBean){	
		Country country  = new Country();
		country.setArea(countryBean.getArea());
		country.setCapital(countryBean.getCapital());
		country.setName(countryBean.getName());
		country.setRegion(countryBean.getRegion());
		country.setSubRegion(countryBean.getSubRegion());
		
		return new ResponseEntity<>(countryService.save(country), HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/country")
	public  ResponseEntity<?> list(){		
		 return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@GetMapping("/country/{id}")
	public  ResponseEntity<?> getCountry(@PathVariable ("id") long id){		
		 return new ResponseEntity<>(countryService.findById(id), HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@DeleteMapping("/country/{id}")
	public  ResponseEntity<?> deleteCountry(@PathVariable ("id") long id){		
		 return new ResponseEntity<>(countryService.delete(countryService.findById(id)), HttpStatus.OK);
	}
	
	
	
	@CrossOrigin
	@PutMapping("/country")
	public  ResponseEntity<?> update(@RequestBody Country country){	
		return new ResponseEntity<>(countryService.save(country), HttpStatus.OK);
	}
	
	
	
	// get last 
	@CrossOrigin
	@GetMapping("/country/getLast")
	public  ResponseEntity<?> getLastCountry(){		
		 int lastCountry = countryService.findAll().size()-1;
		 countryService.findAll().get(lastCountry);
		 return new ResponseEntity<>( countryService.findAll().get(lastCountry), HttpStatus.OK);
	}
	
	
	
}

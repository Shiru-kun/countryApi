package com.cthshiru.mz.countries.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cthshiru.mz.countries.interfaces.ICountry;
import com.cthshiru.mz.countries.model.Country;

@Service
public class CountryServices {

	@Autowired
	private ICountry iCountry;

	// save method
	public boolean save(Country country) {
		try {
			iCountry.save(country);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Country findById(long id) {

		return iCountry.getOne(id);

	}

	public List<Country> findAll() {

		return iCountry.findAll();

	}

	public boolean delete(Country country) {
		try {
			iCountry.delete(country);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}

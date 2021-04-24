package com.cthshiru.mz.countries.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cthshiru.mz.countries.model.Country;

public interface ICountry  extends JpaRepository<Country, Long>{

	
}

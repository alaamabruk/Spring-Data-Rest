package com.example.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Repotiry extends JpaRepository<Alien, Integer> {

	//List<Alien> findByLang(String teck);

	/*
	 * List<Alien> findByIdGreaterThan(int id);
	 * 
	 * @Query("from Alien where lang=?1 order by name") List<Alien>
	 * findByLangSorted(String teck);
	 */
	
}

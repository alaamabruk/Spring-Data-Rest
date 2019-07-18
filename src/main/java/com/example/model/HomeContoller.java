package com.example.model;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeContoller {

	@Autowired
	Repotiry repo;
	
	@RequestMapping("/")
	public String show() {
	
	return "index";
	}
	
	
	@RequestMapping("add")
	public String addAlien(Alien alien) {
	System.out.println("IN");
		repo.save(alien);
		return "index";
	}
	
	@GetMapping("find/{id}")
    public Optional<Alien> getAlien(@PathVariable("id") int id) {
		
		/*
		 * ModelAndView mv = new ModelAndView(); Alien alien =
		 * repo.findById(id).orElse(null); mv.addObject("obj",alien);
		 * mv.setViewName("show");
		 */
		/*
		 * List<Alien> alien1 =(List<Alien>) repo.findByLang("php"); List<Alien> alien2
		 * =(List<Alien>) repo.findByIdGreaterThan(id); List<Alien> alien3
		 * =(List<Alien>) repo.findByLangSorted("python"); System.out.println(alien1);
		 * System.out.println(alien2); System.out.println(alien3);
		 */
     	return repo.findById(id);	
	}
	
	@PostMapping("alien")
	public Alien add(@RequestBody Alien alien) {
	System.out.println("IN");
		repo.save(alien);
		return alien;
	}
	
	@PutMapping("alien")
	public Alien saveOrupdate(@RequestBody Alien alien) {
	System.out.println("update");
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("alien/{id}")
	public String delete(@PathVariable int id) {

		Alien a = repo.getOne(id); 
		repo.delete(a);
		return "Deleted";
	}
	@RequestMapping("aliens")
	public List<Alien> ShowAll() {
		
		/*
		 * ModelAndView mv = new ModelAndView(); List<Alien> ls
		 * =(List<Alien>)repo.findAll(); mv.addObject("obj",ls); mv.setViewName("show");
		 * System.out.println("show");
		 */
		
		
		return repo.findAll();
	}
}

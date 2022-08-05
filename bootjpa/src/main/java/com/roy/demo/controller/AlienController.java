package com.roy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

import com.roy.demo.dao.AlienRepo;
import com.roy.demo.model.Alien;

@RestController
public class AlienController {
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")	
	public String addAlien(Alien alien)
	{
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")	
	public ModelAndView getAlien(@RequestParam Integer aid)
	{
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		
		System.out.println(repo.findByTech("Raju"));
		System.out.println(repo.findByAidGreaterThan(102));
		System.out.println(repo.findByTechSorted("Raju"));
		mv.addObject(alien);
		return mv;
	}
	@GetMapping(path="/aliens")	
	@ResponseBody
	public List<Alien> getAliens()
	{		
		return repo.findAll();
	}
	
	//get
	@RequestMapping("/alien/{aid}")	
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid") int aid)
	{		
		return repo.findById(aid);
	}
	
	//Post
	@PostMapping("/alien")	
	public Alien postAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
	//delete
	@DeleteMapping("/alien/{aid}")
	public Alien deleteAlien(@PathVariable int aid)
	{
		@SuppressWarnings("deprecation")
		Alien a=repo.getOne(aid);
		repo.delete(a);
		
		return a;
	}
	
	//Update
	@PutMapping(path="/alien")	
	public Alien putAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
}

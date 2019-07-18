package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.model.Alien;

@RepositoryRestResource(collectionResourceRel = "aliens" , path = "aliens")
public interface Alien_Repo extends JpaRepository<Alien, Integer> {

}

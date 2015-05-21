package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Bakery;

public interface BakeryRepository extends JpaRepository<Bakery, Integer> {

}

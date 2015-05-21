package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Bakery;
import com.example.repository.BakeryRepository;

@Service
@Transactional
public class BakeryService {
    @Autowired
    BakeryRepository bakeryRepository;

    public List<Bakery> findAll(){
        return bakeryRepository.findAll();
    }

    public Bakery findOne(Integer id){
        return bakeryRepository.findOne(id);
    }

    public Bakery create(Bakery customer){
        return bakeryRepository.save(customer);
    }

    public Bakery update(Bakery customer){
        return bakeryRepository.save(customer);
    }

    public void delete(Integer id){
        bakeryRepository.delete(id);
    }
}

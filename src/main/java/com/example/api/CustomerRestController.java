package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    // 顧客全件取得
    @RequestMapping(method = RequestMethod.GET)
    List<Customer> getCustomers(){
        List<Customer> customers = customerService.findAll();
        System.out.println("★顧客全件取得");
        return customers;
    }

    // 顧客１件取得
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Customer getCustomer(@PathVariable Integer id){
        Customer bread = customerService.findOne(id);
        return bread;
    }

    // 顧客新規登録
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Customer postCustomer(@RequestBody Customer bread){
        System.out.println("★顧客新規登録");
        return customerService.create(bread);
    }

    // 顧客１件更新
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Customer putCustomer(@PathVariable Integer id, @RequestBody Customer bread){
        bread.setId(id);
        return customerService.update(bread);
    }

    // 顧客１件削除
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Integer id){
        customerService.delete(id);
    }

}

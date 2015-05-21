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

import com.example.domain.Bakery;
import com.example.service.BakeryService;

@RestController
@RequestMapping("api/bakerys")
public class BakeryRestController {
    @Autowired
    BakeryService bakeryService;

    // パン屋さん全件取得
    @RequestMapping(method = RequestMethod.GET)
    List<Bakery> getBakerys(){
        List<Bakery> bakerys = bakeryService.findAll();
        System.out.println("★パン屋さん全件取得");
        return bakerys;
    }

    // パン屋さん１件取得
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Bakery getBakery(@PathVariable Integer id){
        Bakery bakery = bakeryService.findOne(id);
        return bakery;
    }

    // パン屋さん新規登録
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Bakery postBakery(@RequestBody Bakery bakery){
        System.out.println("★パン屋さん新規登録");
        return bakeryService.create(bakery);
    }

    // パン屋さん１件更新
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Bakery putBakery(@PathVariable Integer id, @RequestBody Bakery bakery){
        bakery.setId(id);
        return bakeryService.update(bakery);
    }

    // パン屋さん１件削除
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBakery(@PathVariable Integer id){
        bakeryService.delete(id);
    }

}

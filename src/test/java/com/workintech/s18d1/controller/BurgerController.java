package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/burgers")
@RequiredArgsConstructor
public class BurgerController {
    private final BurgerDao burgerDao;

    @GetMapping
    public List<Burger> getAllBurgers() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Burger> getBurgerById(@PathVariable Integer id) {
        Burger burger = burgerDao.findById(id);
        return ResponseEntity.ok(burger);
    }

    @PostMapping
    public void addBurger(@RequestBody Burger burger) {
        burgerDao.save(burger);
    }

    @PutMapping("/{id}")
    public void updateBurger(@PathVariable Integer id, @RequestBody Burger burger) {
        burger.setId(id);
        burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public void deleteBurger(@PathVariable Integer id) {
        burgerDao.remove(id);
    }

    @GetMapping("/findByPrice")
    public List<Burger> findBurgersByPrice(@RequestBody Double price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/findByBreadType")
    public List<Burger> findBurgersByBreadType(@RequestBody BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/findByContent")
    public List<Burger> findBurgersByContent(@RequestBody String content) {
        return burgerDao.findByContent(content);
    }
}

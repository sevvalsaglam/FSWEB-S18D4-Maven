package com.workintech.s18d1.dao;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class BurgerDaoImpl implements BurgerDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Burger burger) {
        entityManager.persist(burger);
    }

    @Override
    public Burger findById(long id) {
        return entityManager.find(Burger.class, id);
    }

    @Override
    public List<Burger> findAll() {
        return entityManager.createQuery("FROM Burger", Burger.class).getResultList();
    }

    @Override
    public List<Burger> findByPrice(Double price) {
        return entityManager.createQuery("FROM Burger b WHERE b.price > :price ORDER BY b.price DESC", Burger.class)
                .setParameter("price", price)
                .getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        return entityManager.createQuery("FROM Burger b WHERE b.breadType = :breadType ORDER BY b.name ASC", Burger.class)
                .setParameter("breadType", breadType)
                .getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        return entityManager.createQuery("FROM Burger b WHERE b.contents LIKE :content", Burger.class)
                .setParameter("content", "%" + content + "%")
                .getResultList();
    }

    @Override
    @Transactional
    public void update(Burger burger) {
        entityManager.merge(burger);
    }

    @Override
    @Transactional
    public void remove(long id) {
        Burger burger = findById(id);
        if (burger != null) {
            entityManager.remove(burger);
        }
    }

}

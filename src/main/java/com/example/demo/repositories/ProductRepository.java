package com.example.demo.repositories;

import com.example.demo.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query("SELECT obj FROM Product obj JOIN FETCH obj.categories WHERE obj IN :products")
//    List<Product> findProductsCategories(List<Product> products);

    @Query(value = "SELECT obj FROM Product obj JOIN FETCH obj.categories",
        countQuery = "SELECT COUNT(obj) FROM Product obj JOIN obj.categories")
    Page<Product> findProductsCategories(Pageable pageable);
}

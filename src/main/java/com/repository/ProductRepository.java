package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bean.ProductBean;

public interface ProductRepository extends CrudRepository<ProductBean, Integer> {

	List<ProductBean> findAll();
}

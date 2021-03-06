package com.cg.gowms.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.gowms.entity.ProductEntity;

@Repository
public interface ProductRepository  extends JpaRepository<ProductEntity,String> {
	@Query("SELECT p FROM ProductEntity p WHERE p.isDeleted=1")
    public List<ProductEntity> findAllByIsDeletedIsTrue();
	
	@Query("SELECT p FROM ProductEntity p WHERE p.isDeleted=0")
    public List<ProductEntity> findAllByIsDeletedIsFalse();

}

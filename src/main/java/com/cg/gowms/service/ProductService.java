package com.cg.gowms.service;

import java.util.List;

import com.cg.gowms.exception.ProductNotFoundException;
import com.cg.gowms.model.ProductModel;

public interface ProductService {
	
	    public List<ProductModel> getAllProducts();
	    public ProductModel getProductById(String id);
	    public ProductModel addProduct(ProductModel productModel) throws ProductNotFoundException;
	    public ProductModel updateProduct(ProductModel productModel) throws ProductNotFoundException;
	    public void deleteProduct(String id) throws ProductNotFoundException;

}

package com.cg.gowms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gowms.dao.ProductRepository;
import com.cg.gowms.entity.ProductEntity;
import com.cg.gowms.exception.ProductNotFoundException;
import com.cg.gowms.model.ProductModel;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
    private ProductEntity of(ProductModel source) {
    	ProductEntity result=null;
    	if(source!=null) {
    		result=new ProductEntity();
    		result.setIsDeleted(0);
    		result.setProductId(source.getProductId());
    		result.setProductName(source.getProductName());
    		result.setProductPrice(source.getProductPrice());
    		result.setProductCategory(source.getProductCategory());
    		result.setProductQuantity(source.getProductQuantity());
    		result.setProductSpecification(source.getProductSpecification());
    		result.setProductColor(source.getProductColor());
    	}
    	return result;
   
    }
    private ProductModel of(ProductEntity source) {
    	ProductModel result=null;
    	if(source!=null) {
    		result=new ProductModel();
    		result.setProductId(source.getProductId());
    		result.setProductName(source.getProductName());
    		result.setProductPrice(source.getProductPrice());
    		result.setProductCategory(source.getProductCategory());
    		result.setProductQuantity(source.getProductQuantity());
    		result.setProductSpecification(source.getProductSpecification());
    		result.setProductColor(source.getProductColor());
    	}
    	return result;
    }
	@Override
	public List<ProductModel> getAllProducts() {
		
		return productRepository.findAllByIsDeletedIsFalse().stream().map((entity)->of(entity)).collect(Collectors.toList());
	}

	@Override
	public ProductModel getProductById(String id) {
		
		Optional<ProductEntity> entity=productRepository.findById(id);
		return entity.isPresent()? of(entity.get()):null;
	}

	@Override
	public ProductModel addProduct(ProductModel productModel) throws ProductNotFoundException{

		if(productModel!=null) {
			if(productRepository.existsById(productModel.getProductId())) {
				throw new ProductNotFoundException("Prdouct id already exists !");
			}
			else {
				productModel= of(productRepository.save(of(productModel)));
			}
		}
		return productModel;
		
	}

	@Override
	public ProductModel updateProduct(ProductModel productModel) throws ProductNotFoundException {
		if(!(productRepository.existsById(productModel.getProductId()))) {
			throw new ProductNotFoundException("Product Id does not exist !");
		}
		else {
			return of(productRepository.save(of(productModel)));
		}
	
	}

	@Override
	public void deleteProduct(String id) throws ProductNotFoundException{
		Optional<ProductEntity> optionalEntity=productRepository.findById(id);
		ProductEntity entity=optionalEntity.isPresent()?optionalEntity.get():null;
		if(entity==null) {
			throw new ProductNotFoundException("Product does not exist !");
		}
		else {
			entity.setIsDeleted(1);
			productRepository.save(entity);
		}
	}

}

package com.cg.gowms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="great_outdoor_product_table")
public class ProductEntity {
	
	    @Id
	    @Column(name="product_id")
	    private String productId;
	    
	    @Column(name="product_name",nullable=false)
	    private String productName;
	    
	    @Column(name="product_price",nullable=false)
	    private Integer productPrice;
	    
	    @Column(name="product_color",nullable=false)
	    private String productColor;
	    
	    @Column(name="product_category",nullable=false)
	    private String productCategory;
	    
	    @Column(name="product_quantiy",nullable=false)
	    private Integer productQuantity;
	    
	    @Column(name="product_specification")
	    private String productSpecification;
	    
	    @Column(name="is_deleted_status")
	    private int isDeleted;

	  

		public String getProductId() {
			return productId;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public Integer getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(Integer productPrice) {
			this.productPrice = productPrice;
		}

		public String getProductColor() {
			return productColor;
		}

		public void setProductColor(String productColor) {
			this.productColor = productColor;
		}

		public String getProductCategory() {
			return productCategory;
		}

		public void setProductCategory(String productCategory) {
			this.productCategory = productCategory;
		}

		public Integer getProductQuantity() {
			return productQuantity;
		}

		public void setProductQuantity(Integer productQuantity) {
			this.productQuantity = productQuantity;
		}

		public String getProductSpecification() {
			return productSpecification;
		}

		public void setProductSpecification(String productSpecification) {
			this.productSpecification = productSpecification;
		}

		public int getIsDeleted() {
			return isDeleted;
		}

		public void setIsDeleted(int isDeleted) {
			this.isDeleted = isDeleted;
		}

	
	    
	    

}

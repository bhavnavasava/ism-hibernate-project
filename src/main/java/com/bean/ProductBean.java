package com.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer productId;
	String productName;

	@ManyToMany(cascade = { CascadeType.ALL })

	@JoinTable(name = "product_category", joinColumns = { @JoinColumn(name = "productId") }, inverseJoinColumns = {
			@JoinColumn(name = "categoryId") })

	List<CategoryBean> categories;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public List<CategoryBean> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryBean> categories) {
		this.categories = categories;
	}

}

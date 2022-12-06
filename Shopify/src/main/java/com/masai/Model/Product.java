package com.masai.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	@Column(length = 2500)
	private String productDesc;
	private String productPhoto;
	private Integer productPrice;
	private Integer productDiscount;
	private Integer productQnt;
	private Integer categoryid;
	
	
	
	public Product(String productName, String productDesc, String productPhoto, Integer productPrice,
			Integer productDiscount, Integer productQnt, Integer categoryid) {
		super();
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPhoto = productPhoto;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productQnt = productQnt;
		this.categoryid = categoryid;
	}



	@JsonIgnore
	@ManyToOne
	private Category category;
	
	
	
	
}

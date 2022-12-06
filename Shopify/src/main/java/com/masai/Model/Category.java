package com.masai.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	private String categorytitle;
	private String categoryDesc;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Product> products=new ArrayList<>();


	public Category(String categorytitle, String categoryDesc, List<Product> products) {
		super();
		this.categorytitle = categorytitle;
		this.categoryDesc = categoryDesc;
		this.products = products;
	}
	
}

package com.poly.lab5.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Categories")
public class Category implements Serializable {
	@Id
	@Pattern(regexp = "^C\\d{3}$", message = "{Pattern.category.id}")
	String id;
	@Column(name = "name", columnDefinition = "nvarchar(250)")
	@NotBlank(message = "{NotBlank.category.name}")
	String name;
	@OneToMany(mappedBy = "category")
	@JsonIgnore
	List<Product> products;
}
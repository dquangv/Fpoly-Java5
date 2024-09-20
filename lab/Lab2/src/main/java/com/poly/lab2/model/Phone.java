package com.poly.lab2.model;


import org.hibernate.validator.constraints.NotEmpty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="phone")
public class Phone {
	@Id
	int id;
	@NotNull
	String name;
	@DecimalMin("0")
	double price;
	Maker maker;
	Country country;
//	String image;
}

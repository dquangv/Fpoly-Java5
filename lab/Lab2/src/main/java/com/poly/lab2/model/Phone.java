package com.poly.lab2.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
	@NotNull
	String name;
	@DecimalMin("0")
	double price;
	Maker maker;
	Country country;
}

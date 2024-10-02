package com.poly.lab5.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "Products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	Double price;
	@Temporal(TemporalType.DATE)
	@Column(name = "Creationdate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date createDate = new Date();
	Boolean available;
	@ManyToOne @JoinColumn(name = "Categoryid")
	Category category;
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetais;
}

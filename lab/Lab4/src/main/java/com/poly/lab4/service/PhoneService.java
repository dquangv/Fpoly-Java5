package com.poly.lab4.service;

import java.util.List;

import com.poly.lab4.model.PhoneContact;

public interface PhoneService {
	public List<PhoneContact> add(PhoneContact phoneContact);
	public List<PhoneContact> update(String phoneNumber, PhoneContact phoneContact);
}

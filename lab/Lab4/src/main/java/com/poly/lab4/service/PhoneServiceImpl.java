package com.poly.lab4.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.lab4.model.Account;
import com.poly.lab4.model.PhoneContact;

@Service
public class PhoneServiceImpl  implements PhoneService {
	public static List<PhoneContact> list = new ArrayList<>();
	
	static {
        list.add(new PhoneContact("0101010101", "Quang", "bin","HCM"));
    }

	@Override
	public List<PhoneContact> add(PhoneContact phoneContact) {
		list.add(phoneContact);
		return list;
	}

	@Override
	public List<PhoneContact> update(String phoneNumber, PhoneContact phoneContact) {
		for (PhoneContact phone : list) {
			if (phone.getPhoneNumber().equals(phoneNumber)) {
				phone.setName(phoneContact.getName());
				phone.setNote(phoneContact.getNote());
				phone.setAddress(phoneContact.getAddress());
			}
		}
		return list;
	}
	
	
}

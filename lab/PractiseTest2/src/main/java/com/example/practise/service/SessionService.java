package com.example.practise.service;

public interface SessionService {
	public Object get(String key); //Get theo key trả về type
	public void set(String key, Object value); //set key là string, type tùy ý
	public void remove(String name);
}	

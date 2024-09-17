package com.poly.java5_asm.service.impl;

import com.poly.java5_asm.model.Session;
import com.poly.java5_asm.service.SessionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private static List<Session> listSession = new ArrayList<>();

    //get value from key
    @Override
    public Object get(String key) {
        Object value = null;

        if (key.isEmpty() || key == "") {
            return null;
        }

        for (Session item : listSession) {
            if (key.equalsIgnoreCase(item.getKey())) {
                value = item.getValue();
            }
        }

        return value;
    }

    //set new session, remove if existed and then create
    @Override
    public void set(String key, Object value) {

        for (int i = 0; i < listSession.size(); i++) {
            Session item = listSession.get(i);

            if (key.equalsIgnoreCase(item.getKey())) {
                listSession.remove(i);
            }
        }

        Session session = new Session();

        session.setKey(key);
        session.setValue(value);
        listSession.add(session);
    }
}

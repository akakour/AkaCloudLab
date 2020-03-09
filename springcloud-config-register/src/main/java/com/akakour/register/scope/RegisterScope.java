package com.akakour.register.scope;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RegisterScope implements Scope {

    private ConcurrentMap hoderMap = new ConcurrentHashMap();
    ;

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {

        if (hoderMap.containsKey(s)) {
            return hoderMap.get(s);
        }
        Object object = objectFactory.getObject();
        hoderMap.put(s, object);
        return object;
    }

    @Override
    public Object remove(String s) {
        return hoderMap.remove(s);
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}

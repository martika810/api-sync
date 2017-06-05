package com.test.homeaway.services;

public interface IService<K,T> {
    T add(T obj);
    T update(T obj);
    T read(K key);
    T delete(K key);

}

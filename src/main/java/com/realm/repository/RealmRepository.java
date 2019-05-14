package com.realm.repository;

import org.springframework.data.repository.CrudRepository;

import com.realm.model.UserRealm;

public interface RealmRepository extends CrudRepository<UserRealm, Long> {
	UserRealm findByName(String name);
}

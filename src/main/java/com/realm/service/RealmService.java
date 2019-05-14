package com.realm.service;

import com.realm.model.UserRealm;

public interface RealmService {
	UserRealm createRealm(String name, String description);
	UserRealm getById(Long id);

}

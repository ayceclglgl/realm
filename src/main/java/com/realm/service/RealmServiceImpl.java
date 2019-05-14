package com.realm.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.realm.exceptions.DuplicateRealmName;
import com.realm.exceptions.RealmNotFound;
import com.realm.model.UserRealm;
import com.realm.repository.RealmRepository;

@Service
public class RealmServiceImpl implements RealmService {
	
	RealmRepository repository;
	KeyService keyService;
	
	public RealmServiceImpl(RealmRepository repository, KeyService keyService) {
		this.repository = repository;
		this.keyService = keyService;
	}

	@Override
	public UserRealm createRealm(String name, String description) {
		UserRealm realm = repository.findByName(name);
		if(realm != null){
            throw new DuplicateRealmName();
        }
		UserRealm userRealm = new UserRealm(null,name,description,keyService.generateKey());
        return repository.save(userRealm);
	}

	@Override
	public UserRealm getById(Long id) {
		Optional<UserRealm> optionalUserRealm = repository.findById(id);
		return optionalUserRealm.orElseThrow(RealmNotFound::new);
	}

}

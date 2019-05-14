package com.realm.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.realm.model.UserRealm;
import com.realm.model.response.RealmResponse;

@Component
public class UserRealmToRealmResponse implements Converter<UserRealm, RealmResponse>{

	@Override
	public RealmResponse convert(UserRealm source) {
		RealmResponse realmResponse = new RealmResponse();
		realmResponse.setId(source.getId());
		realmResponse.setDescription(source.getDescription());
		realmResponse.setKey(source.getEncKey());
		realmResponse.setName(source.getName());
		return realmResponse;
	}

}

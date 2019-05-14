package com.realm.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.realm.exceptions.DuplicateRealmName;
import com.realm.exceptions.RealmNotFound;
import com.realm.model.UserRealm;
import com.realm.repository.RealmRepository;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

public class RealmServiceImplTest {

	RealmService service;
	
	@Mock
	RealmRepository repository;
	@Mock
	KeyService keyService;
	
	
	
	UserRealm userRealm;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new RealmServiceImpl(repository, keyService);
		
		userRealm = new UserRealm(1L, "Name", "Description", "");
	}
	
	
	@Test
	public void createRealmTest() {
		when(repository.findByName(anyString())).thenReturn(null);
		when(repository.save(any())).thenReturn(userRealm);
		
		UserRealm returnedUserRealm = service.createRealm("", "");
		assertNotNull(returnedUserRealm);
		assertEquals(Long.valueOf(1), returnedUserRealm.getId());
		assertEquals("Name", returnedUserRealm.getName());
		assertEquals("Description", returnedUserRealm.getDescription());
		verify(repository).findByName(anyString());
		verify(repository).save(any());
	}
	
	@Test(expected = DuplicateRealmName.class)
	public void createRealmTestDuplicateRealmName() {
		when(repository.findByName(anyString())).thenReturn(userRealm);
		
		UserRealm returnedUserRealm = service.createRealm("", "");
	}
	
	@Test
	public void getByIdTest() {
		when(repository.findById(anyLong())).thenReturn(Optional.of(userRealm));
		
		UserRealm returnedUserRealm = service.getById(anyLong());
		assertNotNull(returnedUserRealm);
		assertEquals(Long.valueOf(1), returnedUserRealm.getId());
		assertEquals("Name", returnedUserRealm.getName());
		assertEquals("Description", returnedUserRealm.getDescription());
		assertEquals("", returnedUserRealm.getKey());
		verify(repository).findById(anyLong());
		
	}
	
	@Test(expected = RealmNotFound.class)
	public void getByIdTestRealmNotFound() {
		Optional<UserRealm> optionalUserRealm = Optional.empty();
		
		when(repository.findById(anyLong())).thenReturn(optionalUserRealm);
		
		UserRealm returnedUserRealm = service.getById(anyLong());
	}





}

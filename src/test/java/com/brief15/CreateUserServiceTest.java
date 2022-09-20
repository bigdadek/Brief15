package com.brief15;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.soussHOApp.entities.Users;
import com.soussHOApp.repositories.UserRepository;
import com.soussHOApp.services.UserService;

import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
	public class CreateUserServiceTest {

	    @Mock
	    private UserRepository userRepository;

	    @InjectMocks
	    private UserService createUserService;

	    @Test
	    public void whenSaveUser_shouldReturnUser() {
	        Users users = new Users();
	        users.setFullName("Test Name");
	      

	        when(userRepository.save(ArgumentMatchers.any(Users.class))).thenReturn(users);

	        Users created = createUserService.createNewUser(users);

	        assertThat(created.getFullName()).isSameAs(users.getFullName());
	        verify(userRepository).save(users);
	    }
	}


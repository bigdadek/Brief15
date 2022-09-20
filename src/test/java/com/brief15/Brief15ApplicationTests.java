package com.brief15;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.brief15.entities.User;
import com.soussHOApp.repositories.UserRepository;
import com.soussHOApp.services.UserService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class Brief15ApplicationTests {

	 @Mock
	    private UserRepository userRepository;

	    @InjectMocks
	    private UserService userService;
	    
	    @Test
	    public void shouldReturnAllUsers() {
	        List<User> users = new ArrayList();
	        users.add(new User());

	        given(userRepository.findAll()).willReturn(users);

	        List<User> expected = userService.listAllUsers();

	        assertEquals(expected, users);
	        verify(userRepository).findAll();
	    }

	   /* @Test
	    public void whenSaveUser_shouldReturnUser() {
	        User user = new User();
	        user.setId(1L);
	        user.setFullName("Test Name");
	        user.setEmail("fjvhdfkjh");
	        user.setPhone("06------");
	        user.setUserName("bigdq");
	        user.setPassword("hihihoho");


	        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

	        User created = createUserService.createNewUser(user);

	        assertThat(created.getFullName()).isSameAs(user.getFullName());
	        verify(userRepository).save(user);
	    }
	    */
	    
	  

	   
	}
	

}

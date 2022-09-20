package com.brief15.userDetails;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.soussHOApp.entities.Users;
import com.soussHOApp.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
 

//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//
//        Utilisateur user = userRepository.getUserByUsername(login);
//        if (user == null) {
//            throw new UsernameNotFoundException("User Not Found");
//        }
//        return new CustomUserDetails(user);
//    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Users appUser = userRepository.getUserByUsername(login);

        /*
         * Collection<GrantedAuthority> authorities=new ArrayList();
         * appUser.getAppRoles().forEach(role-> {
         * 
         * SimpleGrantedAuthority authority=new
         * SimpleGrantedAuthority(role.getRoleName()); authorities.add(authority); });
*/
        Collection<GrantedAuthority> authorities = appUser.getPermissions().stream()
                .map(approle -> new SimpleGrantedAuthority(approle.getName())).collect(Collectors.toList());
       User  user = new User(appUser.getLogin(), appUser.getPassword(), authorities);
        return user;
    }
}

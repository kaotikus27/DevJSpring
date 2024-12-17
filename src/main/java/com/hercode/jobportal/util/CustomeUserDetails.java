package com.hercode.jobportal.util;

import java.util.*;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hercode.jobportal.entity.Users;
import com.hercode.jobportal.entity.UsersType;

public class CustomeUserDetails implements UserDetails {

	 private Users user;

	    public CustomeUserDetails(Users user) {
	        this.user = user;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        UsersType usersType = user.getUserTypeId();
	        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	        authorities.add(new SimpleGrantedAuthority(usersType.getUserTypeName()));
	        return authorities;
	    }

	    @Override
	    public String getPassword() {
	        return user.getPassword();
	    }

	    @Override
	    public String getUsername() {
	        return user.getEmail();
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }
	
}

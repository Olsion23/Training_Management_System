package com.sda.training_management_system.security;

import com.sda.training_management_system.dao.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails{


        private String username;
        private String password;
        private Boolean active;
        private List<GrantedAuthority> roles;


        public UserDetailsImpl(User user){
            this.username = user.getLogin();
            this.password = user.getPassword();
            this.active = user.getActive();

            this.roles = List.of(new SimpleGrantedAuthority(user.getRole().getRoleId()));
        }
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return roles;
        }

        @Override
        public String getPassword() {
            return this.password;
        }

        @Override
        public String getUsername() {
            return this.username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return this.active;
        }

        @Override
        public boolean isAccountNonLocked() {
            return this.active;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return this.active;
        }

        @Override
        public boolean isEnabled() {
            return this.active;
        }
    }



package com.allanimt.springboot.security;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotEmpty;
import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.Date;

public class AppUser implements UserDetails {

    @Id
    private String id;

    @NotEmpty
    private String email;

    @NotEmpty
    private String name;

    @NotEmpty
    @JsonIgnore
    private String password;

    private Date created;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public AppUser(@NotEmpty String email, @NotEmpty String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.created = new Date();
    }

    public AppUser() {
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

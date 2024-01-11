package com.example.casemodule4.service.impl;

import com.example.casemodule4.model.Users;
import com.example.casemodule4.repository.IUserRepository;
import com.example.casemodule4.security.UserPrinciple;
import com.example.casemodule4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService, IUserService {
    @Autowired
    private IUserRepository userRepository;

    public Users findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    public UserDetails loadUserByUsername(String username) {
        return UserPrinciple.build(userRepository.findByUsername(username));
    }

    @Override
    public Page findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Object findById(Long id) {
        return null;
    }
}

package com.example.casemodule4.service.impl;

import com.example.casemodule4.repository.IUserRepository;
import com.example.casemodule4.security.UserPrinciple;
import com.example.casemodule4.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
@Service
public class UserService implements  IUserService, UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
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

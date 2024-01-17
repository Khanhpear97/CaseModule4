package com.example.casemodule4.service.impl;

import com.example.casemodule4.model.Role;
import com.example.casemodule4.model.Users;
import com.example.casemodule4.repository.IRoleRepository;
import com.example.casemodule4.repository.IUserRepository;
import com.example.casemodule4.service.IUserService;
import com.example.casemodule4.userRegister.UserRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService implements  IUserService {
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


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


    public Users findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void register(UserRegister userRegister){
        Users users = new Users();
        users.setUsername(userRegister.getUsername());
        users.setPassword(passwordEncoder.encode(userRegister.getPassword()));
        users.setEmail(userRegister.getEmail());
        users.setName(userRegister.getName());
        users.setAge(userRegister.getAge());
        users.setPhone(userRegister.getPhone());
        Role role = roleRepository.findByName("ROLE_CUSTOMER");
        if (role == null) {
            role = checkRoleExist();
        }
        users.setRoles(Arrays.asList(role));
        userRepository.save(users);
    }

    public Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_CUSTOMER");
        return roleRepository.save(role);
    }
}

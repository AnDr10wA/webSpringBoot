package com.kata.webSpring.service;

import com.kata.webSpring.repository.UserRepository;
import com.kata.webSpring.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User findById(Long id){
        return userRepository.getOne(id);
    }
    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }
    @Override
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}

package com.example.backend.service;


import com.example.backend.dto.UserCreateDTO;
import com.example.backend.dto.UserViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements   UserService{
    //dto ile haberleşicek
    private final UserRepository userRepository;

    @Override
     public UserViewDTO getUserById(long id) {
       final User user= userRepository.findById(id).orElseThrow(() -> new NotFoundException("not found exception"));
        return UserViewDTO.of(user);
    }

    @Override
    public UserViewDTO createUser( UserCreateDTO userCreateDTO) {
        final  User user= userRepository.save(new User(userCreateDTO.getFirstName(),userCreateDTO.getLastName()));

        return UserViewDTO.of(user) ;
    }


}

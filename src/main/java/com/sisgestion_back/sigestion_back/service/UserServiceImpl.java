package com.sisgestion_back.sigestion_back.service;

import com.sisgestion_back.sigestion_back.Enum.ERole;
import com.sisgestion_back.sigestion_back.mapper.UserMapper;
import com.sisgestion_back.sigestion_back.model.dto.UserProfileDTO;
import com.sisgestion_back.sigestion_back.model.dto.UserRegistrationDTO;
import com.sisgestion_back.sigestion_back.model.entity.Personal;
import com.sisgestion_back.sigestion_back.model.entity.Role;
import com.sisgestion_back.sigestion_back.model.entity.User;
import com.sisgestion_back.sigestion_back.repository.PersonalRepository;
import com.sisgestion_back.sigestion_back.repository.RoleRepository;
import com.sisgestion_back.sigestion_back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PersonalRepository personalRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserProfileDTO registerUser(UserRegistrationDTO userRegistrationDTO) {
        return registerUserWithRole(userRegistrationDTO, ERole.SECRETARIO); // corregir para que se haga con roles en userservice
    }

    @Override
    public UserProfileDTO updateUser(long userPk, UserProfileDTO userProfileDTO) {
        return null;
    }

    @Override
    public UserProfileDTO getUserById(long userPk) {
        return null;
    }

    private UserProfileDTO registerUserWithRole(UserRegistrationDTO userRegistrationDTO, ERole roleEnum) {

        //verificar si el email existe o si hay usuario con nombre y apellido

        boolean existByXcorreoInstitucional = userRepository.existsByXcorreoInstitucional(userRegistrationDTO.getXcorreoInstitucional());
        boolean existAsPersonal = personalRepository.existsByXnombreAndXapellido(userRegistrationDTO.getXnombre(), userRegistrationDTO.getXapellido());


        if (existByXcorreoInstitucional) {
            throw new IllegalArgumentException("Ya existe un usuario con ese correo");
        }


        if (existAsPersonal) {
            throw new IllegalArgumentException("Ya existe un usuario con ese nombre y apellido");
        }

        Role role = roleRepository.findByName(roleEnum)
                .orElseThrow(() -> new IllegalArgumentException("Error: Rol no existe"));


        userRegistrationDTO.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));

        User user = userMapper.toUserEntity(userRegistrationDTO);
        user.setRole(role);

        if (roleEnum == ERole.SECRETARIO) {
            Personal personal  = new Personal();
            personal.setXnombre(userRegistrationDTO.getXnombre());
            personal.setXapellido(userRegistrationDTO.getXapellido());
            personal.setFFechaRegistro(LocalDateTime.now());
            personal.setUser(user);
            user.setPersonal(personal);

        } else if (roleEnum == ERole.GENERAL) {
            Personal personal  = new Personal();
            personal.setXnombre(userRegistrationDTO.getXnombre());
            personal.setXapellido(userRegistrationDTO.getXapellido());
            personal.setFFechaRegistro(LocalDateTime.now());
            personal.setUser(user);
            user.setPersonal(personal);
        }

        User savedUser = userRepository.save(user);

        return userMapper.toUserProfileDTO(savedUser);
    }



}

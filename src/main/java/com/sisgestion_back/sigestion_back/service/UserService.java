package com.sisgestion_back.sigestion_back.service;

import com.sisgestion_back.sigestion_back.model.dto.AuthResponseDTO;
import com.sisgestion_back.sigestion_back.model.dto.LoginDTO;
import com.sisgestion_back.sigestion_back.model.dto.UserProfileDTO;
import com.sisgestion_back.sigestion_back.model.dto.UserRegistrationDTO;

public interface UserService {
    UserProfileDTO registerSecretario(UserRegistrationDTO userRegistrationDTO);

    UserProfileDTO registerGeneral(UserRegistrationDTO userRegistrationDTO);

    UserProfileDTO updateUser(long userPk, UserProfileDTO userProfileDTO);

    UserProfileDTO getUserById(long userPk);

    //Para Login
    AuthResponseDTO login(LoginDTO loginDTO);

}

package com.sisgestion_back.sigestion_back.service;

import com.sisgestion_back.sigestion_back.model.dto.UserProfileDTO;
import com.sisgestion_back.sigestion_back.model.dto.UserRegistrationDTO;

public interface UserService {
    UserProfileDTO registerUser(UserRegistrationDTO userRegistrationDTO);

    UserProfileDTO updateUser(long userPk, UserProfileDTO userProfileDTO);

    UserProfileDTO getUserById(long userPk);


}

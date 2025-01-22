package org.TicketBooking.service;

import org.TicketBooking.model.UserResponse;
import org.TicketBooking.model.dto.EmailRequestDto;
import org.TicketBooking.model.dto.UserRequestDto;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserService {

    ConcurrentHashMap<String, String> emailAddressToUserIdMap = new ConcurrentHashMap<>();

    public UserResponse registerUser(UserRequestDto userRequestDto){
        String userId = UUID.randomUUID().toString();
        String emailAddress = userRequestDto.getEmailAddress();
        emailAddressToUserIdMap.putIfAbsent(emailAddress, userId);
        return getResponseFromDto(userRequestDto, userId);
    }

    public String getUserIdFromEmail(EmailRequestDto emailRequestDto){
        String emailId = emailRequestDto.getEmailAddress();
        if(emailAddressToUserIdMap.containsKey(emailId)){
            return emailAddressToUserIdMap.get(emailId);
        }
        throw new RuntimeException("Email Address Not Registered with system :  " + emailId);
    }

    private UserResponse getResponseFromDto(UserRequestDto userRequestDto, String userId) {
        return new UserResponse().setUserId(userId)
                .setUserName(userRequestDto.getUserName())
                .setUserType(userRequestDto.getUserType())
                .setEmailAddress(userRequestDto.getEmailAddress())
                .setMobileNumber(userRequestDto.getMobileNumber());
    }

}

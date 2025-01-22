package org.TicketBooking.model.dto;

import lombok.Data;
import org.TicketBooking.model.enums.UserType;

@Data
public class UserRequestDto {

    private String userName;

    private UserType userType;

    private String emailAddress;

    private String mobileNumber;
}

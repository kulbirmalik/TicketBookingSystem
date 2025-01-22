package org.TicketBooking.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.TicketBooking.model.enums.UserType;

@Data
@Accessors(chain = true)
public class UserResponse {

    private String userId;

    private String userName;

    private UserType userType;

    private String emailAddress;

    private String mobileNumber;

}

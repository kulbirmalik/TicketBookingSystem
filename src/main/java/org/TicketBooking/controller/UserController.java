package org.TicketBooking.controller;


import lombok.RequiredArgsConstructor;
import org.TicketBooking.model.dto.EmailRequestDto;
import org.TicketBooking.model.dto.UserRequestDto;
import org.TicketBooking.model.UserResponse;
import org.TicketBooking.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.registerUser(userRequestDto));
    }

    @PostMapping("/email")
    public ResponseEntity<String> getUserIdFromEmail(@RequestBody EmailRequestDto emailRequestDto){
        return ResponseEntity.ok(userService.getUserIdFromEmail(emailRequestDto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserFromId(@PathVariable("userId") String userId){
        return ResponseEntity.ok(userService.getUserResponseFromId(userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable("userId") String userId){
        return ResponseEntity.ok(userService.deleteUser(userId));
    }

}

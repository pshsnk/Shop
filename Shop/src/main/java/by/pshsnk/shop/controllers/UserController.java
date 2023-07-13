package by.pshsnk.shop.controllers;

import by.pshsnk.shop.dto.UserDTO;
import by.pshsnk.shop.mappers.UserMapper;
import by.pshsnk.shop.models.User;
import by.pshsnk.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("shop/user")
@CrossOrigin
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getUserProfile() {

        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserProfile(@PathVariable("userId") String userId) {

        return new ResponseEntity<>(userService.getUserById(Long.parseLong(userId)), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<UserDTO> getCurrentUser(Principal principal){
        User user = userService.getCurrentUser(principal);
        UserDTO userDTO = UserMapper.INSTANCE.toDTO(user);
        return new ResponseEntity<>(userDTO,  HttpStatus.OK);
    }
}

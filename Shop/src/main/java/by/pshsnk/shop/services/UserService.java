package by.pshsnk.shop.services;

import by.pshsnk.shop.dto.UserDTO;
import by.pshsnk.shop.mappers.UserMapper;
import by.pshsnk.shop.models.User;
import by.pshsnk.shop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    //////Надо переделать метод с использованием Stream API
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for(int i=0; i<users.size(); i++){
            userDTOS.add(UserMapper.INSTANCE.toDTO(users.get(i)));
        }
        return userDTOS;
    }

    public UserDTO getUserById(Long id) {

        return UserMapper.INSTANCE.toDTO(userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }

    public User updateUser(UserDTO userDTO, Principal principal){
        User user = getUserByPrincipal(principal);
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        return userRepository.save(user);

    }

    public User getCurrentUser(Principal principal){
        return getUserByPrincipal(principal);
    }

    private User getUserByPrincipal(Principal principal){
        String username = principal.getName();
        return userRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }

}

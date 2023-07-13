package by.pshsnk.shop.payload.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class SignupRequest {
  private String email;
  @NotEmpty(message = "Please enter your name")
  private String firstname;
  @NotEmpty(message = "Please enter your lastname")
  private String lastname;
  @NotEmpty(message = "Please enter your username")
  private String username;
  @NotEmpty(message = "Password is required")
  @Size(min = 6)
  private String password;


}

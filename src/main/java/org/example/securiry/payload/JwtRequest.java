package org.example.securiry.payload;


import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class JwtRequest {
    private String email;
    private  String  password;
}

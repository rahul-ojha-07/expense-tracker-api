package io.github.rahulojha07.expensetrackerapi.resources;

import io.github.rahulojha07.expensetrackerapi.Constants;
import io.github.rahulojha07.expensetrackerapi.domain.User;
import io.github.rahulojha07.expensetrackerapi.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserResources {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> loginUser(@RequestBody Map<String ,Object> userMap) {
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");

        User user = userService.validateUser(email,password);
        Map<String,String> map = generateJWTToken(user);
        return new ResponseEntity<>(map, HttpStatus.OK);

    }


    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody Map<String,Object> userMap) {

        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        System.out.println(firstName + lastName + email + password);
        User user =  userService.registerUser(firstName,lastName,email,password);
        Map<String,String> map = new HashMap<>();
        map.put("message","registered successfully!");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<Map<String,String>> getAllUsers(@RequestBody Map<String ,Object> userMap) {
        Map<String,String> map = new HashMap<>();
        map.put("message","registered successfully!");
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

    private Map<String ,String> generateJWTToken(User user) {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256,Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp+Constants.TOKEN_VALIDITY))
                .claim("userId",user.getUserId())
                .claim("email",user.getEmail())
                .claim("firstName", user.getFirstName())
                .claim("lastName",user.getLastName())
                .compact();
        Map<String ,String > map = new HashMap<>();
        map.put("token",token);
        return map;
    }
}

package in.purabtech.ep.controller;

import in.purabtech.ep.dao.UserDao;
import in.purabtech.ep.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/users")
    public List<UserDto> users() {
        return userDao.getUsers();
    }

    @PostMapping(value = "/users")
    public ResponseEntity<UserDto> addUsers(@RequestBody UserDto userDto) {
        //System.out.println(userDto);
        UserDto created = userDao.addUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}

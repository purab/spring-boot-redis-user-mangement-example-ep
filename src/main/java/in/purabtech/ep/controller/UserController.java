package in.purabtech.ep.controller;

import in.purabtech.ep.dao.UserDao;
import in.purabtech.ep.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/")
@Slf4j
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/users")
    public List<UserDto> users() {
        log.info("Calling Controller to get Users data...");
        return userDao.getUsers();
    }

    @PostMapping(value = "/users")
    public ResponseEntity<UserDto> addUsers(@RequestBody UserDto userDto) {
        //System.out.println(userDto);
        UserDto created = userDao.addUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}

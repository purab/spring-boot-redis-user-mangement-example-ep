package in.purabtech.ep.controller;

import in.purabtech.ep.dao.UserDao;
import in.purabtech.ep.dto.UserDto;
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
    public void addUsers(@RequestBody UserDto userDto) {
        //System.out.println(userDto);
        userDao.addUser(userDto);
    }
}

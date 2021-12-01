package in.purabtech.ep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(value = "/users")
    public String users() {
        return "User List not available not yet!!!";
    }
}

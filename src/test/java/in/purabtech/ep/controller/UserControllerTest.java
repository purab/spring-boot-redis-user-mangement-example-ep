package in.purabtech.ep.controller;

import in.purabtech.ep.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void givenUsers_GetUsersEndPoint_ShouldReturnUsersList() {
        String baseUrl = "http://localhost:"+port+"/users";
        ResponseEntity<UserDto[]> response = restTemplate.getForEntity(baseUrl, UserDto[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        //check body of users body length
        assertThat(response.getBody().length).isGreaterThanOrEqualTo(2);
    }

    @Test
    void givenNewUsers_PostUsersEndPoint_ShouldAddNewUser() {
        String baseUrl = "http://localhost:"+port+"/users";

        UserDto user1 = UserDto.builder().userId(1L).name("purab").phone(12345678).address("first user").build();

        ResponseEntity<UserDto> response = restTemplate.postForEntity(baseUrl, user1, UserDto.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        UserDto newDto = response.getBody();

        assertThat(newDto).isNotNull();

        assertEquals(user1.getName(), newDto.getName(),"Product name should be same!!");

        //check body of users body length
        //assertThat(response.getBody().length).isGreaterThanOrEqualTo(2);
    }
}
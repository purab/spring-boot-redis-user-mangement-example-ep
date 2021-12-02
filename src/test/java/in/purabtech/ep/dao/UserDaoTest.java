package in.purabtech.ep.dao;

import in.purabtech.ep.dto.UserDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void givenPrepopulatedData_getUser_shouldReturnUserList(){
        UserDao dao = new UserDao();
        assertThat(dao.getUsers().size()).isEqualTo(2);
    }

    @Test
    void givenANewUserDto_addProduct_ShouldAddAndReturnDtoWithUserId()  {
        UserDao dao = new UserDao();
        assertThat(dao.getUsers().size()).isEqualTo(2);
        UserDto userThird = UserDto.builder().userId(1L).name("purab3").phone(12345678).address("third user").build();

        UserDto createdDto = dao.addUser(userThird);

        assertThat(dao.getUsers().size()).isEqualTo(3);
        assertThat(createdDto.getUserId()).isNotNull();
    }
}
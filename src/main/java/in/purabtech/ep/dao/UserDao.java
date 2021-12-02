package in.purabtech.ep.dao;

import in.purabtech.ep.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserDao {

    private final List<UserDto> userList = new ArrayList<>();

    public UserDao() {
        userList.add(UserDto.builder().userId(1L).name("purab").phone(12345678).address("first user").build());
        userList.add(UserDto.builder().userId(2L).name("purab2").phone(12345678).address("second user").build());
    }

    public List<UserDto> getUsers() {
        return userList;
    }

    public UserDto addUser(UserDto user) {
        user.setUserId(generateUniqueId());
        System.out.println(user);
        userList.add(user);
        return user;
    }

    //generate random unique number
    private static Long generateUniqueId() {
        Long val = -1L;
        final UUID uid = UUID.randomUUID();
        final ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
        buffer.putLong(uid.getLeastSignificantBits());
        buffer.putLong(uid.getMostSignificantBits());
        final BigInteger bi = new BigInteger(buffer.array());
        val = bi.longValue() & Long.MAX_VALUE;
        return val;
    }
}

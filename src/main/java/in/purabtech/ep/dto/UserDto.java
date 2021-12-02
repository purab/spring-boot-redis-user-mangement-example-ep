package in.purabtech.ep.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class UserDto implements Serializable{
    private Long userId;
    private String name;
    private double phone;
    private String address;
}

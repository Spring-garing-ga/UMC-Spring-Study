package umc.study.spring.web.dto;

import lombok.Getter;

import java.time.LocalDateTime;

public class UserRequestDTO {

    @Getter
    public static class JoinDto{
        String name;
        int gender;
        LocalDateTime birth;
        int zip_code;
        String detail;
        String address;
    }
}
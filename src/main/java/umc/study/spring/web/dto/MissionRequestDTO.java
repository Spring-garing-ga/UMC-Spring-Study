package umc.study.spring.web.dto;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import umc.study.spring.validation.annotation.ExistStore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MissionRequestDTO {
    @Getter
    public static class AddMissionDTO{
        @NotBlank
        String title;
        @NotNull
        Integer goal;
        @NotNull
        Integer point;
        @NotNull
        String description;
        @ExistStore
        Long storeId;
        @NotNull
        LocalDateTime deadline;
    }
}

package umc.study.spring.web.dto;

import lombok.Getter;

@Getter
public class AddressRequestDTO {
    public AddressRequestDTO(int zip_code, String address, String detail, int type) {
        this.zip_code = zip_code;
        this.address = address;
        this.detail = detail;
        this.type = type;
    }

    int zip_code;
    String address;
    String detail;
    int type;

}
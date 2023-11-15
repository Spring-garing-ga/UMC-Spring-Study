package umc.study.spring.dto;

import lombok.Getter;
@Getter
public class AddressDTO {

    public AddressDTO(int zip_code, String address, String detail, int type) {
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

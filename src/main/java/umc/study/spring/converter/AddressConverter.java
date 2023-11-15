package umc.study.spring.converter;

import umc.study.spring.domain.Address;
import umc.study.spring.web.dto.AddressRequestDTO;

public class AddressConverter {

    public static Address toAddress(AddressRequestDTO request){

        return Address.builder()
                .zip_code(request.getZip_code())
                .address(request.getAddress())
                .detail(request.getDetail())
                .type(request.getType())
                .build();
    }
}
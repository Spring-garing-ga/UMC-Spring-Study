package umc.study.spring.convertor;

import umc.study.spring.domain.Address;
import umc.study.spring.dto.AddressDTO;

public class AddressConverter {

    public static Address toAddress(AddressDTO request){
        return Address.builder()
                .address(request.getAddress())
                .zip_code(request.getZip_code())
                .detail(request.getDetail())
                .type(request.getType())
                .build();
    }
}

package umc.study.spring.converter;

import umc.study.spring.domain.Address;
import umc.study.spring.domain.Category;
import umc.study.spring.domain.Store;
import java.time.LocalDateTime;

import umc.study.spring.web.dto.CategoryRequestDTO;
import umc.study.spring.web.dto.StoreRequestDTO;
import umc.study.spring.web.dto.StoreResponseDTO;
import umc.study.spring.web.dto.AddressRequestDTO;
public class StoreConverter {
    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store){
        return StoreResponseDTO.JoinResultDTO.builder()
                .name(store.getName())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDto request){

        AddressRequestDTO addressRequestDTO = new AddressRequestDTO(request.getZip_code(), request.getAddress(), request.getDetail(), 0);
        Address address = AddressConverter.toAddress(addressRequestDTO);

        CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO(request.getCategory_name());
        Category category = CategoryConverter.toCategory(categoryRequestDTO);


        return Store.builder()
                .address(address)
                .name(request.getName())
                .category(category)
                .build();
    }
}

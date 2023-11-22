package umc.study.spring.converter;

import org.springframework.data.domain.Page;
import umc.study.spring.domain.Address;
import umc.study.spring.domain.Category;
import umc.study.spring.domain.Review;
import umc.study.spring.domain.Store;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import umc.study.spring.web.dto.*;

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

        return Store.builder()
                .address(address)
                .name(request.getName())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO toReviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getNickname())
                .score(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getContent())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> reviewList){
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::toReviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

}

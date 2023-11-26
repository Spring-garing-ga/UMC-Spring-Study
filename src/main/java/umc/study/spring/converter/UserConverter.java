package umc.study.spring.converter;

import umc.study.spring.domain.Address;
import umc.study.spring.domain.Review;
import umc.study.spring.domain.User;
import umc.study.spring.domain.enums.Gender;
import umc.study.spring.web.dto.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hibernate.boot.model.process.spi.MetadataBuildingProcess.build;


public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDTO request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        AddressRequestDTO addressDTO = new AddressRequestDTO(request.getZip_code(),request.getAddress(),request.getDetail(),0);
        Address address = AddressConverter.toAddress(addressDTO);


        return User.builder()
                .address(address)
                .gender(gender)
                .name(request.getName())
                .birth(request.getBirth())
                .nickname(request.getNickname())
                .term(request.getTerm())
                .userPreferList(new ArrayList<>())
                .build();
    }

    public static Review toReview(UserRequestDTO.ReviewDTO request) {
        return Review.builder()
                .id(request.getId())
                .content(request.getContent())
                .rating(request.getRating())
                .build();
    }

    public static UserResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return UserResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static UserResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return UserResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getNickname())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt())
                .content(review.getContent())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(List<Review> reviewList){
        List<UserResponseDTO.ReviewPreViewDTO> reviewPreViewList = reviewList.stream()
                .map(UserConverter::reviewPreViewDTO).collect(Collectors.toList());

        return UserResponseDTO.ReviewPreViewDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}

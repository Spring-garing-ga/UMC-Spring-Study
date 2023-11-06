package umc.study.spring.apiPayLoad.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.study.spring.apiPayLoad.code.BaseErrorCode;
import umc.study.spring.apiPayLoad.code.ErrorReasonDTO;
@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    //일반적인 응답
    _OK(HttpStatus.OK, "COMMON200", "성공입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return null;
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return null;
    }
}

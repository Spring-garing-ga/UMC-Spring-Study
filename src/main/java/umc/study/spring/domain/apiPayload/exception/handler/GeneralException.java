package umc.study.spring.domain.apiPayload.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.study.spring.domain.apiPayload.code.BaseErrorCode;
import umc.study.spring.domain.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}

package umc.study.spring.domain.apiPayload.exception.handler.handler;

import umc.study.spring.domain.apiPayload.code.BaseErrorCode;

public class TempHandler extends GeneralException{

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}

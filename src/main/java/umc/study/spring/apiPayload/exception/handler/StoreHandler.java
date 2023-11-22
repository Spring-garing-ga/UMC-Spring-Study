package umc.study.spring.apiPayload.exception.handler;

import umc.study.spring.apiPayload.exception.GeneralException;
import umc.study.spring.apiPayload.code.BaseErrorCode;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode code) {
        super(code);
    }
}

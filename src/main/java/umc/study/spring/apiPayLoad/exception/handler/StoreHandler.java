package umc.study.spring.apiPayLoad.exception.handler;

import umc.study.spring.apiPayLoad.code.BaseErrorCode;
import umc.study.spring.apiPayLoad.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode code) {
        super(code);
    }
}

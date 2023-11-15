package umc.study.spring.apiPayLoad.execption.handler;

import umc.study.spring.apiPayLoad.code.BaseErrorCode;
import umc.study.spring.apiPayLoad.execption.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode code) {
        super(code);
    }
}

package umc.study.spring.apiPayLoad.exception.handler;

import umc.study.spring.apiPayLoad.code.BaseErrorCode;
import umc.study.spring.apiPayLoad.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode code) {
        super(code);
    }
}

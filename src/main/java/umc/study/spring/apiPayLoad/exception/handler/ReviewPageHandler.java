package umc.study.spring.apiPayLoad.exception.handler;

import umc.study.spring.apiPayLoad.code.BaseErrorCode;
import umc.study.spring.apiPayLoad.exception.GeneralException;

public class ReviewPageHandler extends GeneralException {
    public ReviewPageHandler(BaseErrorCode code) {
        super(code);
    }
}

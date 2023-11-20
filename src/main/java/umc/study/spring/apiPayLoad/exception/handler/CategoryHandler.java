package umc.study.spring.apiPayLoad.exception.handler;

import umc.study.spring.apiPayLoad.code.BaseErrorCode;
import umc.study.spring.apiPayLoad.exception.GeneralException;

public class CategoryHandler extends GeneralException {
    public CategoryHandler(BaseErrorCode code) {
        super(code);
    }
}

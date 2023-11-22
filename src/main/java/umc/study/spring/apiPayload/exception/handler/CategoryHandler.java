package umc.study.spring.apiPayload.exception.handler;

import umc.study.spring.apiPayload.code.BaseErrorCode;
import umc.study.spring.apiPayload.exception.GeneralException;

public class CategoryHandler extends GeneralException {
    public CategoryHandler(BaseErrorCode code) {
        super(code);
    }
}

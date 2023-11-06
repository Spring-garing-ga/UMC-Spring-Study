package umc.study.spring.apiPayLoad.code.status;

import umc.study.spring.apiPayLoad.code.BaseCode;
import umc.study.spring.apiPayLoad.code.ReasonDTO;

public enum SuccessStatus implements BaseCode {
    ;

    @Override
    public ReasonDTO getReason() {
        return null;
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return null;
    }
}

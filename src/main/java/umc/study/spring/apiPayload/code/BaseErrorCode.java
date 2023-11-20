package umc.study.spring.apiPayLoad.code;


import umc.study.spring.apiPayLoad.code.ErrorReasonDTO;

public interface BaseErrorCode {
    public ErrorReasonDTO getReason();
    public ErrorReasonDTO getReasonHttpStatus();
}

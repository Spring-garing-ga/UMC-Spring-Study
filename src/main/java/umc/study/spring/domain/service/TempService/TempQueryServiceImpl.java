package umc.study.spring.domain.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.spring.domain.apiPayload.code.status.ErrorStatus;
import umc.study.spring.domain.apiPayload.exception.handler.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}


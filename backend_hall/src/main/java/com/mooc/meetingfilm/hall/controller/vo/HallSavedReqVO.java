package com.mooc.meetingfilm.hall.controller.vo;

import com.mooc.meetingfilm.utils.common.vo.BaserRequestVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.hall.controller.vo
 * @description :
 **/
@Data
public class HallSavedReqVO extends BaserRequestVO {

    private String cinemaId;
    private String filmId;
    private String hallTypeId;
    private String beginTime;
    private String endTime;
    private String filmPrice;
    private String hallName;

    @Override
    public void checkParam() throws CommonServiceException {

    }
}

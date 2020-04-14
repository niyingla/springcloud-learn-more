package com.mooc.meetingfilm.hall.controller.vo;

import lombok.Data;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.hall.controller.vo
 * @description :
 **/
@Data
public class HallsRespVO {

    private String cinemaName;
    private String hallName;
    private String filmName;
    private String hallTypeName;
    private String beginTime;
    private String endTime;
    private String filmPrice;


}

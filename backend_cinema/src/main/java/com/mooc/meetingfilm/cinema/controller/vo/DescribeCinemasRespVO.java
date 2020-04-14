package com.mooc.meetingfilm.cinema.controller.vo;

import lombok.Data;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.cinema.controller.vo
 * @description :
 **/
@Data
public class DescribeCinemasRespVO {

    private String brandId;
    private String areaId;
    private String hallTypeIds;
    private String cinemaName;
    private String cinemaAddress;
    private String cinemaTele;
    private String cinemaImgAddress;
    private String cinemaPrice;

}

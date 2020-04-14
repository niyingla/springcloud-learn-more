package com.mooc.meetingfilm.film.controller.vo;

import lombok.Data;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.film.controller.vo
 * @description : 查询影片列表接口返回对象
 **/
@Data
public class DescribeFilmsRespVO{

    private String filmId;
    private String filmStatus;
    private String filmName;
    private String filmEnName;
    private String filmScore;
    private String preSaleNum;
    private String boxOffice;
    private String filmTime;
    private String filmLength;
    private String mainImg;

}

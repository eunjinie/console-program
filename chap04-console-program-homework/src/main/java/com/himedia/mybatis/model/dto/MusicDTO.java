package com.himedia.mybatis.model.dto;

import java.util.Date;

public class MusicDTO {

    private int no;
    private String name;
    private String genre;
    private String singer;
    private int themeCode;

    public MusicDTO() {
    }

    public MusicDTO(int no, String name, String genre, String singer, int themeCode) {
        this.no = no;
        this.name = name;
        this.genre = genre;
        this.singer = singer;
        this.themeCode = themeCode;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getThemeCode() {
        return themeCode;
    }

    public void setThemeCode(int themeCode) {
        this.themeCode = themeCode;
    }

    @Override
    public String toString() {
        return "MusicDTO{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", singer='" + singer + '\'' +
                ", themeCode=" + themeCode +
                '}';
    }
}

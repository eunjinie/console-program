package com.himedia.mybatis.view;

import com.himedia.mybatis.model.dto.MusicDTO;

import java.util.List;

public class PrintResult {
    public void printMusicList(List<MusicDTO> musicList) { musicList.forEach(System.out::println);}

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch(errorCode){
            case "selectAllList" : errorMessage = "플레이리스트 목록 조회에 실패하였습니다."; break;
            case "selectListByGenre" : errorMessage = "일치하는 장르의 노래를 찾을 수 없습니다."; break;
            case "searchMusic" : errorMessage = "일치하는 노래를 찾을 수 없습니다."; break;
            case "selectListByMood" : errorMessage = "입력하신 주제의 노래를 찾을 수 없습니다."; break;
            case "insert" : errorMessage = "노래 등록 실패!"; break;
            case "update" : errorMessage = "노래 수정 실패!"; break;
            case "delete" : errorMessage = "노래 삭제 실패!"; break;
        }
        System.out.println(errorMessage);

    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch(successCode){
            case "insert" : successMessage = "노래 등록 성공!"; break;
            case "update" : successMessage = "노래 수정 완료!"; break;
            case "delete" : successMessage = "노래 삭제 완료!"; break;
        }
        System.out.println(successMessage);
    }
}

package com.himedia.mybatis.controller;

import com.himedia.mybatis.common.SearchCriteria;
import com.himedia.mybatis.model.dto.MusicDTO;
import com.himedia.mybatis.model.service.MusicService;
import com.himedia.mybatis.view.PrintResult;

import java.util.List;
import java.util.Map;

public class MusicController {

    private final MusicService musicService;
    private final PrintResult printResult;

    public MusicController(){
        musicService = new MusicService();
        printResult = new PrintResult();
    }
    public void selectAllMusic() {

        List<MusicDTO> musicList = musicService.selectAllMenu();

        if(musicList != null){
            printResult.printMusicList(musicList);
        } else{
            printResult.printErrorMessage("selectAllList");
        }

    }

    public void selectMusicByGenre(Map<String, String> parameter) {

        List<MusicDTO> musicList = musicService.selectMusicByGenre(parameter.get("genre"));

        if(musicList != null){
            printResult.printMusicList(musicList);
        } else{
            printResult.printErrorMessage("selectListByGenre");
        }

    }

    public void searchMusic(SearchCriteria searchCriteria) {

        List<MusicDTO> musicList = musicService.searchMusic(searchCriteria);

        if(musicList != null && musicList.size() > 0){
            printResult.printMusicList(musicList);
        } else{
            printResult.printErrorMessage("searchMusic");
        }
    }


    public void registMusic(Map<String, String> parameter) {

        String name = parameter.get("name");
        String genre = parameter.get("genre");
        String singer = parameter.get("singer");
        int themeCode = Integer.parseInt(parameter.get("themeCode"));

        MusicDTO music = new MusicDTO();
        music.setName(name);
        music.setGenre(genre);
        music.setSinger(singer);
        music.setThemeCode(themeCode);

        if(musicService.registMusic(music)){
            printResult.printSuccessMessage("insert");
        }else{
            printResult.printErrorMessage("insert");
        }


    }

    public void modifyMusic(Map<String, String> parameter) {

        int no = Integer.parseInt(parameter.get("no"));
        String name = parameter.get("name");
        String genre = parameter.get("genre");
        String singer = parameter.get("singer");
        int themeCode = Integer.parseInt(parameter.get("themeCode"));

        MusicDTO music = new MusicDTO();
        music.setNo(no);
        music.setName(name);
        music.setGenre(genre);
        music.setSinger(singer);
        music.setThemeCode(themeCode);

        if(musicService.modifyMusic(music)){
            printResult.printSuccessMessage("update");
        }else{
            printResult.printErrorMessage("update");
        }

    }

    public void deleteMusic(Map<String, String> parameter) {

        int no = Integer.parseInt(parameter.get("no"));

        if(musicService.deleteMusic(no)){
            printResult.printSuccessMessage("delete");
        }else{
            printResult.printErrorMessage("delete");
        }


    }


    public void searchMusicByMood(Map<String, String> parameter) {

        List<MusicDTO> musicList = musicService.selectMusicByMood(parameter.get("mood"));

        if(musicList != null){
            printResult.printMusicList(musicList);
        } else{
            printResult.printErrorMessage("selectListByMood");
        }


    }
}

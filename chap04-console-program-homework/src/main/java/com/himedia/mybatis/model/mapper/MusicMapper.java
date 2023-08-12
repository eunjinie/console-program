package com.himedia.mybatis.model.mapper;

import com.himedia.mybatis.common.SearchCriteria;
import com.himedia.mybatis.model.dto.MusicDTO;

import java.util.List;

public interface MusicMapper {
    List<MusicDTO> selectAllMusic();

    List<MusicDTO> selectMusicByGenre(String genre);

    List<MusicDTO> searchMusic(SearchCriteria searchCriteria);

    List<MusicDTO> selectMusicByMood(String mood);

    int insertMusic(MusicDTO music);

    int modifyMusic(MusicDTO music);

    int deleteMusic(int no);


}

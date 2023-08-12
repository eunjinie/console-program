package com.himedia.mybatis.model.service;

import com.himedia.mybatis.common.SearchCriteria;
import com.himedia.mybatis.model.dto.MusicDTO;
import com.himedia.mybatis.model.mapper.MusicMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.himedia.mybatis.common.Template.getSqlSession;

public class MusicService {

    private MusicMapper musicMapper;
    public List<MusicDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();

        musicMapper = sqlSession.getMapper(MusicMapper.class);
        List<MusicDTO> musicList = musicMapper.selectAllMusic();

        sqlSession.close();

        return musicList;

    }

    public List<MusicDTO> selectMusicByGenre(String genre) {

        SqlSession sqlSession = getSqlSession();

        musicMapper = sqlSession.getMapper(MusicMapper.class);
        List<MusicDTO> musicList = musicMapper.selectMusicByGenre(genre);

        sqlSession.close();

        return musicList;
    }

    public List<MusicDTO> searchMusic(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        musicMapper = sqlSession.getMapper(MusicMapper.class);
        List<MusicDTO> musicList = musicMapper.searchMusic(searchCriteria);

        sqlSession.close();

        return musicList;

    }

    public List<MusicDTO> selectMusicByMood(String mood) {

        SqlSession sqlSession = getSqlSession();

        musicMapper = sqlSession.getMapper(MusicMapper.class);
        List<MusicDTO> musicList = musicMapper.selectMusicByMood(mood);

        sqlSession.close();

        return musicList;

    }

    public boolean registMusic(MusicDTO music) {

        SqlSession sqlSession = getSqlSession();

        musicMapper = sqlSession.getMapper(MusicMapper.class);

        int result = musicMapper.insertMusic(music);

        if(result > 0){
            sqlSession.commit();
        } else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;


    }

    public boolean modifyMusic(MusicDTO music) {

        SqlSession sqlSession = getSqlSession();

        musicMapper = sqlSession.getMapper(MusicMapper.class);

        int result = musicMapper.modifyMusic(music);

        if(result > 0){
            sqlSession.commit();
        } else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean deleteMusic(int no) {

        SqlSession sqlSession = getSqlSession();

        musicMapper = sqlSession.getMapper(MusicMapper.class);

        int result = musicMapper.deleteMusic(no);

        if(result > 0){
            sqlSession.commit();
        } else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;


    }


}

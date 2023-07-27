package com.board.service;

import com.board.dao.SearchDao;
import com.board.domain.dto.SearchDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
//    private final SearchDao searchDao;
    private final SearchDao searchDao;

    public SearchService(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    public List<SearchDto> findAll(){
        return searchDao.findAll();
    }

    public List<SearchDto> findByKeyword(String keyword,String condition){
        return searchDao.findByKeyword(keyword,condition); // searchDao로 keyword 가지고 전달
    }


//    TODO 키워드 검색
//    public List<SearchDto> findByKeyword(String keyword){
//        return searchDao.findByKeyword(keyword);
//    }
}
package com.board.controller;

import com.board.domain.dto.SearchDto;
import com.board.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {
    private final SearchService searchService;
    public SearchController (SearchService searchService){
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public ModelAndView showMain(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "condition", required = false) String condition,
            @RequestParam(value = "sort", required = false) String sort
    ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/search"); // search.jsp로 연결

        if(keyword!=null && !keyword.equals("")) {   // 파라미터 keyword가 null과 ""이 아닐 떄
            List<SearchDto> bykeyword = searchService.findByKeyword(keyword,condition); // keyword를 가지고 service로 전달
            modelAndView.addObject("boardlist", bykeyword); // 받아온 값을 리퀘스트로 저장 전송
            modelAndView.addObject("test", "test"); // 받아온 값을 리퀘스트로 저장 전송

//            List<TodoJoinUser> byKeyword = todoService.findByKeyword(keyword);
//            modelAndView.addObject("todolist", byKeyword);
        }else{ // keyword가 파라미터에 없으면 전체리스트 나타나도록
            modelAndView.addObject("boardlist", searchService.findAll());
        }
        return modelAndView;
    }
}

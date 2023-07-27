package com.board.controller;

import com.board.domain.dto.CommentDto;
import com.board.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

//    @GetMapping("/boardList")
//    public ModelAndView showAllComment() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/board");
//
//        List<CommentDto> commentList = commentService.findAll();
//        modelAndView.addObject("commentList", commentList);
//
//        return modelAndView;
//    }
//

    @PostMapping("/board/{id}")
    public ModelAndView inputComment(
            ModelAndView mav,
            @PathVariable("id") Integer bid,
            @RequestParam("content") String content,
            @RequestParam("username") String username,
            HttpSession session
    ) {
        // TODO insert 서비스 에다가 만들거다.
        if (commentService.addComment(bid, content, username) != 0)
            mav.setViewName("redirect:/board/" + bid);
        else {
            mav.setViewName("redirect:/board");
            mav.addObject("err", "not_insert");
        }
        return mav;
    }

}
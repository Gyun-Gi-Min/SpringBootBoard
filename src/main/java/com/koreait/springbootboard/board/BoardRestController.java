package com.koreait.springbootboard.board;


import com.koreait.springbootboard.ResultVo;
import com.koreait.springbootboard.board.comment.model.BoardCommentEntity;
import com.koreait.springbootboard.board.model.BoardDTO;
import com.koreait.springbootboard.board.model.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajax/board")
public class BoardRestController {

    @Autowired
    private BoardService service;




    @GetMapping("/{icategory}")
    public List<BoardVo> selBoardList(@PathVariable int icategory, BoardDTO dto) {
        dto.setIcategory(icategory);
        return service.selBoardList(dto);
    }

    @GetMapping("/detail/{iboard}")
    public BoardVo selBoard(@PathVariable int iboard, BoardDTO dto) {
        dto.setIboard(iboard);
        return service.selBoard(dto);
    }

    @GetMapping("/maxpage")
    public ResultVo selMaxPageVal(BoardDTO dto){
        return service.selMaxPageVal(dto);
    }



}

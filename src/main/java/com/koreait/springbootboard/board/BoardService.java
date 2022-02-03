package com.koreait.springbootboard.board;

import com.koreait.springbootboard.ResultVo;
import com.koreait.springbootboard.board.model.BoardDTO;
import com.koreait.springbootboard.board.model.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private  BoardMapper mapper;

    public List<BoardVo> selBoardList(BoardDTO dto){
        int startIdx = (dto.getCurrentPage()-1) * dto.getRecordCount();
        if(startIdx<0) { startIdx = 0 ;}
        dto.setStartIdx(startIdx);
        return mapper.selBoardList(dto);
    }

    public BoardVo selBoard(BoardDTO dto){
        return mapper.selBoard(dto);
    }

    public ResultVo selMaxPageVal(BoardDTO dto){ return mapper.selMaxPageVal(dto);}



}

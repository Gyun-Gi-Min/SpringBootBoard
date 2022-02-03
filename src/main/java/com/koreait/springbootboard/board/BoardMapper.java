package com.koreait.springbootboard.board;

import com.koreait.springbootboard.ResultVo;
import com.koreait.springbootboard.board.model.BoardDTO;
import com.koreait.springbootboard.board.model.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardVo> selBoardList (BoardDTO entity);
    BoardVo selBoard(BoardDTO dto);
    ResultVo selMaxPageVal(BoardDTO dto);

}

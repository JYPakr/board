package com.board.mapper;

import java.util.List;

import com.board.domain.BoardVO;

public interface BoardMapper {

	
	List<BoardVO> getList();
	
	void insert(BoardVO board);
	
	void insertSelectKey(BoardVO board);
	
	BoardVO read(Long bno);
	
	int delete(Long bno);
	
	int update(BoardVO board);
	
}

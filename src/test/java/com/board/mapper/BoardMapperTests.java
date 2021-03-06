package com.board.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.domain.BoardVO;
import com.board.domain.Criteria;
import com.board.domain.PageDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		
		log.info("-----------------------");
		boardMapper.getList();
	}
	
	@Test
	public void testInsert() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("Test 테스트1");
		vo.setContent("Content 테스트1");
		vo.setWriter("tester1");
		
		boardMapper.insert(vo);
		log.info("----------------------------------------");
		log.info("after insert " + vo.getBno());
		
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("AAAATest 테스트");
		vo.setContent("AAAAContent 테스트");
		vo.setWriter("AAAAtester");
		
		boardMapper.insertSelectKey(vo);
		log.info("----------------------------------------");
		log.info("after insert selectKey " + vo.getBno());
	}
	
	@Test
	public void testRead() {
		
		BoardVO vo= boardMapper.read(9L);
		log.info(vo);
		
	}
	
	@Test
	public void testDelete() {
		
		int count = boardMapper.delete(2L);
		log.info("count: " + count);
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO vo = new BoardVO();
		vo.setBno(9L);
		vo.setTitle("Updated Title");
		vo.setContent("Updated content");
		vo.setWriter("user02");
		
		log.info("count: " + boardMapper.update(vo));
		
	}
	
	@Test
	public void testSearchPaging() {
		
		//1 10
		Criteria cri = new Criteria();
		cri.setType("TCW");
		cri.setKeyword("Test");
		
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		
		list.forEach(b -> log.info(b));
	}
	
	@Test
	public void testPageDTO() {
		
		Criteria cri = new Criteria();
		cri.setPageNum(25);
		PageDTO pageDTO = new PageDTO(cri, 251);
		
		log.info(pageDTO);
	}
	
/*	@Test
	public void testSearch() {
		Map<String, String> map = new HashMap<>();
		map.put("T", "TTT");
		map.put("C", "CCC");
		map.put("W", "WWW");
		
		Map<String, Map<String, String>> outer = new HashMap<>();
		outer.put("map", map);
		
		List<BoardVO> list = boardMapper.searchTest(outer);
		
		log.info(list);
		
	} */
}
















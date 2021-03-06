package com.board.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.domain.BoardVO;
import com.board.domain.Criteria;
import com.board.domain.PageDTO;
import com.board.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@RequestMapping("/board/*")
@Log4j
public class BoardController {

	
	private BoardService service;
	
//	@GetMapping("/list")
//	public void list(Model model) {
//		
//		log.info("list..............");
//		
//		model.addAttribute("list",service.getList());
//	}
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		log.info("-----------------------");
		log.info(cri);
		log.info("list..............");
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri)));
	}
	
	@GetMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public void registerGET() {
		
	}
	
	@PostMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		log.info("==========================");
		
		log.info("register: " + board);

		Long bno = service.register(board); 
		
		log.info("BNO: " + bno);
		rttr.addFlashAttribute("result", bno);
		
		
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		
		log.info("/get");
		model.addAttribute("board", service.get(bno));
				
	}
	
	@PreAuthorize("principal.username == #board.writer")
	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		
		int count = service.modify(board);
		
		if(count == 1) {
			rttr.addFlashAttribute("result", "success");
			
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@PreAuthorize("principal.username == #writer")
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr, String writer) {
		
		int count = service.remove(bno);
		
		if(count == 1) {
			rttr.addFlashAttribute("result", "success");
			
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	
}















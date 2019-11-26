package com.dotlamp.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dotlamp.config.ServletConfig;
import com.dotlamp.domain.BoardVO;
import com.dotlamp.domain.Criteria;
import com.dotlamp.domain.PageDTO;
import com.dotlamp.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/")
@AllArgsConstructor
//@ComponentScan(basePackages = {"ServletConfig.class"})
public class BoardController {
	
	private BoardService service;
	
//	@GetMapping("/list")
//	public void list(Model model) {
//		log.info("list");
//		model.addAttribute("list", service.getList());
//	}

	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri));
		//model.addAttribute("pageMaker", new PageDTO(cri, 123));
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register: " + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register() {
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify: " + board);
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		/* Criteria - UriComponentsBuilder 사용으로 생략
		 * 리턴값 + cri.getListLink() 추가  */
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list" + cri.getListLink();
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove... " + bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list" + cri.getListLink();
	}
}

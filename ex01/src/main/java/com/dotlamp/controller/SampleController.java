package com.dotlamp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dotlamp.domain.SampleDTO;
import com.dotlamp.domain.SampleDTOList;
import com.dotlamp.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info("basic...");
	}

	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic...");
	}
	
	@GetMapping("/basic/OnlyGet")
	public void basicGet2() {
		log.info("basic get only get...");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(""+dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name: "+ name);
		log.info("age: "+ age);
		return "ex02"; // http://localhost:8080/sample/ex02?name=abc&age=11
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids: "+ ids);
		return "ex02List"; // http://localhost:8080/sample/ex02List?ids=111&ids=222&ids=333
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids: "+ Arrays.toString(ids));
		return "ex02Array"; // http://localhost:8080/sample/ex02Array?ids=111&ids=222&ids=333
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos: "+ list);
		return "ex02Bean"; // http://localhost:8080/sample/ex02Bean?list%5B0%5D.name=aaa&list%5B1%5D.name=bbb&list%5B2%5D.name=ccc
	}
	
	/* 바인딩 : 파라미터를 변환해서 처리 */
	/* ex : 2018-01-01 을 바인딩 처리하지 않으면 값을 받을 수 없음 */
	/* 방법1. @InitBinder 사용  
	 * 방법2. DTO, @DateTimeFormat(pattern = "yyyy/MM/dd") 사용 */
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo: "+ todo);
		return "ex03"; // http://localhost:8080/sample/ex03?title=test&dueDate=2018-01-01
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto: "+ dto);
		log.info("page: "+ page);
		return "/sample/ex04"; // http://localhost:8080/sample/ex04?name=aaa&age=11&page=9
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05....."); //http://localhost:8080/sample/ex05
	}  // void : return ex05
	
	@GetMapping("ex05_2")
	public String ex05_2() {
		log.info("/ex05_2.....");
		return "ex05_2"; // http://localhost:8080/sample/ex05_2
	} 
	
	@GetMapping("ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06....");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		return dto; // http://localhost:8080/sample/dto
	}
	
	@GetMapping("ex07")
	public ResponseEntity<String> ex07(){
		log.info("/ex07........");
		String msg = "{\"name\": \"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/json;charset=UTF-8");
		return new ResponseEntity(msg, header, HttpStatus.OK); // http://localhost:8080/sample/ex07
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload...");
	} 
	
	@GetMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			log.info("--------------");
			log.info("name: "+ file.getOriginalFilename());
			log.info("size: "+ file.getSize());
		});
	}
}

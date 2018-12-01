package com.examOnline.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examOnline.common.BootStrapTableDto;
import com.examOnline.common.Page;
import com.examOnline.common.Url;
import com.examOnline.model.Score;
import com.examOnline.model.StuPaper;
import com.examOnline.service.ScoreServcie;
import com.examOnline.service.StuExamPaperService;


@Controller
public class StuScoreController<T> {
	@Autowired
	private StuExamPaperService stuExamPaperService;
	@Autowired
	private ScoreServcie scoreService;
	/*@RequestMapping(Url.GETSCORE)
	@ResponseBody
	public Map  saveData(HttpServletRequest request, HttpServletResponse response){
		String row = "{\"a\":" + 11 + ",\"sex\":" + 1 + ",\"b\":" + 1234 + "}";
		List list = new ArrayList();
		Map map = new HashMap();
		A a = new A();
		a.setA("1111111111111111111");
		a.setSex("0");
		a.setB("小花");
		list.add(a);
		A a1 = new A();
		a1.setA("1111111111111111111");
		a1.setSex("0");
		a1.setB("树棍");
		list.add(a1);
		JSONArray json = JSONArray.fromObject(list);  
		String jsStr = "{\"rows\":" +json.toString() + "}"; 
		map.put("total",new Integer(12));
		map.put("rows", list);
		return map;
	}*/
	@RequestMapping(Url.GETPAPER)
	@ResponseBody
	public BootStrapTableDto<T>  selectData(Page page,HttpServletRequest request, HttpServletResponse response){
		System.out.println(page.getOrderBy());
		System.out.println(page.getOrderType());
		System.out.println(page.getPageNo());
		System.out.println(page.getPageSize());
		System.out.println(page.getSearchText());
		HttpSession session = request.getSession();
    	String code = (String) session.getAttribute("code");
    	List<T> list = stuExamPaperService.selectPaper(page, code);
    	Integer total = stuExamPaperService.getCount(code);
		BootStrapTableDto<T> BootStrapTableDto = new BootStrapTableDto();
		BootStrapTableDto.setTotal(total);
		BootStrapTableDto.setRecords(list);
		return BootStrapTableDto;
	}
	
	@RequestMapping(Url.GETSCORE)
	@ResponseBody
	public BootStrapTableDto<T>  getScoreData(Page page,HttpServletRequest request, HttpServletResponse response){
		System.out.println(page.getOrderBy());
		System.out.println(page.getOrderType());
		System.out.println(page.getPageNo());
		System.out.println(page.getPageSize());
		System.out.println(page.getSearchText());
    	List<T> list = (List<T>) scoreService.getScoreList(page);
    	Integer total = scoreService.getCount();
		BootStrapTableDto<T> BootStrapTableDto = new BootStrapTableDto();
		BootStrapTableDto.setTotal(total);
		BootStrapTableDto.setRecords(list);
		return BootStrapTableDto;
	}
}

package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.Exam1Service;

/**
 * 球団表示用コントローラー.
 * 
 * @author ryotaro.seya
 *
 */
@Controller
@RequestMapping("/exam1")
public class Exam1Controller {
	@Autowired
	private Exam1Service exam1Service;

	/**
	 * 球団一覧ページ表示.
	 * 
	 * @param model 球団一覧情報用リクエストスコープ
	 * @return 球団一覧ページへのフォワード
	 */
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("teamList", exam1Service.showList());
		return "teams/teamList";
	}

	/**
	 * 球団詳細ページ表示.
	 * 
	 * @param teamId 主キーid
	 * @param model  球団詳細情報用リクエストスコープ
	 * @return 球団詳細ページへのフォワード
	 */
	@RequestMapping("/detail")
	public String detail(Integer teamId, Model model) {
		System.out.println(teamId);
		model.addAttribute("team", exam1Service.showDetail(teamId));
		return "teams/teamDetail";
	}
}

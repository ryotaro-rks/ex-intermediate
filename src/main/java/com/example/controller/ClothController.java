package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Cloth;
import com.example.service.ClothService;

/**
 * 洋服検索システム用コントローラ.
 * 
 * @author ryotaro.seya
 *
 */
@Controller
@RequestMapping("/exam3")
public class ClothController {
	@Autowired
	private ClothService clothService;

	/**
	 * 洋服検索システムページの表示.
	 * 
	 * @param model 性別・色用のリクエストスコープ
	 * @return 洋服検索システムページへのフォワード
	 */
	@RequestMapping("")
	public String index(Model model) {
		Map<Integer, String> genderMap = new HashMap<>();
		genderMap.put(0, "Man");
		genderMap.put(1, "Woman");

		List<String> colorList = new ArrayList<>();
		colorList.add("赤");
		colorList.add("青");
		colorList.add("白");
		colorList.add("黄");

		model.addAttribute("genderMap", genderMap);
		model.addAttribute("colorList", colorList);
		return "clothes/searchCloth";
	}

	/**
	 * 性別・色から洋服情報を取得.
	 * 
	 * @param gender 性別
	 * @param color  色
	 * @param model  検索した洋服情報用リクエストスコープ
	 * @return 検索された洋服情報
	 */
	@RequestMapping("/searchCloth")
	public String searchCloth(Integer gender, String color, Model model) {
		List<Cloth> clothList = clothService.searchCloth(gender, color);
		model.addAttribute("clothList", clothList);
		return index(model);
	}
}

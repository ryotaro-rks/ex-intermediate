package com.example.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.HotelService;

@Controller
@RequestMapping("/exam2")
public class HotelController {
	@ModelAttribute
	public HotelForm setUpHotelForm() {
		return new HotelForm();
	}

	@Autowired
	private HotelService hotelService;

	@RequestMapping("")
	public String index() {
		return "hotels/searchHotel";
	}

	@RequestMapping("searchHotel")
	public String searchHotel(HotelForm hotelForm, RedirectAttributes redirectAttributes) {
		// 空文字でない かつ 半角数字でない
		if (Pattern.matches("^(\\s*|[0-9]{1,6})$", hotelForm.getPrice()) == false) {
			redirectAttributes.addFlashAttribute("message", "入力内容が適切でありません");
			return "redirect:/exam2/";
		}

		List<Hotel> hotels = hotelService.searchByLessThanPrice(hotelForm.getPrice());
		if (hotels.size() == 0) {
			redirectAttributes.addFlashAttribute("message", "検索結果に一致するホテルは存在しません");
		} else {
			redirectAttributes.addFlashAttribute("hotels", hotels);
		}

		return "redirect:/exam2/";
	}
}

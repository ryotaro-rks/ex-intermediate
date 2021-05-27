package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル用サービスクラス.
 * 
 * @author ryotaro.seya
 *
 */
@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;

	/**
	 * 検索料金以下のホテル情報を検索.
	 * 
	 * @param price 検索料金
	 * @return 検索料金以下のホテル情報
	 */
	public List<Hotel> searchByLessThanPrice(Integer price) {
		return hotelRepository.findAllByLessThanPrice(price);
	}

	/**
	 * 全ホテル情報を検索.
	 * 
	 * @return 全ホテル情報
	 */
	public List<Hotel> searchAll() {
		return hotelRepository.findAll();
	}
}

package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル用サービスクラス.
 * 
 * @author ryotaro.seya
 *
 */
@Service
@Transactional
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;

	/**
	 * 検索料金以下のホテル情報を検索. 検索料金が未入力なら全ホテル情報
	 * 
	 * @param price 検索料金
	 * @return 検索料金以下のホテル情報 検索料金が未入力なら全ホテル情報
	 */
	public List<Hotel> searchByLessThanPrice(String priceEntered) {
		if (priceEntered.isEmpty()) {
			return hotelRepository.findAll();
		} else {
			Integer price = Integer.parseInt(priceEntered);
			return hotelRepository.findAllByLessThanPrice(price);
		}

	}
}

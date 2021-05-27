package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Cloth;
import com.example.repository.ClothRepository;

/**
 * 洋服情報検索用サービスクラス.
 * 
 * @author ryotaro.seya
 *
 */
@Service
@Transactional
public class ClothService {
	@Autowired
	private ClothRepository clothRepository;

	public List<Cloth> searchCloth(Integer gender, String color) {
		return clothRepository.findBy(gender, color);
	}
}

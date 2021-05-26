package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Teams;
import com.example.repository.Exam1Repository;

/**
 * 球団情報詳細用サービスクラス.
 * 
 * @author ryotaro.seya
 *
 */
@Service
public class Exam1Service {
	@Autowired
	private Exam1Repository exam1Repository;

	/**
	 * 球団一覧情報を取得.
	 * 
	 * @return 球団一覧
	 */
	public List<Teams> showList() {
		return exam1Repository.findAll();
	}

	/**
	 * 球団詳細情報を取得.
	 * 
	 * @param id 主キーid
	 * @return 球団詳細情報
	 */
	public Teams showDetail(Integer id) {
		return exam1Repository.load(id);
	}
}

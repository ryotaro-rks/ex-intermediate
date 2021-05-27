package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Cloth;

/**
 * 洋服検索システム用リポジトリクラス.
 * 
 * @author ryotaro.seya
 *
 */
@Repository
public class ClothRepository {
	private final static RowMapper<Cloth> CLOTH_ROW_MAPPER = new BeanPropertyRowMapper<>(Cloth.class);
	private final static String TABLE_NAME = "clothes";

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * 条件に一致する洋服情報を取得.
	 * 
	 * @param gender 性別
	 * @param color  色
	 * @return 性別・色の条件に一致する洋服情報
	 */
	public List<Cloth> findBy(Integer gender, String color) {
		String sql = "select id, category, genre, gender, color, price, size from " + TABLE_NAME
				+ " where gender = :gender and color = :color";
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
		return template.query(sql, param, CLOTH_ROW_MAPPER);
	}
}

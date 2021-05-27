package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * ホテル検索用リポジトリクラス.
 * 
 * @author ryotaro.seya
 *
 */
@Repository
public class HotelRepository {
	private final static RowMapper<Hotel> HOTEL_ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);

	private String TABLE_NAME = "hotels";
	private String ALL_COLUMN_NAME = "area_name, hotel_name, address, nearest_station, price, parking";
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * 全ホテル情報を検索.
	 * 
	 * @return 全ホテル情報
	 */
	public List<Hotel> findAll() {
		String sql = "select " + ALL_COLUMN_NAME + " from " + TABLE_NAME + " order by price desc";
		return template.query(sql, HOTEL_ROW_MAPPER);
	}

	/**
	 * 検索料金以下のホテル一覧情報検索.
	 * 
	 * @param price 検索料金
	 * @return 検索料金以下のホテル一覧情報
	 */
	public List<Hotel> findAllByLessThanPrice(Integer price) {
		String sql = "select " + ALL_COLUMN_NAME + " from " + TABLE_NAME + " where price <= :price order by price desc";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		return template.query(sql, param, HOTEL_ROW_MAPPER);
	}
}

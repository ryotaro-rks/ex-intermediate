package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Teams;

/**
 * 球団情報表示用リポジトリ.
 * 
 * @author ryotaro.seya
 *
 */
@Repository
public class Exam1Repository {
	private final static RowMapper<Teams> TEAMS_ROW_MAPPER = new BeanPropertyRowMapper<>(Teams.class);
	private final static String TABLE_NAME = "teams";

	@Autowired
	NamedParameterJdbcTemplate template;

	/**
	 * 全チーム情報を発足日順の昇順で取得.
	 * 
	 * @return 全チーム情報(発足日順の昇順)
	 */
	public List<Teams> findAll() {
		String sql = "select * from " + TABLE_NAME + " order by inauguration";
		return template.query(sql, TEAMS_ROW_MAPPER);
	}

	/**
	 * 主キーからチーム情報を取得.
	 * 
	 * @param id 主キー
	 * @return 主キーに対応するチーム情報
	 */
	public Teams load(Integer id) {
		String sql = "select * from " + TABLE_NAME + " where id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return template.queryForObject(sql, param, TEAMS_ROW_MAPPER);
	}
}
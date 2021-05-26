package com.example.domain;

/**
 * チーム用ドメインクラス.
 * 
 * @author ryotaro.seya
 *
 */
public class Teams {
	/** id */
	private Integer id;
	/** チーム名 */
	private String teamName;
	/** 本拠地 */
	private String headquarters;
	/** 発足年月日 */
	private String inauguration;
	/** 歴史 */
	private String history;

	@Override
	public String toString() {
		return "Teams [id=" + id + ", teamName=" + teamName + ", headquaters=" + headquarters + ", inauguration="
				+ inauguration + ", history=" + history + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public String getInauguration() {
		return inauguration;
	}

	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

}

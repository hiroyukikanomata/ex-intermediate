package com.example.domain;

/**
 * Teamドメインクラス
 * 
 * @author kano
 *
 */
public class Team {
	
	// ID
	private Integer id;
	// 所属リーグ
	private String leagueName;
	// 球団名
	private String teamName;
	// 本拠地
	private String headquarters;
	// 発足日
	private String inauguration;
	// 歴史
	private String history;
	
	/**
	 * 引数なしコンストラクタ
	 */
	public Team() {}
	
	/**
	 * 引数ありコンストラクタ（初期値セット用）
	 * 
	 * @param id ID
	 * @param leagueName 所属リーグ
	 * @param teamName 球団名
	 * @param headquarters 本拠地
	 * @param inauguration 発足日
	 * @param history 歴史
	 */
	public Team(Integer id, String leagueName, String teamName, String headquarters, String inauguration,
			String history) {
		this.id = id;
		this.leagueName = leagueName;
		this.teamName = teamName;
		this.headquarters = headquarters;
		this.inauguration = inauguration;
		this.history = history;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
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

	@Override
	public String toString() {
		return "Team [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headquarters="
				+ headquarters + ", inauguration=" + inauguration + ", history=" + history + "]";
	}

}

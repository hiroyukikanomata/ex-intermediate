package com.example.repository;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

/**
 * teamsテーブル用リポジトリ
 * 
 * @author kano
 *
 */
@Repository
public class TeamRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
		// 初期化用の引数ありコンストラクタでフィールドにResultSetで受け取った値をセットし、
		// Teamsオブジェクトをreturnする
		return new Team(
				rs.getInt("id"),
				rs.getString("league_name"),
				rs.getString("team_name"),
				rs.getString("headquarters"),
				rs.getString("inauguration"),
				rs.getString("history")
				);
	};
	
	/**
	 * 球団情報の全件検索用メソッド（発足日の昇順）
	 * 
	 * @return 全件検索した球団情報のリスト
	 */
	public List<Team> findAll() {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history "
				+ "FROM teams "
				+ "ORDER BY inauguration ASC;";
		return template.query(sql, TEAM_ROW_MAPPER);
	}
	
	/**
	 * 球団情報のID検索用メソッド
	 * 
	 * @param id ID
	 * @return IDで検索した球団情報（1件）
	 */
	public Team load(Integer id) {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history "
				+ "FROM teams "
				+ "WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return template.queryForObject(sql, param, TEAM_ROW_MAPPER);
	}
}

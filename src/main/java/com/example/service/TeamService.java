package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * 球団情報に関する業務処理を行うサービス
 * 
 * @author kano
 *
 */
@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamRepository repository;
	
	/**
	 * 球団情報を全件取得（発足日の昇順）する
	 * 
	 * @return 球団情報のリスト
	 */
	public List<Team> showList() {
		return repository.findAll();
	}
	
	/**
	 * IDに該当する球団情報を取得する
	 * 
	 * @param id ID
	 * @return 球団情報
	 */
	public Team showDetail(Integer id) {
		return repository.load(id);
	}
}

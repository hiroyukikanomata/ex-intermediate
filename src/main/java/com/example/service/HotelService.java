package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository repository;
	
	public List<Hotel> searchByLessThanPrice(String lessThanPrice) {
		
		// 検索画面初回表示時は、入力フォームのlessThanPrice（価格入力ボックス）に、
		// nullが設定されている→何も表示させないようにするために、取得結果としてnullを返す
		if(lessThanPrice == null) {
			return null;
		} else if ("".equals(lessThanPrice)) {	// 空文字で検索されたら、全件取得の結果を返す
			return repository.findAll();
		} else { // 数値で検索されたら、その価格以下の条件での取得結果を返す
			return repository.findByLessThanPrice(
					Integer.parseInt(lessThanPrice));
		}
	}
}

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

@Repository
public class HotelRepository {
	
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = 
			new BeanPropertyRowMapper<>(Hotel.class);
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public List<Hotel> findAll() {
		String sql = "SELECT * FROM hotels ORDER BY price DESC;";
		return template.query(sql, HOTEL_ROW_MAPPER);
	}
	
	public List<Hotel> findByLessThanPrice(Integer lessThanPrice) {
		String sql = "SELECT * FROM hotels WHERE price <= :price ORDER BY price DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", lessThanPrice);
		return template.query(sql, param, HOTEL_ROW_MAPPER);
	}

}

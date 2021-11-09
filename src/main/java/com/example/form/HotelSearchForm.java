package com.example.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class HotelSearchForm {
	
	// 以下のようにすると、空文字で全件検索したい場合でも@Rangeのバリデーションが動いてしまい、処理の邪魔になってしまう
	//@Range(min=0, max=300000, message="数値範囲（0-300000）バリデーションエラー")
	//@Pattern(regexp="^[0-9]*$", message="数字入力バリデーションエラー")
	// 以下のように正規表現を使えば、上記の問題を解決でき、かつ柔軟なバリデーションが可能
	@Pattern(regexp="^$|[0-9]|[1-9][0-9]{1,4}|[1-2][0-9]{5}|300000", message="数字入力＆数値範囲（0-300000）バリデーションエラー")
	private String lessThanPrice;
	
	public String getLessThanPrice() {
		return lessThanPrice;
	}

	public void setLessThanPrice(String lessThanPrice) {
		this.lessThanPrice = lessThanPrice;
	}
	

}

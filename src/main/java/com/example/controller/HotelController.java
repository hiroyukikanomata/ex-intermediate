package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.HotelSearchForm;
import com.example.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService service;
	
	@ModelAttribute
	public HotelSearchForm setUpHotelSearchForm() {
		return new HotelSearchForm();
	}
	
	/**
	 * 検索画面表示用のメソッド
	 * 
	 * コントローラークラス内のメソッドでは、
	 * 　バリデーションチェック、リクエストパラメータの受け取り、スコープへの格納、ビューの選択
	 * 　などに専念したいので、
	 * 
	 * サービスクラス（いわゆる業務処理を行うクラス）のメソッドに、
	 * 　「空文字なら全件取得」、「価格で検索されたら価格以下条件で取得」、という判断を任せるようにしている
	 * 
	 * @param form 入力フォーム
	 * @param result バリデーション結果
	 * @param model リクエストスコープ
	 * @return 検索画面
	 */
	@RequestMapping("/search")
	public String search(@Validated HotelSearchForm form, 
			BindingResult result, Model model) {
		
		// バリデーションエラー時は何もせず、元の検索画面へ
		if(result.hasErrors()) {
			return "hotel/search";
		}
		
		// リクエストスコープに、ホテルの検索結果を格納
		//   入力フォームのlessThanPrice（検索画面の価格入力ボックス）を、
		//   サービスクラスのメソッドに渡し、帰ってきたホテルの検索結果リストを格納
		//    ・初回表示時はnull
		//    ・空文字検索時は全件取得結果
		//    ・数値検索時は、その値段以下の条件での取得結果
		//   が帰ってくる
		model.addAttribute("hotelList", 
				service.searchByLessThanPrice(form.getLessThanPrice()));
		
		// 検索画面へ
		return "hotel/search";
	}
}

package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.TeamService;

/**
 * 球団情報アプリ動作のための、モデルとビューの制御を行うコントローラー
 * 
 * @author kano
 *
 */
@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService service;
	
	/**
	 * 動作確認用メソッド
	 * 
	 * @return
	 */
	@RequestMapping("/test")
	public String test() {
		System.out.println("球団情報一覧表示");
		System.out.println(service.showList());
		
		System.out.println("球団情報をID1で検索して表示");
		System.out.println(service.showDetail(1));

		System.out.println("球団情報をID3で検索して表示");
		System.out.println(service.showDetail(3));
		
		return "finished";
	}
	
	/**
	 * 球団情報一覧を表示する
	 * 
	 * @param model リクエストスコープ
	 * @return 球団情報一覧画面
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("teamList", service.showList());
		return "team/list";
	}
}

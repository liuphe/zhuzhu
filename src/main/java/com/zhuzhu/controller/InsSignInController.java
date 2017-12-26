package com.zhuzhu.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhuzhu.entry.InsSignIn;
import com.zhuzhu.service.inte.InsSignInService;

@RestController
@RequestMapping("/login")
public class InsSignInController {
	@Resource
	private InsSignInService insSignInService;

	@RequestMapping("/save")
	public String save() {
		InsSignIn insSignIn = new InsSignIn("liupehe", "123");
		insSignInService.save(insSignIn);// 保存数据.
		return "ok.InsSignInController.save";
	}
}
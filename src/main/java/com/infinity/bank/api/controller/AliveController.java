package com.infinity.bank.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AliveController {

	@RequestMapping("/")
	@ResponseBody
	public String retorno() {
		return "API ON";
	}
}

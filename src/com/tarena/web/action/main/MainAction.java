package com.tarena.web.action.main;

import com.tarena.web.action.BaseAction;

public class MainAction extends BaseAction {
	public String execute(){
		System.err.println("main page");
		return "main";
	}

}

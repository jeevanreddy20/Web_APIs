package com.WebApi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebApi.pojo.commentEntityData;

@RestController
@RequestMapping("/comment")
public class commentsController {
	@PostMapping("/Add")
	public String addComment(@RequestBody commentEntityData data) {
		return "comment added "+data.toString();
	}
}

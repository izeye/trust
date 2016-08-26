/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ctb.trust.support.comment.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctb.trust.support.comment.domain.Comment;
import com.ctb.trust.support.comment.service.CommentService;

/**
 * Controller for comments.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@GetMapping
	public List<Comment> findAllInDesc() {
		return this.commentService.findAllInIdDesc();
	}

	@PostMapping
	public List<Comment> add(Comment comment, HttpServletRequest request) {
		comment.setTimestamp(new Date());
		comment.setIpAddress(request.getRemoteAddr());
		this.commentService.add(comment);
		return this.commentService.findAllInIdDesc();
	}

}

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

package com.ctb.trust.support.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ctb.trust.support.comment.domain.Comment;
import com.ctb.trust.support.comment.repository.CommentRepository;

/**
 * Default service for comments.
 *
 * @author Johnny Lim
 */
@Service
public class DefaultCommentService implements CommentService {

	private static final Sort ID_DESC = new Sort(Sort.Direction.DESC, "id");

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> findAllInIdDesc() {
		return this.commentRepository.findAll(ID_DESC);
	}

	@Override
	public void add(Comment comment) {
		this.commentRepository.save(comment);
	}

}

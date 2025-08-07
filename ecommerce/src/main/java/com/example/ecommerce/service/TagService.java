package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Tag;
import com.example.ecommerce.repository.TagRepository;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository;
	
	public Tag create(Tag tag) {
		return tagRepository.save(tag);
	}
	
	public List<Tag> getAll(){
		return tagRepository.findAll();
	}
	
	public List<Tag> getByIds(List<Long> ids){
		return tagRepository.findAllById(ids);
	}
	
}

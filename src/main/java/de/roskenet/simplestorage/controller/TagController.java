package de.roskenet.simplestorage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.roskenet.simplestorage.entity.Tag;
import de.roskenet.simplestorage.repository.TagRepository;

@RestController
@RequestMapping("/imagetags")
public class TagController {

	@Autowired
	private TagRepository tagRepository;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<String>> findAll() {
		
		List<Tag> tagList = tagRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
		List<String> tagStringList = new ArrayList<>();
		
		for (Tag tag : tagList) {
			tagStringList.add(tag.id);
		}
		
		return ResponseEntity.ok(tagStringList);
	}
	
}

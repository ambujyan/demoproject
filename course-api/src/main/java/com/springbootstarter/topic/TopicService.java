package com.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	List<Topic> topics = Arrays.asList(
			new Topic("spring", "Spring Boot", "Spring Boot Application"),
			new Topic("java", "Java App", "Java Application"),
			new Topic("javascript", "Java Scipt", "Java Script Application")
			);
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
}

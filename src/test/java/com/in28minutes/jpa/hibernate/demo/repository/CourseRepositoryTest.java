package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demo.entity.Course;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository repository;
	
	
	@Test
	public void testFindById() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps",course.getName());
	}
	
	@Test
	public void testDeleteById() {
		Course course = repository.findById(10003L);
		repository.deleteById(course.getId());
		Course course1 = repository.findById(10003L);
		assertNull(course1);
	}

}

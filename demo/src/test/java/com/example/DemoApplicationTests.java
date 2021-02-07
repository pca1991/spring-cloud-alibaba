package com.example;

import com.example.fatory.AnimalFatory;
import com.example.service.AnimalServie;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

	@Resource
	AnimalFatory animalFatory;

	@Resource
	AnimalServie dog;

	@Test
	void contextLoads() {
		AnimalServie animalServie = animalFatory.getService("cat");
		System.out.println(animalServie.getColor());
	}

	@Test
	void test() {
		System.out.println(dog.getColor());
	}


}

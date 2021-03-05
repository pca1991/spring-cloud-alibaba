package com.example;

import com.example.fatory.AnimalFatory;
import com.example.service.AnimalServie;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

	}


}

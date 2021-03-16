package com.example;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.UmsAdmin;
import com.example.service.IUmsAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
	@Resource
    IUmsAdminService iUmsAdminService;

	@Test
	void insert() {
		UmsAdmin umsAdmin = new UmsAdmin();
		umsAdmin.setUsername("666");
		umsAdmin.setIcon("1111");
		iUmsAdminService.save(umsAdmin);
	}

	@Test
	void update() {
		UmsAdmin umsAdmin = new UmsAdmin();
		umsAdmin.setId(8L);
		umsAdmin.setUsername("444");
		umsAdmin.setIcon("44444");
		iUmsAdminService.saveOrUpdate(umsAdmin);
	}

    @Test
    void list() {
		QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>();
		Page<UmsAdmin> queryPage = new Page<>(1,3);
        System.out.println(iUmsAdminService.page(queryPage,queryWrapper));
    }

    @Test
    void getOne() {
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UmsAdmin::getUsername,"qxu").like(UmsAdmin::getNickName,"许").select(UmsAdmin::getId,
                UmsAdmin::getNickName,UmsAdmin::getUsername);
        System.out.println(iUmsAdminService.getOne(queryWrapper));
    }
}

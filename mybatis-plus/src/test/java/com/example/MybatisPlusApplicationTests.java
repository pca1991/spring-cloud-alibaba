package com.example;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.UmsAdmin;
import com.example.service.IUmsAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MybatisPlusApplicationTests {
	@Resource
    IUmsAdminService iUmsAdminService;

	@Test
	void insert() {
		UmsAdmin umsAdmin = new UmsAdmin();
		umsAdmin.setUsername("wo4");
		umsAdmin.setIcon("good4");
		iUmsAdminService.save(umsAdmin);
	}

	@Test
	void update() {
		UmsAdmin umsAdmin = new UmsAdmin();
		umsAdmin.setId(15L);
		umsAdmin.setUsername("wo4");
		umsAdmin.setIcon("goodgood");
		iUmsAdminService.saveOrUpdate(umsAdmin);
	}

    @Test
    void list() {
		QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>();
		Page<UmsAdmin> queryPage = new Page<>(1,3);
        iUmsAdminService.page(queryPage,queryWrapper);
    }

    @Test
    void getOne() {
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UmsAdmin::getUsername,"qxu").like(UmsAdmin::getNickName,"许").select(UmsAdmin::getId,
                UmsAdmin::getNickName,UmsAdmin::getUsername);
		UmsAdmin umsAdmin = iUmsAdminService.getOne(queryWrapper);
		System.out.println(umsAdmin.getCreateTime());
	}
}

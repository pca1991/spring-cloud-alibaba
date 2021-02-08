package com.example.service.impl;

import com.example.entity.UmsAdmin;
import com.example.entity.UmsPermission;
import com.example.service.UmsAdminService;
import com.example.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private List<UmsAdmin> umsAdminList;
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        List<UmsAdmin> list =
                umsAdminList.stream().filter(umsAdminTmp->umsAdminTmp.getUsername().equals(username)).collect(Collectors.toList());
        if(list.size() > 0){
            return list.get(0);
        }

        return null;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setStatus(1);

        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        umsAdminList.add(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        List<UmsPermission> list = new ArrayList();
        return list;
    }

    @PostConstruct
    public void init(){
        List<UmsAdmin> list = new ArrayList<UmsAdmin>();
        list.add(new UmsAdmin(1L,1,"qxu","$2a$10$ZNHAG/4KztRyeiaqbJVI3.3vgoRETJVsPhZrES6Z5up/XWsBH/InG"));
        list.add(new UmsAdmin(2L,1,"dj","$2a$10$RXReR9yCUXOdXtxLqNQG1O1EgKANyYBJHwPVRYP.GWbC8MQBHTS6G"));
        umsAdminList = list;
    }
}

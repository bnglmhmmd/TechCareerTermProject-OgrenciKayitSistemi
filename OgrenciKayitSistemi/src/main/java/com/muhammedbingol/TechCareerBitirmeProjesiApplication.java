package com.muhammedbingol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.muhammedbingol.jwt.domain.Role;
import com.muhammedbingol.jwt.domain.User;
import com.muhammedbingol.jwt.service.IRoleService;
import com.muhammedbingol.jwt.service.IService;
import com.muhammedbingol.utils.ConstantUtils;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class TechCareerBitirmeProjesiApplication implements CommandLineRunner {
    @Autowired
    private IService<User> userService;

    @Autowired
    private IRoleService<Role> roleService;



    public static void main(String[] args) {
        SpringApplication.run(TechCareerBitirmeProjesiApplication.class, args);

        //JOptionalPane Kullanmak icin
        System.setProperty("java.awt.headless", "false");
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleService.findAll().isEmpty()) {
            roleService.saveOrUpdate(new Role(ConstantUtils.ADMIN.toString()));
            roleService.saveOrUpdate(new Role(ConstantUtils.USER.toString()));
        }

        if (userService.findAll().isEmpty()) {
            User user1 = new User();
            user1.setEmail("test@user.com");
            user1.setName("Test Users");
            user1.setMobile("9787456545");
            user1.setRole(roleService.findByName(ConstantUtils.USER.toString()));
            user1.setPassword(new BCryptPasswordEncoder().encode("testuser"));
            userService.saveOrUpdate(user1);

            User user2 = new User();
            user2.setEmail("test@admin.com");
            user2.setName("Test Admin");
            user2.setMobile("9787456545");
            user2.setRole(roleService.findByName(ConstantUtils.ADMIN.toString()));
            user2.setPassword(new BCryptPasswordEncoder().encode("testadmin"));
            userService.saveOrUpdate(user2);
        }
    }

}
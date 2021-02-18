package cn.amos.security;

import cn.amos.security.dao.entity.UserEntity;
import cn.amos.security.dao.mapper.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class SecurityDataInitTests {

    @Resource
    private UserRepository userRepository;
    @Resource
    private PasswordEncoder passwordEncoder;

    private static final String DEFAULT_PASSWORD = "000000";

    @Test
    void initUser() {
        List<Integer> ids = new ArrayList<>();
        String[] nameArr = {"木婉清", "王语嫣", "任盈盈", "程灵素", "周芷若", "俞莲舟", "宋远桥", "俞岱岩", "张松溪", "张翠山", "殷梨亭", "莫声谷"};
        Random random = new Random();
        List<UserEntity> list = new ArrayList<>();
        for (String name : nameArr) {
            int age = random.nextInt(nameArr.length + 3) + 12;
            while (ids.contains(age)) {
                age = random.nextInt(nameArr.length + 3) + 12;
            }
            ids.add(age);
            list.add(new UserEntity()
                    .setUsername("U" + age)
                    .setPassword(passwordEncoder.encode(DEFAULT_PASSWORD))
                    .setName(name)
                    .setAge(age)
                    .setStatus(1));
        }

        userRepository.saveAll(list);
    }

}



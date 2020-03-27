package cn.amos.security;

import cn.amos.security.dao.entity.CityEntity;
import cn.amos.security.dao.entity.UserEntity;
import cn.amos.security.dao.mapper.CityRepository;
import cn.amos.security.dao.mapper.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class SecurityDataInitTests {

    @Resource
    private CityRepository cityRepository;
    @Resource
    private UserRepository userRepository;

    public static void main(String[] args) {

    }

    @Test
    void initUser() {
        String[] nameArr = {"木婉清", "王语嫣", "任盈盈", "程灵素", "周芷若", "俞莲舟", "宋远桥", "俞岱岩", "张松溪", "张翠山", "殷梨亭", "莫声谷"};
        Random random = new Random();
        List<UserEntity> list = new ArrayList<>();
        for (String name : nameArr) {
            int age = random.nextInt(10) + 18;
            list.add(new UserEntity()
                    .setUsername("U" + age)
                    .setName(name)
                    .setPassword("000")
                    .setAge(age)
                    .setStatus(1));
        }
        userRepository.saveAll(list);
    }

    @Test
    void initCity() {
        String[] cityLevel1 = {"北京市", "上海市", "广州市", "深圳市", "成都市", "杭州市", "武汉市", "重庆市", "南京市", "天津市", "苏州市", "西安市", "长沙市", "沈阳市", "青岛市", "郑州市", "大连市", "东莞市", "宁波市"};
        String[] cityLevel2 = {"厦门市", "福州市", "无锡市", "合肥市", "昆明市", "哈尔滨市", "济南市", "佛山市", "长春市", "温州市", "石家庄市", "南宁市", "常州市", "泉州市", "南昌市", "贵阳市", "太原市", "烟台市", "嘉兴市", "南通市", "金华市", "珠海市", "惠州市", "徐州市", "海口市", "乌鲁木齐市", "绍兴市", "中山市", "台州市", "兰州市"};
        List<CityEntity> list = new ArrayList<>();
        for (String name : cityLevel1) {
            list.add(new CityEntity()
                    .setName(name)
                    .setLevel(1)
                    .setVersion(1));
        }
        for (String name : cityLevel2) {
            list.add(new CityEntity()
                    .setName(name)
                    .setLevel(2)
                    .setVersion(1));
        }
        cityRepository.saveAll(list);
    }

}



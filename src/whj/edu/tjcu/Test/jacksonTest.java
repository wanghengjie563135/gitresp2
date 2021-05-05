package whj.edu.tjcu.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import whj.edu.tjcu.domain.Person;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class jacksonTest {
    @Test
    public void test() throws Exception {
        //创建persond对象
        Person person = new Person();
        person.setUsername("王恒杰");
        person.setAge(21);
        person.setGender("男");
        //创建jackson的核心对象 objectMapper对象解析器（对象映射器）
        ObjectMapper mapper = new ObjectMapper();

        //3;转换
        //String value = mapper.writeValueAsString(person);
        //System.out.println(value);

        //用writeValue(file,person)写一个a.txt文件
        //mapper.writeValue(new File("d://a.txt"),person);
        mapper.writeValue(new FileWriter("d://b.txt"), person);

    }

    @Test
    public void test1() throws Exception {
        //创建person对象
        Person person = new Person();
        person.setUsername("王思楠");
        person.setAge(20);
        person.setGender("女");
        person.setBirthday(new Date());

        //创建json的Jackson核心类：objectMapper(对象映射器）
        ObjectMapper mapper = new ObjectMapper();
        //转换
        String value = mapper.writeValueAsString(person);
        System.out.println(value);
        //{"username":"王思楠","age":20,"gender":"女","birthday":1620112346417}
        //    @JsonIgnore:{"username":"王思楠","age":20,"gender":"女"}
        // @JsonFormat(pattern = "YYYY-MM-dd"):{"username":"王思楠","age":20,"gender":"女","birthday":"2021-05-04"}

    }

    @Test
    public void test2() throws Exception {
        //创建person对象
        Person person = new Person();
        person.setUsername("王思楠");
        person.setAge(20);
        person.setGender("女");
        person.setBirthday(new Date());
        Person person1 = new Person();
        person.setUsername("王思楠");
        person.setAge(20);
        person.setGender("女");
        person.setBirthday(new Date());
        Person person2 = new Person();
        person.setUsername("王思楠");
        person.setAge(20);
        person.setGender("女");
        person.setBirthday(new Date());
        //创建数组
        List<Person> list = new ArrayList<Person>();
        list.add(person);
        list.add(person1);
        list.add(person2);

        //创建json的Jackson核心类：objectMapper(对象映射器）
        ObjectMapper mapper = new ObjectMapper();
        //转换
        String value = mapper.writeValueAsString(list);
        System.out.println(value);
    }

    @Test
    public void test3() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "王恒杰");
        map.put("age", 22);
        map.put("gender", "男");

        //创建json的Jackson核心类：objectMapper(对象映射器）
        ObjectMapper mapper = new ObjectMapper();
        //转换
        String value = mapper.writeValueAsString(map);
        System.out.println(value);
    }
    @Test
    public  void test4() throws Exception {
       //初始化字符串
        String json="{\"username\":\"王思楠\",\"age\":20,\"gender\":\"女\",\"birthday\":1620112346417}";
        //jackson核心类objectMapper
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);


    }
}
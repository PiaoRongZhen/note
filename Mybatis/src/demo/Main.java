package demo;

import demo.mapper.RoleMapper;
import demo.pojo.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession(true);

        RoleMapper roleMapper = session.getMapper(RoleMapper.class);

        Role role = new Role();
        role.setRoleName("testName");
        role.setNote("testNote");
        roleMapper.insertRole(role);

        System.out.println(role.getId());

        role = roleMapper.getRole(role.getId());

        System.out.println(role.toString());

        roleMapper.deleteRole(role.getId());

        session.close();

    }
}

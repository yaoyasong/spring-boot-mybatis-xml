package com.neo.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neo.model.User;
import com.neo.enums.UserSexEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() throws Exception {
		userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN, "Address 1"));
		userMapper.insert(new User("bb", "b123456", UserSexEnum.WOMAN, "Address 2"));
		userMapper.insert(new User("cc", "b123456", UserSexEnum.WOMAN, "Address 3"));

		System.out.println(userMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<User> users = userMapper.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users.toString());
		}
	}
	
	
	@Test
	public void testUpdate() throws Exception {

		Long id =30l;
		User user = userMapper.getOne(id);
		System.out.println(user.toString());
		user.setNickName("neo");
		user.setAddress("New Address");
		userMapper.update(user);
		Assert.assertTrue(("neo".equals(userMapper.getOne(id).getNickName())));
		Assert.assertTrue(("New Address".equals(userMapper.getOne(id).getAddress())));
	}

}
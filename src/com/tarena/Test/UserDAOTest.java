package com.tarena.Test;

import java.sql.SQLException;

import com.tarena.dao.DAOFactory;
import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import org.junit.Test;


public class UserDAOTest {
	@Test
	public void test() throws Exception {
		UserDAO dao = DAOFactory.getUserDAO();
		
//		User u = new User();
//		u.setEmail("e@121");
//		u.setNickname("saaa");
//		u.setEmail_verify(true);
//		u.setEmail_verify_code("sddsfwefwe");
//		u.setLast_login_ip("10.21.32.42");
//		u.setLast_login_time(212432);
//		u.setPassword("1234");
//		u.setUser_integral(123);
//		
//		dao.save(u);
		User u = dao.findByEmail("caofeng2012@126.com");
		u.setUser_integral(15);
		dao.update(u);
		System.out.println(u.isEmail_verify());
	}
}

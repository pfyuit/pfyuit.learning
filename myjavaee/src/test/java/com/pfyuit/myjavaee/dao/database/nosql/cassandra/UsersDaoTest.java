package com.pfyuit.myjavaee.dao.database.nosql.cassandra;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfyuit.myjavaee.dao.database.nosql.cassandra.UsersDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/nosql/cassandra/myjavaee-database-nosql-cassandra-test.xml" })
public class UsersDaoTest {

	@Autowired
	private UsersDao usersDao;

	@Test
	public void test() {
		usersDao.createKeySpace();
		usersDao.createTable();
		usersDao.save();
		usersDao.update();
		usersDao.find();
		// usersDao.delete();
	}

}

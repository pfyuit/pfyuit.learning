package com.pfyuit.myjavaee.service.database.rdbms.hibernate;

import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.model.database.rdbms.hibernate.BlogModel;
import com.pfyuit.myjavaee.service.database.rdbms.hibernate.BlogService;

/**
 * The transaction is rolled back by default when setting "defaultRollback = true".
 * @author yupengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/rdbms/hibernate/myjavaee-database-rdbms-hibernate-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManagerMyblog", defaultRollback = true)
@Transactional
public class BlogServiceTest {

	@Autowired
	private BlogService blogService;

	@Test
	public void testSave() {
		BlogModel model = new BlogModel();
		model.setBlogAuthor("Example Blog Author");
		model.setBlogContent("Example Blog Content");
		model.setBlogOriginal("Example Blog Original");
		model.setBlogTitle("Example Blog Title");
		model.setCreateDate(new Timestamp(new Date().getTime()));
		model.setLastModified(new Timestamp(new Date().getTime()));
		model.setReadCount(new Long(0));
		blogService.save(model);
	};

	@Test
	public void testDelete() {
		BlogModel model = blogService.findById(3);
		blogService.delete(model);
	};

	@Test
	public void testUpdate() {
		BlogModel model = blogService.findById(3);
		model.setBlogAuthor("Updated Blog Author");
		model.setBlogContent("Updated Blog Content");
		model.setBlogOriginal("Updated Blog Original");
		model.setBlogTitle("Updated Blog Title");
		model.setCreateDate(new Timestamp(new Date().getTime()));
		model.setLastModified(new Timestamp(new Date().getTime()));
		model.setReadCount(new Long(1));
		blogService.update(model);
	};

	@Test
	public void testFindById() {
		BlogModel model = blogService.findById(3);
		assertNotNull(model);
	};

	@Test
	public void testFindAll() {
		List<BlogModel> models = blogService.findAll();
		assertNotNull(models);
	};

}

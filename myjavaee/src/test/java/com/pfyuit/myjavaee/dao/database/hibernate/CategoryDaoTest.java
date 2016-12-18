package com.pfyuit.myjavaee.dao.database.hibernate;

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

import com.pfyuit.myjavaee.dao.database.hibernate.CategoryDao;
import com.pfyuit.myjavaee.model.database.hibernate.CategoryModel;
import com.pfyuit.myjavaee.util.BeanUtil;

/**
 * The transaction is rolled back by default when setting
 * "defaultRollback = true".
 * @author yupengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/hibernate/myjavaee-database-hibernate-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManagerMyblog", defaultRollback = true)
@Transactional
public class CategoryDaoTest {

	@Autowired
	private CategoryDao categoryDao;

	@Test
	public void testSave() {
		CategoryModel model = new CategoryModel();
		model.setCategoryName("Example Category");
		model.setCreateTime(new Timestamp(new Date().getTime()));
		model.setSortId(1);
		categoryDao.saveWithSession(model);
	};

	@Test
	public void testDelete() {
		CategoryModel model = categoryDao.findByIdWithSession(5);
		categoryDao.deleteWithSession(model);
	};

	@Test
	public void testUpdate() {
		CategoryModel model = categoryDao.findByIdWithSession(5);
		model.setCategoryName("Updated Category");
		model.setCreateTime(new Timestamp(new Date().getTime()));
		model.setSortId(2);
		categoryDao.updateWithSession(model);
	};

	@Test
	public void testFindById() {
		CategoryModel model = categoryDao.findByIdWithSession(5);
		assertNotNull(model);
		assertNotNull(model.getBlogs());
		BeanUtil.printModel(model);
	};

	@Test
	public void testFindAll() {
		List<CategoryModel> models = categoryDao.findByAllWithHQLQuery();
		assertNotNull(models);
	};

}
package com.pfyuit.myjavaee.dao.hibernate;

import java.util.List;

import com.pfyuit.myjavaee.model.hibernate.BlogModel;

public interface BlogDao {

	public abstract void save(BlogModel model);

	public abstract void delete(BlogModel model);

	public abstract void update(BlogModel model);

	public abstract BlogModel findById(int blogId);

	public abstract List<BlogModel> findAll();

}
package com.pfyuit.myjavaee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfyuit.myjavaee.dto.BlogDto;
import com.pfyuit.myjavaee.model.Apply;
import com.pfyuit.myjavaee.model.ApplyModel;
import com.pfyuit.myjavaee.service.ApplyService;
import com.pfyuit.myjavaee.service.BlogService;

@Controller
@RequestMapping(value = { "/databases" })
public class DatabaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseController.class);

	@Autowired
	private BlogService blogService;

	@Autowired
	private ApplyService applyService;

	@RequestMapping(value = "/testSingleDataSouce", method = RequestMethod.GET)
	@ResponseBody
	public String testSingleDataSource() {
		LOGGER.info("testSingleDataSource");

		// Insert

		// Delete

		// Update

		// Select
		BlogDto blogDto = blogService.getBlogByHibernate(10);
		BlogDto blogDto1 = blogService.getBlogByMyBatis(10);

		return "success";
	}

	@RequestMapping(value = "/testMultiDataSouce", method = RequestMethod.GET)
	@ResponseBody
	public String testMultiDataSource() {
		LOGGER.info("testMultiDataSouce");

		// Insert

		// Delete

		// Update

		// Select
		BlogDto blogDto = blogService.getBlogByHibernate(10);
		BlogDto blogDto1 = blogService.getBlogByMyBatis(10);

		ApplyModel applyModel = applyService.getApplyByHibernate(36);
		Apply apply = applyService.getApplyByMyBatis(36);

		return "success";
	}

}

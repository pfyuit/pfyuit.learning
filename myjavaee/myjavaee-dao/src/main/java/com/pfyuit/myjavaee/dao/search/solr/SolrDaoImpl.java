package com.pfyuit.myjavaee.dao.search.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfyuit.myjavaee.model.search.solr.SearchItem;

/**
 * Solr search dao implementation.
 * @author yupengfei
 */
@Service
public class SolrDaoImpl implements SolrDao {

	@Autowired
	private SolrConfig solrConfig;

	private static final String DEFAULT_QUERY_FIELD = "blogcontent";
	private static final String DEFAULT_RETURN_FIELD = "id";

	@Override
	public List<Integer> searchBlog(String key) throws SolrServerException,IOException {
		HttpSolrServer server = new HttpSolrServer(solrConfig.getUrl());
		server.setSoTimeout(Integer.parseInt(solrConfig.getSoTimeout()));
		server.setConnectionTimeout(Integer.parseInt(solrConfig.getConnectionTimeout()));
		server.setDefaultMaxConnectionsPerHost(Integer.parseInt(solrConfig.getDefaultMaxConnectionsPerHost()));
		server.setMaxTotalConnections(Integer.parseInt(solrConfig.getMaxTotalConnections()));
		server.setFollowRedirects(false);
		server.setAllowCompression(true);
		server.setMaxRetries(1);

		SolrQuery query = new SolrQuery();
		query.setQuery(DEFAULT_QUERY_FIELD + ":" + key);
		query.addField(DEFAULT_RETURN_FIELD);
		query.addSort(DEFAULT_RETURN_FIELD, SolrQuery.ORDER.asc);

		QueryResponse response = server.query(query);
		List<SearchItem> items = response.getBeans(SearchItem.class);

		List<Integer> result = new ArrayList<Integer>();
		for (SearchItem item : items) {
			result.add(Integer.valueOf(item.getId()));
		}
		return result;
	}
}

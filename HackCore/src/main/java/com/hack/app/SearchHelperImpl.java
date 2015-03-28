package com.hack.app;

import java.util.List;


public class SearchHelperImpl implements ISearchHelper{
	
	private ICrawl crawl;
    
	@Override
	public List<Offer> search(String searchQuery){
		return crawl.getSortedOffers(searchQuery);
	}
}

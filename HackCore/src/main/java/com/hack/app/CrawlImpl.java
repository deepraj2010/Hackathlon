package com.hack.app;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.lang.model.util.Elements;

import org.jsoup.Jsoup;

import org.w3c.dom.Document;

public class CrawlImpl implements ICrawl{
	
	List<String> urls = new ArrayList<String>();
	
	ExecutorService executor =  Executors.newFixedThreadPool(3000);

	@SuppressWarnings("unchecked")
	public List<Offer> getSortedOffers(String searchQuery){
		List<String> urls = createUrlsFromString(searchQuery);
		List<Offer> offerList = getOfferList(urls);
		Collections.sort(offerList);
		return offerList;
	}
	
	private List<String> createUrlsFromString(String searchQuery){
		for(String url : urls){
			StringBuilder str = new StringBuilder();
			str.append("?search=");
			str.append(searchQuery);
		}
	}
	
	private List<Offer> getOfferList(List<String> urls){
		List<Document> documents = new ArrayList<Document>(urls.size());
		List<Offer> offers = new ArrayList<Offer>();
		for(String url : urls){
			Runnable worker = new MyRunnable(url);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		for(Document doc : MyRunnable.objList){
			// Assuming the ids corresponds to value
			
			Offer offer = new Offer();
			offer.setName(doc.select("#name").text());
			offer.setDiscount(doc.select("#discount").text());
			offer.setFinalPrice(doc.select("#finalPrice").text());
			offer.setSource(doc.select("#source").text());
			offer.setDescription(doc.select("#description").text());
			offers.add(offer);
		}
		return offers;
	}
	
	public static class MyRunnable implements Runnable {
		private final String url;
		public static List<Document> objList = Collections.synchronizedList(new ArrayList<Document>());
		MyRunnable(String url) {
			this.url = url;
		}
 
		@Override
		public void run() {

			try {
				Document doc = Jsoup.connect(url).get();
				objList.add(doc);
			} catch (Exception e) {
			
			}
		}
	}
	
	
}

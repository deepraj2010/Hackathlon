package com.hack.app;

import java.util.List;

public interface ICrawl {
	List<Offer> getSortedOffers(String searchQuery);
}

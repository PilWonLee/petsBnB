package com.petsbnb.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IBookingService {

	List<LinkedHashMap<Object, Object>> getBookingList(LinkedHashMap<Object, Object> req) throws Exception;

	HashMap<Object, Object> getBookingDetail(HashMap<Object, Object> req) throws Exception;

	List<HashMap<Object, Object>> getMoreReview(HashMap<Object, Object> req) throws Exception;

	HashMap<Object, Object> insertReview(HashMap<Object, Object> req) throws Exception;
	
}

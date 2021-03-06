package com.petsbnb.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.petsbnb.persistance.mapper.BookingMapper;
import com.petsbnb.service.IBookingService;
import com.petsbnb.util.DecodeUtil;

@Service("BookingService")
public class BookingService implements IBookingService{
	
	@Resource(name="BookingMapper")
	private BookingMapper bookingMapper;

	@Override
	public List<LinkedHashMap<Object, Object>> getBookingList(LinkedHashMap<Object, Object> req) throws Exception{
		return bookingMapper.getBookingList(req);
	}

	@Override
	public HashMap<Object, Object> getBookingDetail(HashMap<Object, Object> req) throws Exception {
		
		HashMap<Object, Object> rslt = new HashMap<Object, Object>();
		
		rslt.put("images", bookingMapper.getBookingDetailImages(req.get("petsitterNo").toString()));
		rslt.put("details", bookingMapper.getBookingDetail(req.get("petsitterNo").toString()));
		rslt.put("reviews", DecodeUtil.decodeName(bookingMapper.getBookingDetailReviews(req)));
		rslt.put("petsitterUserProfileImage", bookingMapper.getPetsitterUserImage(req.get("petsitterNo").toString()));
		
		return rslt;
	}

	@Override
	public List<HashMap<Object, Object>> getMoreReview(HashMap<Object, Object> req) throws Exception {
		
		return  DecodeUtil.decodeName(bookingMapper.getBookingDetailReviews(req));
	}

	@Override
	public HashMap<Object, Object> insertReview(HashMap<Object, Object> req) throws Exception {
		HashMap<Object, Object> rslt = new HashMap<>();
		int rsltYn = bookingMapper.insertReview(req);
		if(rsltYn == 1) {
			rslt.put("regSuccess", rsltYn);
		}else {
			rslt.put("regSuccess", 0);
		}
		
		return rslt;
	};
	
}

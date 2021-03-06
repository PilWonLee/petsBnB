package com.petsbnb.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petsbnb.service.IBookingService;
import com.petsbnb.util.AES256Util;
import com.petsbnb.util.CmmUtil;

@Controller
public class BookingController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="BookingService")
	private IBookingService bookingService;
	
	@RequestMapping("/booking/getBookingList")
	public @ResponseBody List<LinkedHashMap<Object, Object>> getBookingList(@RequestBody LinkedHashMap<Object, Object> req) throws Exception{
		log.info(this.getClass().getName() + " start!!");
		
		log.info("getBookingList");
		log.info("page : "+req.get("page"));
		log.info("search : "+req.get("search"));
		
		List<LinkedHashMap<Object,Object>> rsltList = bookingService.getBookingList(req);
		
		
		log.info(this.getClass().getName() + "end!!");
		return rsltList;
	}
	
	@RequestMapping("/booking/getBookingDetail")
	public @ResponseBody HashMap<Object, Object> getBookingDetail(@RequestBody HashMap<Object, Object> req) throws Exception{
		log.info(this.getClass().getName() + "start!!");
		
		log.info("petsitterNo : "+ req.get("petsitterNo"));
		log.info("reviewNow : "+ req.get("reviewNow"));
		
		HashMap<Object, Object> rslt = bookingService.getBookingDetail(req);
		
		
		log.info(this.getClass().getName() + "end!!");
		return rslt;
	}
	
	@RequestMapping("/booking/getMoreReview")
	public @ResponseBody List<HashMap<Object,Object>> getMoreReview(@RequestBody HashMap<Object, Object> req) throws Exception{
		log.info(this.getClass().getName() + " start!!");
		
		log.info("petsitterNo : "+ req.get("petsitterNo"));
		log.info("reviewNow : "+ req.get("reviewNow"));
		
		
		List<HashMap<Object, Object>> rsltList = bookingService.getMoreReview(req);
		
		
		log.info(this.getClass().getName() + " end!!");
		return rsltList;
	}
	
	@RequestMapping("/booking/reviewWrite")
	public @ResponseBody HashMap<Object, Object> reviewWrite(@RequestBody HashMap<Object, Object> req) throws Exception{
		log.info(this.getClass().getName() + " start!!");
		
		log.info("userNo : "+ req.get("userNo"));
		log.info("reservationNo : "+ req.get("reservationNo"));
		log.info("petsitterNo : "+ req.get("petsitterNo"));
		log.info("starCount : "+ req.get("starCount"));
		log.info("reviewText : "+ req.get("reviewText"));
		
		log.info(this.getClass().getName() + " end!!");
		
		return bookingService.insertReview(req);
	}
}

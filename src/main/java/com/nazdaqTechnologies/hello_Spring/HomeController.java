package com.nazdaqTechnologies.hello_Spring;

import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger log = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public void handleGET(HttpServletRequest request,
			HttpEntity<byte[]> requestEntity) {
		log.info(request.getParameter("model"));
		log.info(request.getParameter("year"));
		log.info(request.getParameter("make"));
		log.info(requestEntity.getHeaders().toString());

	}

	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	public void handlePost(@RequestBody String body, Writer writer)
			throws IOException {
		// log.info(body.toString());
		Document doc = Jsoup.connect("http://www.decodethis.com/list-vins")
				.get();
		Element element = doc.body();

		Elements li = element.getElementsByClass("makeItem");
		int numberOfMakers = li.size();

		// loop gets all the makers

//		for (int i = 0; i < numberOfMakers; i++) {
//			// get a tag
//			Element temp = li.get(i);
//			//we can get the maker and the number of vins
//			// String makerAndNum = a.text();
//			Elements a = temp.getElementsByTag("a");
//			// get the carmaker
//			String maker = a.text();
//			// have the ability to get link
//			// String makerLink = a.attr("href");
//
//			log.info(maker);
//		}
		
		doc = Jsoup.connect("http://www.decodethis.com/list-vins/make/Acura")
				.get();
		Element years = doc.body();
		// for loop to get the years for acura
		Elements yearLi = years.getElementsByTag("li");
		for (int i = 0; i < yearLi.size(); i++) {
			Element temp = yearLi.get(i);
			Elements a = temp.getElementsByTag("a");
			String year = a.text();
			if (year.length() == 4) {
				try {
					Integer.parseInt(year);
					log.info(year);
				} catch (NumberFormatException e) {
					log.error("NumberFormatException");
				}
			}

		}

		/*
		 * we can keep using the same concept to scrap the information we need
		 */
		log.info("Number of Makers: " + String.valueOf(numberOfMakers));
	}
}

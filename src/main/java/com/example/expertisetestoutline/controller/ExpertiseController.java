package com.example.expertisetestoutline.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.expertisetestoutline.request.KelvinRequest;

@RestController
@RequestMapping("/api")
public class ExpertiseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExpertiseController.class);

	@RequestMapping(value = "/conversions/ktoc", method = RequestMethod.POST)
	public float kelvinToCelsius(@RequestBody KelvinRequest request) throws NumberFormatException, IOException {
		LOGGER.info("Conversionsktoc service has stared......................................");
		// String to float conversion
		String kelvin = request.getKelvin();
		float kelvinFloatValue = Float.parseFloat(kelvin);
		// Get the console input for the temperature in Kelvin
		System.out.println("Temperature in Kelvin:" + kelvinFloatValue);
		// Kelvin to Degree Celsius Conversion
		float celsius = kelvinFloatValue - 273.15F;
		System.out.println("Celsius: " + celsius);
		LOGGER.info("Conversionsktoc service has ended......................................");
		return celsius;

	}

}

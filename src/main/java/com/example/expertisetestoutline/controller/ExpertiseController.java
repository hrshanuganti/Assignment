package com.example.expertisetestoutline.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.expertisetestoutline.request.CelsiusRequest;
import com.example.expertisetestoutline.request.KelvinRequest;
import com.example.expertisetestoutline.request.KilometersRequest;
import com.example.expertisetestoutline.request.MilesRequest;

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

	@RequestMapping(value = "/conversions/ctok", method = RequestMethod.POST)
	public float celsiusToKelvin(@RequestBody CelsiusRequest request) throws NumberFormatException, IOException {
		LOGGER.info("Conversionsctok service has stared......................................");
		// String to float conversion
		String celsius = request.getCelsius();
		float celsiusFloatValue = Float.parseFloat(celsius);
		// Get the console input for the temperature in Celsius
		System.out.println("Temperature in Degree Celsius:" + celsiusFloatValue);
		// Degrees Celsius to Kelvin Conversion
		float kelvin = celsiusFloatValue + 273.15F;
		System.out.println("Kelvin: " + kelvin);
		LOGGER.info("Conversionsctok service has ended......................................");
		return kelvin;
	}

	@RequestMapping(value = "/conversions/mtok", method = RequestMethod.POST)
	public float milesToKilometers(@RequestBody MilesRequest request) throws NumberFormatException, IOException {
		LOGGER.info("Conversionsmtok service has stared......................................");
		String miles = request.getMiles();
		// String value to Float Conversion
		float milesFloatValue = Float.parseFloat(miles);
		System.out.println("Enter a number of miles: " + milesFloatValue);
		// Miles to Kilometers conversion Logic
		// 1 mile = 1.609 344 kilometer;
		float km = milesFloatValue * 1.609344f;
		System.out.println(milesFloatValue + " miles is " + km + " kilometers.");
		LOGGER.info("Conversionsmtok service has ended......................................");
		return km;
	}

	@RequestMapping(value = "/conversions/ktom", method = RequestMethod.POST)
	public double kilometersToMiles(@RequestBody KilometersRequest request) throws NumberFormatException, IOException {
		LOGGER.info("Conversionsktom service has started......................................");
		String kilometers = request.getKilometers();
		// String value to Double Conversion
		double kilometersDoubleValue = Double.parseDouble(kilometers);
		System.out.println("Enter a number of Kilometers: " + kilometersDoubleValue);
		// Conversion Logic
		double miles = kilometersDoubleValue / 1.6;
		System.out.println(miles + " Miles");
		LOGGER.info("Conversionsktom service has ended......................................");
		return miles;
	}

}

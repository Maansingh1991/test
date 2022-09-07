package test;

import java.util.Scanner;

import org.json.JSONObject;

/*
 * 
 * Starting File
 * 
 * 
 * 
 * 
 * */

public class Main {
	public static void main(String[] args) {
		String country =  null;
		
		// loop to check country is entered or not
		
		do {
			 Scanner myObj = new Scanner(System.in);  // Create a Scanner object
			    System.out.println("Please enter your country name");

			    country = myObj.nextLine();  
			    System.out.println("You have entered " + country);
			myObj.close();
		}while(country == null || country.length() == 0);
		
		
		
		// creating service object
		CovidCasesService ccs = new CovidCasesService();
		try {
			//API calls and converting string to JSON
		     JSONObject jsonObject = new JSONObject(ccs.getCases(country));

			JSONObject casesData = jsonObject.getJSONObject("All");
			System.out.println("Confirmed :- "+ casesData.get("confirmed"));
			System.out.println("Recovered :- "+ casesData.get("recovered"));
			System.out.println("Deaths :- "+ casesData.get("deaths"));
			
			JSONObject vaccinationObject = new JSONObject(ccs.getVaccination(country));
			System.out.println("Vaccinated level in % of total population :- "+( (vaccinationObject.getJSONObject("All").getLong("people_vaccinated")*100) / vaccinationObject.getJSONObject("All").getLong("population"))+"%");
			
			JSONObject historyObject = new JSONObject(ccs.getHistory(country));
			System.out.println("New confirmed cases : -"+ historyObject.getJSONObject("All").get("dates"));

			
		} catch (Exception e) {
			System.out.println("Error Raised");
			
			e.printStackTrace();
		} 
		
	}

}

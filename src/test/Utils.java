package test;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;


public class Utils {
	
	public static String httpUtility (String url, String country) throws Exception, InterruptedException {
		var client = HttpClient.newHttpClient();

		// create a request
		
		var request = HttpRequest.newBuilder(
		       URI.create(url+"country="+country))
		   .header("accept", "application/json")
		   .build();

		// use the client to send the request
		var response = client.send(request, BodyHandlers.ofString());
		return response.body();
	}

}

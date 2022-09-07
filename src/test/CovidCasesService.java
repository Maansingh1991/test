package test;

/**
 * 
 * 
 * API Calls 
 * 
 * 
 * */
public class CovidCasesService {

	public String getCases(String country) throws Exception {
		return Utils.httpUtility(Constants.LIVE_CASES_URL, country);
	}

	public String getHistory(String country) throws Exception {
		return Utils.httpUtility(Constants.HISTORY_CASES_URL, country);

	}

	public String getVaccination(String country) throws Exception {
		return Utils.httpUtility(Constants.VACCINE_URL, country);

	}
}

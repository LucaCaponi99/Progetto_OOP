package ProgettoOOP.app.service;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import ProgettoOOP.app.model.Countries;

public interface CountryService {
	
	public abstract void InsertCountry(Countries country) throws Exception;
	public abstract void DeleteCountry(String ISO2);
	public abstract String totalCountries() throws IOException;
	public abstract String totalStatusCountries(String from, String to) throws IOException, ParseException, JSONException;
	public abstract String totalStats(String from, String to) throws IOException, ParseException, JSONException;
	public abstract String ClassifyConfirmed(String from, String to) throws IOException, ParseException, JSONException;
	public abstract String ClassifyDeaths(String from, String to) throws IOException, ParseException, JSONException;
	public abstract String ClassifyRecovered(String from, String to) throws IOException, ParseException, JSONException;
	public abstract String ClassifyActive(String from, String to) throws IOException, ParseException, JSONException;
	public abstract Collection<Countries> gettingCountries();
	public abstract Map<String, String> gettingMetadata();
	public abstract Collection<Countries> gettingfilterCountries(String cont);
	public abstract String yourcontinent() throws Exception;
	
}

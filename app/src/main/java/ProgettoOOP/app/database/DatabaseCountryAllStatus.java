<<<<<<< HEAD
package ProgettoOOP.app.database;

/**
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 * La classe DatabaseCountryAllStatus apre la connessione all'API "GET BY COUNTRY ALL STATUS" 
 * da cui prendiamo i dati per ogni nazione caricata su Postman e per un determinato lasso di tempo.
 * Si riesce quindi ad ottenere il numero di casi COVID-19 confermati, decessi, ricoverati e positivi.
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.World;

public class DatabaseCountryAllStatus {

	private static Map<String, Countries> world = World.getworld();

	public static String DownloadDataCountryAllStatus(String from, String to) throws IOException {
		Map<String, Object> out = new LinkedHashMap<>();
		JSONParser jsonParser = new JSONParser();

		for (String key : world.keySet()) {
			

			String slug = world.get(key).getSlug();
			if(slug!="") {
			String nomeurl = "https://api.covid19api.com/country/" + slug + "?from=" + from + "&to=" + to;
			
			try {
				URL info = new URL(nomeurl);
				URLConnection URLConn = info.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(URLConn.getInputStream()));
				String inputLine;
				String outputLine = "";

				while ((inputLine = in.readLine()) != null)
					outputLine = outputLine + inputLine;

				in.close();

				out.put(world.get(key).getCountry(), jsonParser.parse(outputLine));

			} catch (Exception e) {
				e.printStackTrace();
			}
			}

		}
		Map<String, Object> result = new LinkedHashMap<>();
		for (String key : out.keySet()) {
			JSONArray countryObject = (JSONArray) out.get(key);

			long confirmedstart = 0;
			long deathsstart = 0;
			long recoveredstart = 0;
			long activestart = 0;
			long confirmedlast = 0;
			long deathslast = 0;
			long recoveredlast = 0;
			long activelast = 0;
			
			for (int i = 0; i < countryObject.size(); i++) {

				JSONObject countryObjectall = (JSONObject) countryObject.get(i);
				if (i == 0) {
					confirmedstart = (Long) countryObjectall.get("Confirmed");
					deathsstart = (Long) countryObjectall.get("Deaths");
					recoveredstart = (Long) countryObjectall.get("Recovered");
					activestart = (Long) countryObjectall.get("Active");
				}

				if (i == countryObject.size() - 1) {
					confirmedlast = (Long) countryObjectall.get("Confirmed");
					deathslast = (Long) countryObjectall.get("Deaths");
					recoveredlast = (Long) countryObjectall.get("Recovered");
					activelast = (Long) countryObjectall.get("Active");
					
				}

			}
			
			
			Map<String, Long> stats = new LinkedHashMap<String, Long>();
			
			stats.put("Confirmed", confirmedlast - confirmedstart);
			stats.put("Deaths", deathslast - deathsstart);
			stats.put("Recovered", recoveredlast - recoveredstart);
			stats.put("Active", activelast - activestart);
			result.put(key, stats);
			
		}
		
		
		return new JSONObject(result).toString();
	
	}
	
	public static Map<String, Long> sortHashMapByValues(Map<String, Long> passedMap) {
	       List<String> mapKeys = new ArrayList<>(passedMap.keySet());
	       List<Long> mapValues = new ArrayList<>(passedMap.values());
	       Collections.sort(mapValues);
	       Collections.sort(mapKeys);

	       LinkedHashMap<String, Long> sortedMap = new LinkedHashMap<>();

	       Iterator<Long> valueIt = mapValues.iterator();
	       while (valueIt.hasNext()) {
	           Long val = valueIt.next();
	           Iterator<String> keyIt = mapKeys.iterator();

	           while (keyIt.hasNext()) {
	               String key = keyIt.next();
	               Long comp1 = passedMap.get(key);
	               Long comp2 = val;

	               if (comp1.equals(comp2)) {
	                   keyIt.remove();
	                   sortedMap.put(key, val);
	                   break;
	               }
	               
	           }
	       }
	       return sortedMap;
	}
	
}
=======
package ProgettoOOP.app.database;

/**
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 * La classe DatabaseCountryAllStatus apre la connessione all'API "GET BY COUNTRY ALL STATUS" 
 * da cui prendiamo i dati per ogni nazione caricata su Postman e per un determinato lasso di tempo.
 * Si riesce quindi ad ottenere il numero di casi COVID-19 confermati, decessi, ricoverati e positivi.
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.World;

public class DatabaseCountryAllStatus {

	private static Map<String, Countries> world = World.getworld();

	public static String DownloadDataCountryAllStatus(String from, String to) throws IOException {
		Map<String, Object> out = new LinkedHashMap<>();
		JSONParser jsonParser = new JSONParser();

		for (String key : world.keySet()) {
			

			String slug = world.get(key).getSlug();
			if(slug!="") {
			String nomeurl = "https://api.covid19api.com/country/" + slug + "?from=" + from + "&to=" + to;
			
			try {
				URL info = new URL(nomeurl);
				URLConnection URLConn = info.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(URLConn.getInputStream()));
				String inputLine;
				String outputLine = "";

				while ((inputLine = in.readLine()) != null)
					outputLine = outputLine + inputLine;

				in.close();

				out.put(world.get(key).getCountry(), jsonParser.parse(outputLine));

			} catch (Exception e) {
				e.printStackTrace();
			}
			}

		}
		Map<String, Object> result = new LinkedHashMap<>();
		for (String key : out.keySet()) {
			JSONArray countryObject = (JSONArray) out.get(key);

			long confirmedstart = 0;
			long deathsstart = 0;
			long recoveredstart = 0;
			long activestart = 0;
			long confirmedlast = 0;
			long deathslast = 0;
			long recoveredlast = 0;
			long activelast = 0;
			
			for (int i = 0; i < countryObject.size(); i++) {

				JSONObject countryObjectall = (JSONObject) countryObject.get(i);
				if (i == 0) {
					confirmedstart = (Long) countryObjectall.get("Confirmed");
					deathsstart = (Long) countryObjectall.get("Deaths");
					recoveredstart = (Long) countryObjectall.get("Recovered");
					activestart = (Long) countryObjectall.get("Active");
				}

				if (i == countryObject.size() - 1) {
					confirmedlast = (Long) countryObjectall.get("Confirmed");
					deathslast = (Long) countryObjectall.get("Deaths");
					recoveredlast = (Long) countryObjectall.get("Recovered");
					activelast = (Long) countryObjectall.get("Active");
					
				}

			}
			
			
			Map<String, Long> stats = new LinkedHashMap<String, Long>();
			stats.put("Confirmed", confirmedlast - confirmedstart);
			stats.put("Deaths", deathslast - deathsstart);
			stats.put("Recovered", recoveredlast - recoveredstart);
			stats.put("Active", activelast - activestart);			
			result.put(key, stats);
			
		}
		
		
		return new JSONObject(result).toString();
		
		
	}
	

	
	
	
	
	
	
}
>>>>>>> branch 'master' of https://github.com/LucaCaponi/Progetto_OOP

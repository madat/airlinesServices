package com.ws.airlines.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * a service class that can be replaced with DAO or suome DB access layer class.
 * Since we are more interested with rest service applications, we are not doing any DB
 * functionalities. Instead of that we are having a  map that will hold AirLine data.
 * we will handle all operations on that map.
 * @author user
 *
 */
public class AirlinesServices {

	public List<AirLines> airLines=new ArrayList();

	public Map<String, AirLines> airLinesMap=new HashMap<String, AirLines>();

	{
       AirLines spicejet=new AirLines("JetAirWays","www.jetairways.com");
       AirLines airIndia=new AirLines("AirIndia","www.airindia.com");
       AirLines indigoFlight=new AirLines("Indigo","www.inidgo.com");

       airLinesMap.put(spicejet.getName().toLowerCase(), spicejet);
       airLinesMap.put(airIndia.getName().toLowerCase(), airIndia);
       airLinesMap.put(indigoFlight.getName().toLowerCase(), indigoFlight);

	}

	public List<AirLines> getAllAirLines(){
      return  new ArrayList<AirLines>(airLinesMap.values());
	}

}

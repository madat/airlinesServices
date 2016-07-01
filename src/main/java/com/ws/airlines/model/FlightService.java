package com.ws.airlines.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;
import javax.ws.rs.GET;

public class FlightService {
	// this map holds Flights for an Airlines
	static Map<String,List<Flight>> flights=new HashMap<String,List<Flight>>();

	//initializing the flights map with some Flights
	static{
        List<Flight> jetAirWaysFlights=new ArrayList<Flight>();
        jetAirWaysFlights.add(new Flight("JARXY21","Delhi","Mumbai"));
        jetAirWaysFlights.add(new Flight("JARPQ90","Bangalore","Delhi"));
        flights.put("JetAirWays".toLowerCase(), jetAirWaysFlights);

        List<Flight> airIndiaFlights=new ArrayList<Flight>();
        airIndiaFlights.add(new Flight("AIN54DR","Mumbai","Pune"));
        airIndiaFlights.add(new Flight("AIN68GH","Bangalore","Delhi"));
        flights.put("AirIndia".toLowerCase(), airIndiaFlights);


        List<Flight> indigoFlights=new ArrayList<Flight>();
        indigoFlights.add(new Flight("ING89HY","Delhi","Mumbai"));
        indigoFlights.add(new Flight("ING76LK","Bangalore","Pune"));
        flights.put("Indigo".toLowerCase(), indigoFlights);
	}


	public List<Flight> findFlights(String airLines){
       return flights.get(airLines.toLowerCase());
	}


	public void addNewFlight(String airLines, Flight flight){
         List<Flight> existingFlights = flights.get(airLines.toLowerCase());
         existingFlights.add(flight);
	}

}

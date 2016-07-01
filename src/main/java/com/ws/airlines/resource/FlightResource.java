package com.ws.airlines.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ws.airlines.model.Flight;
import com.ws.airlines.model.FlightService;

@Path("/{airLines}")
public class FlightResource {

	FlightService flightServ=new FlightService();


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> findFlights(@PathParam("airLines") String airLines){
		System.out.println("airLines="+airLines);
        List<Flight> flights = flightServ.findFlights(airLines);
        return flights;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNewFlight(@PathParam("airLines") String airLines,Flight newFlight){
        flightServ.addNewFlight(airLines, newFlight);
        return Response.status(Status.CREATED).entity(newFlight).build();
	}
}

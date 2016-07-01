package com.ws.airlines.resource;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ws.airlines.model.AirLines;
import com.ws.airlines.model.AirlinesServices;
import com.ws.airlines.resource.exception.DatanotFoundException;
import com.ws.airlines.resource.exception.ErrorMessage;

@Path("airlines")
@Produces({MediaType.APPLICATION_JSON})
public class AirlinesResource {

	AirlinesServices airlineSvc=new AirlinesServices();


	@GET
	public List<AirLines> getAllAirLines(){
          return airlineSvc.getAllAirLines();
	}

	@GET
	@Path("/{name}")
	public AirLines getAirLines(@PathParam("name") String name){
		AirLines airLines = airlineSvc.airLinesMap.get(name.toLowerCase());
		if(airLines==null){
			throw new DatanotFoundException("There is no airlines with name "+name);
		}

		return airLines;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public AirLines addAnAirLine(AirLines newAirLine){
		airlineSvc.airLinesMap.put(newAirLine.getName(), newAirLine);
		return newAirLine;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAnAirLine(AirLines newAirLine){
		AirLines airLines = airlineSvc.airLinesMap.get(newAirLine.getName());

		if(airLines==null){
			 ErrorMessage errorMsg =new ErrorMessage("Server Error,Invalid Airlines ", Status.NO_CONTENT.ordinal(), "check the link for api guidlines");
			 Response errorResponse=Response.status(Status.NOT_FOUND).entity(errorMsg).build();
			throw new WebApplicationException(errorResponse);
		}

        // just replace the existing ailrines
		airlineSvc.airLinesMap.put(newAirLine.getName(), newAirLine);

		Response putResp=Response.status(Status.ACCEPTED).entity(newAirLine).build();
		return putResp;
	}

	/**
	 * delegate api call for flights to  sub resource FlightResource
	 * @return
	 */
	@Path("/{airLines}/flights")
	public FlightResource getFlights(){
       return new FlightResource();

	}
}

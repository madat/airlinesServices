package com.ws.airlines.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * A response filter for all the service for this WebService APIs
 * Add a Header information, the API providers's url
 * @author user
 *
 */
@Provider
public class AirlinesResourceResponseFilter implements ContainerResponseFilter{

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		responseContext.getHeaders().add("provided by", "www.xyzAirlnesServices.com");

	}

}

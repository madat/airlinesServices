package com.ws.airlines.resource.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * an Exception mapper class maps an Exception to
 *  an Error resource (in our case its ErrorMessage).
 *
 *
 * @author user
 *
 */

//@provider annotation registers this mapper class with context

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DatanotFoundException>{

	@Override
	public Response toResponse(DatanotFoundException exception) {
        ErrorMessage errorMsg=new ErrorMessage(exception.getMessage(), Status.NO_CONTENT.ordinal(), "check the link for api guidelines");

        return Response.status(Status.NOT_FOUND)
				.entity(errorMsg)
				.build();
	}

}

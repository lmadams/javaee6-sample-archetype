package org.agoncal.sample.cdi.inject.simple.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<Throwable> {

  @Override
  public Response toResponse(Throwable throwable) {
    throwable.printStackTrace();
    return null;
  }
}

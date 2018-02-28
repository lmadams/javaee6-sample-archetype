package org.agoncal.sample.cdi.inject.simple;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.agoncal.sample.cdi.inject.simple.exception.ApplicationExceptionMapper;

@ApplicationPath("/rs")
public class ApplicationConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> classes = new HashSet<Class<?>>();
    classes.add(ItemRestService.class);
    return classes;
  }

  @Override
  public Set<Object> getSingletons() {
    Set<Object> singletons = new HashSet<>();
    singletons.add(new ApplicationExceptionMapper());
    return singletons;
  }

}

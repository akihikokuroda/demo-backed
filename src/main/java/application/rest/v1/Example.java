package application.rest.v1;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Metered;

@Path("v1/example")
@ApplicationScoped
@Metered(name="Example", tags="app=demo-backend")
public class Example {

    @Inject
    @ConfigProperty(name="property") 
    Provider<String> propertyProvider;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response example() {
        return Response.ok("Property " + propertyProvider.get()).build();
    }


}

package application.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;

import application.domain.BusRoute;
import application.endpoints.RouteController;

public class RouteResource extends ResourceSupport {

	private final BusRoute route;
	
	
	public RouteResource(final BusRoute route) {
		this.route = route;
		
		
		
       final long id = route.getId();
		
		try {
			   add(linkTo(methodOn(RouteController.class).findById(id)).withSelfRel());
		      // add(linkTo(methodOn(AddressController.class).getById(id)).withRel("direccion"));
		      // add(linkTo(methodOn(UserContactInfoController.class).getById(id)).withRel("contacto"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public BusRoute getRoute() {
		return route;
	}
	
	
	
	
}

package application.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;

import application.domain.Station;
import application.endpoints.RouteController;
import application.endpoints.StationController;

public class StationResource extends ResourceSupport {
	
	private final Station station;
	
	public StationResource(Station station) {
		this.station = station;
		
		
		final long id = station.getId();
		
		try {
			   add(linkTo(methodOn(StationController.class).findById(id)).withSelfRel());
		       add(linkTo(methodOn(RouteController.class).findById(id)).withRel("ruta"));
		      // add(linkTo(methodOn(UserContactInfoController.class).getById(id)).withRel("contacto"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public Station getStation() {
		return station;
	}
	

}

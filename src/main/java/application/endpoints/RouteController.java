package application.endpoints;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.domain.BusRoute;
import application.exceptions.InvalidModelException;
import application.exceptions.ResourceNotFoundException;
import application.resources.RouteResource;
import application.service.IService;
import application.serviceImpl.BusRouteServiceImpl;

@RestController
@RequestMapping("/routes")
public class RouteController {
	
	@Autowired
	@Qualifier("busRouteServiceImpl")
	private IService<BusRoute> routeService;
	
	
	@PostMapping
	public ResponseEntity<BusRoute> addRoute(@RequestBody final BusRoute route) throws InvalidModelException {
		Long Id = routeService.save(route);
		route.setId(Id);
		return ResponseEntity.ok(route);
	}
	
	@GetMapping("/{Id}")
	public  ResponseEntity<RouteResource> findById(@PathVariable final long Id){
		return routeService.findById(Id)
				.map(r -> ResponseEntity.ok(new RouteResource(r)))
				.orElseThrow(() -> new ResourceNotFoundException("No Route found with id: " + Id));
	}
	
	
	@GetMapping
	public ResponseEntity<Resources<RouteResource>> findRoutes(){
      List<RouteResource> collection = routeService.findAll().stream().map(RouteResource::new).collect(Collectors.toList());
		
		Resources<RouteResource> resources = new Resources<>(collection); 
		
		return ResponseEntity.ok(resources);
	}
	
	
	@GetMapping("/station/{Id}")
	public ResponseEntity<RouteResource> findByStation(@PathVariable final long Id){
		return ((BusRouteServiceImpl)routeService).findByStation(Id);
	}
	
	
}

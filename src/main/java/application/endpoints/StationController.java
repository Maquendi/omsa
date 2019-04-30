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

import application.domain.Station;
import application.exceptions.InvalidModelException;
import application.resources.StationResource;
import application.service.IService;

@RestController
@RequestMapping("/stations")
public class StationController {
	
	@Autowired
	@Qualifier("stationServiceImpl")
	private IService<Station> stationService;
	
	

	
	@PostMapping
	public ResponseEntity<Station> add(@RequestBody final Station station ) throws InvalidModelException {
		
		Long newId = stationService.save(station);
		
		station.setId(newId);;
		
		return ResponseEntity.ok(station);
	 }
	
	
	@GetMapping("/{Id}")
	public ResponseEntity<StationResource> findById(@PathVariable final long Id){
		
		return stationService.findById(Id)
				.map(s -> ResponseEntity.ok(new StationResource(s)))
				.get();
	}
	
	

	@GetMapping
	public ResponseEntity<Resources<StationResource>> findRoutes(){
		
		List<StationResource> collection = stationService.findAll().stream().map(StationResource::new).collect(Collectors.toList());
		
		Resources<StationResource> resources = new Resources<>(collection); 
		
		return ResponseEntity.ok(resources);
	}
	
}

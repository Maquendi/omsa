package endpoints;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exceptions.InvalidModelException;
import omsa.domain.Station;
import service.IService;

@RestController
@RequestMapping("/stations")
public class StationController {
	
	@Autowired
	private IService<Station> stationService;
	
	
	@PostMapping
	public ResponseEntity<Station> add(@RequestBody final Station station ) throws InvalidModelException {
		return ResponseEntity.of(Optional.of(stationService.save(station)));
	 }

}

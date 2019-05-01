package application.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import application.domain.Station;
import application.repositoryImpl.StationRepositoryImpl;
import application.resources.StationResource;
import application.serviceAdapters.BaseServiceAdapter;

@Service
@Transactional
public class StationServiceImpl extends BaseServiceAdapter<Station> {
	
	
	public ResponseEntity<Resources<StationResource>> findAllByRoute(final long Id){
		List<StationResource> collection = ((StationRepositoryImpl) repository)
				                           .findAllByRouteId(Id)
				                           .stream()
				                           .map(StationResource::new).collect(Collectors.toList());
		Resources<StationResource> resources = new Resources<>(collection);
		
		return ResponseEntity.ok(resources);
	}
}

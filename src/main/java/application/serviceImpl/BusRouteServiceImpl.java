package application.serviceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import application.domain.BusRoute;
import application.repositoryImpl.BusRouteRepositoryImpl;
import application.resources.RouteResource;
import application.serviceAdapters.BaseServiceAdapter;

@Service
public class BusRouteServiceImpl extends BaseServiceAdapter<BusRoute>{

	
	public ResponseEntity<RouteResource> findByStation(final long id){
		return ResponseEntity.ok(new RouteResource(((BusRouteRepositoryImpl) repository).findByStationId(id)));
	}	
}

package application.repositoryImpl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import application.domain.BusRoute;
import application.repositoryAdapter.BaseRepositoryAdapter;

@Repository
public class BusRouteRepositoryImpl extends BaseRepositoryAdapter<BusRoute> {

	public BusRouteRepositoryImpl() {
		super(BusRoute.class);
	}
	
	
	public BusRoute findByStationId(final long id) {
		
		final String query = "SELECT r.ID, r.name FROM ROUTE r INNER JOIN STATION s on s.ROUTE = r.ID WHERE s.ID = ?1";
		
		try {
				Query q = sessionFactory.createEntityManager().createNativeQuery(query);
				      q.setParameter(1, id);
				      
				      return new BusRoute((Object[]) q.getSingleResult() );
		}catch(Exception ex) {
			throw ex;
		}
		
	}
	
	

}

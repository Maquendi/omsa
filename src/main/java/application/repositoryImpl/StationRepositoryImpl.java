package application.repositoryImpl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import application.domain.Station;
import application.repositoryAdapter.BaseRepositoryAdapter;


@Repository
public class StationRepositoryImpl extends BaseRepositoryAdapter<Station>{

	public StationRepositoryImpl() {
		super(Station.class);
	}
	
	
public List<Station> findAllByRouteId(final long id) {
		
		final String query = "SELECT S.ID, S.NAME, P.ID, P.LAT, P.LNG FROM STATION S INNER JOIN POINT P ON P.ID = S.POINT INNER JOIN ROUTE R ON R.ID = S.ROUTE WHERE R.ID = 1?";
		
		List<Station> stations = new ArrayList<>();
		
		try {
				Query q = sessionFactory.createEntityManager().createNativeQuery(query);
				      q.setParameter(1, id);

				    for(Object o : q.getResultList()) {
				    	 stations.add(new Station((Object[]) o));
				     }
				      
				 return stations;
		}catch(Exception ex) {
			throw ex;
		}
		
	}
		
}

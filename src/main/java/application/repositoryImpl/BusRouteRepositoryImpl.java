package application.repositoryImpl;

import org.springframework.stereotype.Repository;

import application.domain.BusRoute;
import application.repositoryAdapter.BaseRepositoryAdapter;

@Repository
public class BusRouteRepositoryImpl extends BaseRepositoryAdapter<BusRoute> {

	public BusRouteRepositoryImpl() {
		super(BusRoute.class);
	}

}

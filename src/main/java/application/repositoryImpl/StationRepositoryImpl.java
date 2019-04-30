package application.repositoryImpl;

import org.springframework.stereotype.Repository;

import application.domain.Station;
import application.repositoryAdapter.BaseRepositoryAdapter;


@Repository
public class StationRepositoryImpl extends BaseRepositoryAdapter<Station>{

	public StationRepositoryImpl() {
		super(Station.class);
	}
}

package repositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import omsa.domain.Station;
import repositoryAdapter.BaseRepositoryAdapter;


@Repository
public class StationRepositoryImpl extends BaseRepositoryAdapter<Station>{

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
	
	@Override
	public EntityManager entityManager() {
		return entityManager;
	}
	
}

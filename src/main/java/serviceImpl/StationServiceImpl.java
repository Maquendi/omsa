package serviceImpl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import omsa.domain.Station;
import serviceAdapters.BaseServiceAdapter;

@Service
@Transactional
public class StationServiceImpl extends BaseServiceAdapter<Station> {
}

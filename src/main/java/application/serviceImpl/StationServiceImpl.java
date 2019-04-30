package application.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import application.domain.Station;
import application.serviceAdapters.BaseServiceAdapter;

@Service
@Transactional
public class StationServiceImpl extends BaseServiceAdapter<Station> {
}

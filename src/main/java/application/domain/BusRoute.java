package application.domain;

import java.math.BigInteger;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Route")
public class BusRoute {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_seq")
	@SequenceGenerator(name = "route_seq", sequenceName = "route_seq", allocationSize = 1)
	private Long id;
	
	private String name;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
	private Set<Station> stations;


	public BusRoute() {}
	
	public BusRoute(Object[] columns) {
        this.id = (columns[0] != null)?((BigInteger)columns[0]).longValue():0;
        this.name = (String) columns[1];
    }

	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Station> getStations() {
		return stations;
	}


	public void setStations(Set<Station> stations) {
		this.stations = stations;
	}


	@Override
	public String toString() {
		return "BusRoute [id=" + id + ", name=" + name + ", stations=" + stations + "]";
	}
	

}

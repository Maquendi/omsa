package application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor
@ToString
@SuppressWarnings(value = { "unused" })
public class Point {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_seq")
	@SequenceGenerator(name = "point_seq", sequenceName = "point_seq", allocationSize = 1)
	private long id;
	
	private double lng;
	
	private double lat;
	
	
	@JsonIgnore
	@OneToOne (mappedBy="point")
	private Station station;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "Point [id=" + id + ", lng=" + lng + ", lat=" + lat + ", station=" + station + "]";
	}
	
	
	
}

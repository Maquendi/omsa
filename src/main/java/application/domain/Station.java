package application.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor
@ToString
@SuppressWarnings(value = { "unused" })
public class Station implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "station_seq")
	@SequenceGenerator(name = "station_seq", sequenceName = "station_seq", allocationSize = 1)
	private long id;
	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name="point")
	private Point point;
	
	@ManyToOne
	@JoinColumn(name="route")
	private BusRoute route;
	
	
	public Station(Object[] columns) {
		 this.id = (columns[0] != null)?((BigInteger)columns[0]).longValue():0;
	     this.name = (String) columns[1];
	     
	      long pId = (columns[2] != null)?((BigInteger)columns[2]).longValue(): 0;
	      double lat = (columns[3] != null)?((BigDecimal)columns[3]).doubleValue(): 0;
	      double lng = (columns[4] != null)?((BigDecimal)columns[4]).doubleValue(): 0;
	      this.point = new Point(pId,lat,lng); 
	}
	
	
	
	
	
	
	
	
	public Station(String name) {
		this.name = name;
	}

	public Station() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public BusRoute getRoute() {
		return route;
	}

	public void setRoute(BusRoute route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", name=" + name + ", point=" + point + ", route=" + route + "]";
	}
	
	
	
}

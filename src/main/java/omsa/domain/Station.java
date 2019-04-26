package omsa.domain;

import java.io.Serializable;

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
	
	
	public Station(String name) {
		this.name = name;
	}

	public Station() {
		
	}
}

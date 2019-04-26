package omsa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Point {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_seq")
	@SequenceGenerator(name = "point_seq", sequenceName = "point_seq", allocationSize = 1)
	private long id;
	
	private double lng;
	
	private double lat;
	
	@OneToOne (mappedBy="point")
	private Station station;
	
}

package omsa.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="Route")
@Getter @Setter @NoArgsConstructor
@SuppressWarnings(value = { "unused" })
@ToString(exclude = "stations")
public class BusRoute {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_seq")
	@SequenceGenerator(name = "route_seq", sequenceName = "route_seq", allocationSize = 1)
	private long id;
	
	private String name;
	
	
	@OneToMany(mappedBy = "route")
	private Set<Station> stations;
	
}

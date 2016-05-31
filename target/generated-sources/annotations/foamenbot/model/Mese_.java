package foamenbot.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Mese.class)
public abstract class Mese_ {

	public static volatile SetAttribute<Mese, Reservation> reservations;
	public static volatile SingularAttribute<Mese, String> name;
	public static volatile SingularAttribute<Mese, Long> id;
	public static volatile SingularAttribute<Mese, Integer> nrSeats;
	public static volatile SingularAttribute<Mese, String> status;

}


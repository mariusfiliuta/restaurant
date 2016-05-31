package foamenbot.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> role;
	public static volatile SingularAttribute<User, String> contactName;
	public static volatile SetAttribute<User, Order> orders;
	public static volatile SetAttribute<User, History> orderHistory;
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> userName;

}


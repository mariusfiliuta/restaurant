package foamenbot.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, String> date;
	public static volatile SingularAttribute<Order, Double> totalPrice;
	public static volatile SingularAttribute<Order, String> name;
	public static volatile SingularAttribute<Order, Long> id;
	public static volatile SetAttribute<Order, OrderProduct> orderProduct;
	public static volatile SingularAttribute<Order, User> user;
	public static volatile SingularAttribute<Order, String> status;

}


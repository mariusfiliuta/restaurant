package model;

import foamenbot.model.Order;
import foamenbot.model.OrderProduct;
import foamenbot.model.Product;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderProduct.class)
public abstract class OrderProduct_ {

	public static volatile SingularAttribute<OrderProduct, Product> product;
	public static volatile SingularAttribute<OrderProduct, Long> quantity;
	public static volatile SingularAttribute<OrderProduct, Long> id;
	public static volatile SingularAttribute<OrderProduct, Order> order;

}


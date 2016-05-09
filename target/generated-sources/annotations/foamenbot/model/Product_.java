package foamenbot.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, Double> price;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, Long> id;
	public static volatile SingularAttribute<Product, Boolean> in_stock;
	public static volatile SingularAttribute<Product, Category> category;
	public static volatile SingularAttribute<Product, String> productName;

}


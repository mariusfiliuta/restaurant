package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static volatile ListAttribute<Category, Product> productsList;
	public static volatile SingularAttribute<Category, Long> id;
	public static volatile SingularAttribute<Category, String> categoryName;

}


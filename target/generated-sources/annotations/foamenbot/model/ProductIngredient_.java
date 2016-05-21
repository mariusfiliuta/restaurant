package foamenbot.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductIngredient.class)
public abstract class ProductIngredient_ {

	public static volatile SingularAttribute<ProductIngredient, String> quantityType;
	public static volatile SingularAttribute<ProductIngredient, Product> product;
	public static volatile SingularAttribute<ProductIngredient, Long> quantity;
	public static volatile SingularAttribute<ProductIngredient, Ingredient> ingredient;
	public static volatile SingularAttribute<ProductIngredient, Long> id;

}


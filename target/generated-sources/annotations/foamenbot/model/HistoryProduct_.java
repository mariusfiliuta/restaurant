package foamenbot.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HistoryProduct.class)
public abstract class HistoryProduct_ {

	public static volatile SingularAttribute<HistoryProduct, Product> product;
	public static volatile SingularAttribute<HistoryProduct, Long> quantity;
	public static volatile SingularAttribute<HistoryProduct, Long> id;
	public static volatile SingularAttribute<HistoryProduct, History> history;

}


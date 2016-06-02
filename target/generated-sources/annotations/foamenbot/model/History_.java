package foamenbot.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(History.class)
public abstract class History_ {

	public static volatile SingularAttribute<History, String> endDate;
	public static volatile SingularAttribute<History, Double> totalPrice;
	public static volatile SetAttribute<History, HistoryProduct> historyProducts;
	public static volatile SingularAttribute<History, Long> id;
	public static volatile SingularAttribute<History, User> user;
	public static volatile SingularAttribute<History, String> startDate;
	public static volatile SingularAttribute<History, String> tableName;

}


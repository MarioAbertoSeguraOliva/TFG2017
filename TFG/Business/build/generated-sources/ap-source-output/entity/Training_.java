package entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-13T11:32:57")
@StaticMetamodel(Training.class)
public class Training_ { 

    public static volatile SingularAttribute<Training, String> recipient;
    public static volatile SingularAttribute<Training, String> training;
    public static volatile SingularAttribute<Training, BigDecimal> id;
    public static volatile SingularAttribute<Training, Date> creationDate;
    public static volatile SingularAttribute<Training, String> coach;

}
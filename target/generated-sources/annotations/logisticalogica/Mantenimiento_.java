package logisticalogica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logisticalogica.Vehiculo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-07T20:22:24", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Mantenimiento.class)
public class Mantenimiento_ { 

    public static volatile SingularAttribute<Mantenimiento, Integer> km;
    public static volatile SingularAttribute<Mantenimiento, Integer> mantenimientoID;
    public static volatile SingularAttribute<Mantenimiento, Vehiculo> vehiculo;

}
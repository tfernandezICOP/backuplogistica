package logisticalogica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logisticalogica.Paquete;
import logisticalogica.Viaje;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-07T20:22:24", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ViajePaquete.class)
public class ViajePaquete_ { 

    public static volatile SingularAttribute<ViajePaquete, Integer> viajePaqueteID;
    public static volatile SingularAttribute<ViajePaquete, Viaje> viaje;
    public static volatile SingularAttribute<ViajePaquete, Paquete> paquete;

}
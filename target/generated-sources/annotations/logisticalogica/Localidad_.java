package logisticalogica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logisticalogica.Provincia;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-05T17:22:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Localidad.class)
public class Localidad_ { 

    public static volatile SingularAttribute<Localidad, Provincia> provincia;
    public static volatile SingularAttribute<Localidad, Integer> localidadID;
    public static volatile SingularAttribute<Localidad, String> nombre;

}
package logisticalogica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logisticalogica.Mantenimiento;
import logisticalogica.Marca;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-01T12:01:01", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, Integer> capacidad_carga;
    public static volatile SingularAttribute<Vehiculo, Integer> nro_vehiculo;
    public static volatile SingularAttribute<Vehiculo, Marca> marca;
    public static volatile SingularAttribute<Vehiculo, String> estado;
    public static volatile SingularAttribute<Vehiculo, Integer> vehiculoID;
    public static volatile SingularAttribute<Vehiculo, Mantenimiento> mantenimiento;
    public static volatile SingularAttribute<Vehiculo, String> patente;

}
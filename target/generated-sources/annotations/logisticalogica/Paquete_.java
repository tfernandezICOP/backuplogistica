package logisticalogica;

import java.sql.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logisticalogica.Cliente;
import logisticalogica.Localidad;
import logisticalogica.Provincia;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-07T20:22:24", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Paquete.class)
public class Paquete_ { 

    public static volatile SingularAttribute<Paquete, String> descripcion;
    public static volatile SingularAttribute<Paquete, String> estado;
    public static volatile SingularAttribute<Paquete, Integer> codigo_paquete;
    public static volatile SingularAttribute<Paquete, String> domicilioEntrega;
    public static volatile SingularAttribute<Paquete, Localidad> localidadOrigen;
    public static volatile SingularAttribute<Paquete, Localidad> localidadDestino;
    public static volatile SingularAttribute<Paquete, Provincia> origen;
    public static volatile SingularAttribute<Paquete, Integer> paqueteID;
    public static volatile SingularAttribute<Paquete, Cliente> receptor;
    public static volatile SingularAttribute<Paquete, Date> fechaRecibido;
    public static volatile SingularAttribute<Paquete, Date> fechaEntrega;
    public static volatile SingularAttribute<Paquete, Provincia> destino;
    public static volatile SingularAttribute<Paquete, String> domicilioRetiro;
    public static volatile SingularAttribute<Paquete, Cliente> emisor;

}
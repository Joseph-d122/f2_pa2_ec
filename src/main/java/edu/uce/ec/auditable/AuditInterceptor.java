package edu.uce.ec.auditable;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Arrays;

@Auditable
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class AuditInterceptor {

    @Inject
    EntityManager em;

    @AroundInvoke
    public Object auditarOperacion(InvocationContext context) throws Exception {
        long inicio= System.currentTimeMillis();
        Object resultado = null;

        try {
            resultado = context.proceed(); 
        } finally {
            long total = System.currentTimeMillis() - inicio;
            AuditRecord audit = new AuditRecord();
            audit.setNombreMetodo(context.getMethod().getName());
            audit.setArgumentos(Arrays.toString(context.getParameters())); 
            audit.setFechaHoraEjecucion(LocalDateTime.now());
            audit.setTiempoEjecucionMs(total);
            em.persist(audit); 
        }

        return resultado;
    }
}

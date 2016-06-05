package skoczny.jedynak.poradnik.controllers.audit;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import skoczny.jedynak.poradnik.service.AuditService;

/**
 * Created by Damian on 2016-06-04.
 */
@Aspect
public class AuditAdvice {

    @Autowired
    private AuditService auditService;


    /**
     * Advice for auditing a user's visit to a page. The rule is that the Before annotation
     * <p>
     * applies to any method in any class in the skoczny.jedynak.poradnik.controllers package
     * <p>
     * where the class name ends in 'Controller' and the method is annotated by @Audit.
     *
     * @param auditAnnotation Audit annotation holds the name of the screen we're auditing.
     */
    @Before("@annotation(auditAnnotation)")
    public void myBeforeLogger(Audit auditAnnotation) {
        auditService.audit(auditAnnotation.message());
    }

}

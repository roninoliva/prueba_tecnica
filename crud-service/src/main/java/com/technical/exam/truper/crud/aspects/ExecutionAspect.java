package com.technical.exam.truper.crud.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ExecutionAspect {

    @Around("execution(* com.technical.exam.truper.crud.operation.ProductsOperation.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        try {
            return pjp.proceed();
        } finally {
            long elapsedNs = System.nanoTime() - start;
            long elapsedMs = elapsedNs / 1_000_000;
            log.info("Tiempo de ejecución: {}.{} -> {} ms",
                    pjp.getSignature().getDeclaringTypeName(),
                    pjp.getSignature().getName(),
                    elapsedMs);
        }
    }


}

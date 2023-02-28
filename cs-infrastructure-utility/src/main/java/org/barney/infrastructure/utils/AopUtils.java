package org.barney.infrastructure.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.barney.infrastructure.vo.BaseRequest;
import org.slf4j.MDC;
import org.springframework.util.ObjectUtils;

public class AopUtils {
    public static final void handleTraceIdForProceedingJointPoint(ProceedingJoinPoint proceedingJoinPoint) {
        String traceId = MDC.get(DistributedIDUtil.MDC_LOG_TRACE_ID);
        if(!StringUtils.hasLength(traceId)) {
            final Object[] args = proceedingJoinPoint.getArgs();
            if(!ObjectUtils.isEmpty(args) && args[0] instanceof BaseRequest) {
                BaseRequest req = (BaseRequest) args[0];
                traceId = StringUtils.hasLength(req.getTraceId()) ? req.getTraceId() : DistributedIDUtil.getUUID();
            }
            MDC.put(DistributedIDUtil.MDC_LOG_TRACE_ID, traceId);
        }
    }
}

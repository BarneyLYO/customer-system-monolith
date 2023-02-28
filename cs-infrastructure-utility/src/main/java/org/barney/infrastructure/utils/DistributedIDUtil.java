package org.barney.infrastructure.utils;

import cn.hutool.core.util.IdUtil;

import java.util.UUID;

public class DistributedIDUtil {
    public static final String MDC_TRACE_ID = "MDC_TRACE_ID";
    public static final String MDC_LOG_TRACE_ID = "MDC_LOG_TRACE_ID";

    public static String getFastSimpleUUID() {
        return IdUtil.fastSimpleUUID();
    }

    public static String getSnowFlake(long workerId, long datacenterId) {
        return IdUtil.createSnowflake(workerId, datacenterId).toString();
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().toUpperCase();
    }
}

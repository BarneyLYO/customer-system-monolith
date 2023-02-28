package org.barney.infrastructure.vo;

import lombok.Data;

@Data
public class BaseRequest {
    private String traceId;

    private Integer pageIndex = 1;

    private Integer pageSize = 10;
}

package org.barney.cs.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class OutsourcingSystemResponseVO {
    private Long id;
    private String systemName;
    private String description;
    private String systemUrl;
    private String appId;
    private String appKey;
    private String appSecret;
    private LocalDateTime createdAt;

}

package org.barney.cs.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AddOutsourcingSystemRequestVO {

    private String systemName;

    private String description;

    private String systemUrl;

    private String appId;

    private String appKey;

    private String appSecret;
}

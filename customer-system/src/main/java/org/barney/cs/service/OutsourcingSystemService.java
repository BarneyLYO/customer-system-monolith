package org.barney.cs.service;

import org.barney.cs.config.OutsourcingSystemClient;
import org.barney.cs.entity.tenant.OutsourcingSystem;
import org.barney.infrastructure.vo.PageObject;

import java.util.List;

public interface OutsourcingSystemService {

    List<OutsourcingSystem> findAllOutSourcingSystems();

    PageObject<OutsourcingSystem> findPagedOutsourcingSystems(Long pageSize, Long pageIndex);

    OutsourcingSystem findOutsourcingSystemById(Long systemId);

    Boolean addOutsourcingSystem (OutsourcingSystem outsourcingSystem);

    Boolean updateOutsourcingSystem(OutsourcingSystem outsourcingSystem);

    Boolean deleteOutsourcingSystemById (Long systemId);
}

package org.barney.cs.converter;

import org.barney.cs.entity.tenant.OutsourcingSystem;
import org.barney.cs.vo.AddCustomerStaffRequestVO;
import org.barney.cs.vo.OutsourcingSystemResponseVO;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface OutsourcingSystemConverter {

    OutsourcingSystemConverter INSTANCE = Mappers.getMapper(OutsourcingSystemConverter.class);

    OutsourcingSystem convertToEntity(AddCustomerStaffRequestVO vo);

    OutsourcingSystemResponseVO convertToVO(OutsourcingSystem entity);

    List<OutsourcingSystemResponseVO> convertToListVO(List<OutsourcingSystem> entities);

}

package org.barney.cs.converter;

import org.barney.cs.entity.staff.CustomerStaff;
import org.barney.cs.vo.AddCustomerStaffRequestVO;
import org.barney.cs.vo.CustomerStaffResponseVO;
import org.barney.cs.vo.UpdateCustomerStaffRequestVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerStaffConverter {
    CustomerStaffConverter INSTANCE = Mappers.getMapper(CustomerStaffConverter.class);

    CustomerStaff convertToEntity (AddCustomerStaffRequestVO vo);

    CustomerStaff convertToEntity(UpdateCustomerStaffRequestVO vo);

    CustomerStaffResponseVO convertToResponse (CustomerStaff entity);

    List<CustomerStaffResponseVO> convertToListResponse(List<CustomerStaff> entities);

}

package com.customer.beijing.converter;

import com.customer.beijing.entity.BeijingCustomerStaff;
import com.customer.beijing.vo.BeijingCustomerStaffCreateRequestVO;
import com.customer.beijing.vo.BeijingCustomerStaffResponseVO;
import com.customer.beijing.vo.BeijingCustomerStaffUpdateRequestVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BeijingCustomerStaffConverter {
    BeijingCustomerStaffConverter INSTANCE = Mappers.getMapper(BeijingCustomerStaffConverter.class);

    List<BeijingCustomerStaffResponseVO> convertToListResponse(List<BeijingCustomerStaff> list);

    BeijingCustomerStaffResponseVO convertToResponseVO(BeijingCustomerStaff entity);

    BeijingCustomerStaff convertToCustomerStaff(BeijingCustomerStaffUpdateRequestVO vo);

    BeijingCustomerStaff convertToCustomerStaff(BeijingCustomerStaffCreateRequestVO vo);

}

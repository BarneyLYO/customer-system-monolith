package com.customer.hangzhou.converter;

import com.customer.hangzhou.entity.HangzhouCustomerStaff;
import com.customer.hangzhou.vo.HangzhouCustomerStaffCreateRequestVO;
import com.customer.hangzhou.vo.HangzhouCustomerStaffResponseVO;
import com.customer.hangzhou.vo.HangzhouCustomerStaffUpdatRequestVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HangzhouCustomerStaffConverter {
    HangzhouCustomerStaffConverter INSTANCE = Mappers.getMapper(HangzhouCustomerStaffConverter.class);

    List<HangzhouCustomerStaffResponseVO> convertToResponseVOList(List<HangzhouCustomerStaff> list);

    HangzhouCustomerStaffResponseVO convertToResponseVO(HangzhouCustomerStaff entity);

    HangzhouCustomerStaff convertToEntity(HangzhouCustomerStaffCreateRequestVO vo);

    HangzhouCustomerStaff convertToEntity(HangzhouCustomerStaffUpdatRequestVO vo);

}

package com.customer.shanghai.converter;

import com.customer.shanghai.entity.ShanghaiCustomerStaff;
import com.customer.shanghai.vo.ShanghaiCustomerStaffCreateRequestVO;
import com.customer.shanghai.vo.ShanghaiCustomerStaffResponseVO;
import com.customer.shanghai.vo.ShanghaiCustomerStaffUpdateRequestVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ShanghaiCustomerStaffConverter {
    ShanghaiCustomerStaffConverter INSTANCE = Mappers.getMapper(ShanghaiCustomerStaffConverter.class);


    List<ShanghaiCustomerStaffResponseVO> convertToListResponseVO (List<ShanghaiCustomerStaff> list);

    ShanghaiCustomerStaffCreateRequestVO convertToResponseVO(ShanghaiCustomerStaff entity);

    ShanghaiCustomerStaff convertToEntity (ShanghaiCustomerStaffCreateRequestVO vo);

    ShanghaiCustomerStaff convertToEntity(ShanghaiCustomerStaffUpdateRequestVO vo);
}

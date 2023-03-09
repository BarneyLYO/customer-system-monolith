package org.barney.cs.service;

 import org.barney.cs.entity.staff.CustomerStaff;
 import org.barney.infrastructure.exception.BusinessException;
 import org.barney.infrastructure.vo.PageObject;

 import java.util.List;

public interface CustomerStaffService {

    PageObject<CustomerStaff> findCustomerStaffs (Long pageSize, Long pageIndex);

    List<CustomerStaff> findCustomerStaffs();

    PageObject<CustomerStaff> findCustomerStaffsByName(String staffName, Long pageSize, Long pageIndex);

    CustomerStaff findCustomerStaffById (Long staffId);

    Boolean createCustomerStaff (CustomerStaff customerStaff) throws BusinessException;

    Boolean updateCustomerStaff (CustomerStaff customerStaff);

    Boolean deleteCustomerStaffById (Long staffId);

    //PULL模式：获取OutsourcingSystem中的CustomerStaff
    void syncOutsourcingCustomerStaffsBySystemId(Long systemId);
}

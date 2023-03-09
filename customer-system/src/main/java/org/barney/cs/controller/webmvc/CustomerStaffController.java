package org.barney.cs.controller.webmvc;

import org.barney.cs.converter.CustomerStaffConverter;
import org.barney.cs.entity.staff.CustomerStaff;
import org.barney.cs.service.CustomerStaffService;
import org.barney.cs.vo.AddCustomerStaffRequestVO;
import org.barney.cs.vo.UpdateCustomerStaffRequestVO;
import org.barney.infrastructure.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerStaffs")
public class CustomerStaffController {

    @Autowired
    CustomerStaffService customerStaffService;

    @PostMapping("/")
    public Result<Long> addCustomerStaff(
            @RequestBody
            AddCustomerStaffRequestVO vo
    ){
        CustomerStaff customerStaff =
                CustomerStaffConverter
                        .INSTANCE
                        .convertToEntity(vo);

        customerStaffService
                .createCustomerStaff(customerStaff);
        return Result.success(customerStaff.getId());
    }

    @PutMapping("/")
    public Result<Boolean> updateCustomerStaff(
            @RequestBody
            UpdateCustomerStaffRequestVO vo
    ) {
        CustomerStaff customerStaff =
                CustomerStaffConverter
                        .INSTANCE
                        .convertToEntity(vo);

        Boolean isUpdated = customerStaffService.updateCustomerStaff(customerStaff);

        return Result.success(isUpdated);
    }




}

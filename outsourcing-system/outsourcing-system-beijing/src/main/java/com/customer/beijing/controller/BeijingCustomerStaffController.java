package com.customer.beijing.controller;

import com.customer.beijing.converter.BeijingCustomerStaffConverter;
import com.customer.beijing.entity.BeijingCustomerStaff;
import com.customer.beijing.service.BeijingCustomerStaffService;
import com.customer.beijing.vo.BeijingCustomerStaffCreateRequestVO;
import com.customer.beijing.vo.BeijingCustomerStaffResponseVO;
import com.customer.beijing.vo.BeijingCustomerStaffUpdateRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.barney.infrastructure.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customerStaffs/beijing/")
public class BeijingCustomerStaffController {

    @Autowired
    private BeijingCustomerStaffService customerStaffService;

    @PostMapping("/")
    public Result<Long> addCustomerStaff(
            @RequestBody
            @Validated
            BeijingCustomerStaffCreateRequestVO customerStaffCreateRequestVO
    ) {
        BeijingCustomerStaff beijingCustomerStaff =
                BeijingCustomerStaffConverter
                        .INSTANCE
                        .convertToCustomerStaff(customerStaffCreateRequestVO);

        return Result.success(customerStaffService.createCustomerStaff(beijingCustomerStaff));
    }

    @PutMapping("/")
    public Result<Boolean> updateCustomerStaff(
            @RequestBody
            @Validated
            BeijingCustomerStaffUpdateRequestVO customerStaffUpdateRequestVO
    ) {
        BeijingCustomerStaff customerStaff =
                BeijingCustomerStaffConverter
                        .INSTANCE
                        .convertToCustomerStaff(customerStaffUpdateRequestVO);

        return Result.success(customerStaffService.updateCustomerStaff(customerStaff));
    }

    @DeleteMapping("/")
    public Result<Boolean> deleteCustomerStaff(
            @RequestParam("id")
            Long id
    ) {
        return Result.success(customerStaffService.deleteCustomerStaffById(id));
    }

    @GetMapping("/")
    public Result<List<BeijingCustomerStaffResponseVO>> getAllCustomerStaffs() {
        List<BeijingCustomerStaff> staffs = customerStaffService.findAllCustomerStaffs();
        return Result.success(
                BeijingCustomerStaffConverter.INSTANCE.convertToListResponse(staffs)
        );
    }

    @GetMapping("/updated")
    public Result<List<BeijingCustomerStaffResponseVO>> getCustomerStaffsByUpdatedTime(
            @RequestParam("updatedTime")
            Long updatedTime
    ) {
        List<BeijingCustomerStaff> customerStaffs = customerStaffService.findCustomerStaffsByUpdatedTime(updatedTime);
        return Result.success(BeijingCustomerStaffConverter.INSTANCE.convertToListResponse(customerStaffs));
    }


}

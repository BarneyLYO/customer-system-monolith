package com.customer.shanghai.controller;

import com.customer.shanghai.converter.ShanghaiCustomerStaffConverter;
import com.customer.shanghai.entity.ShanghaiCustomerStaff;
import com.customer.shanghai.service.ShanghaiCustomerStaffService;
import com.customer.shanghai.vo.ShanghaiCustomerStaffCreateRequestVO;
import com.customer.shanghai.vo.ShanghaiCustomerStaffResponseVO;
import com.customer.shanghai.vo.ShanghaiCustomerStaffUpdateRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.barney.infrastructure.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customerStaffs/shanghai/")
public class ShanghaiCustomerStaffController {

    private final ShanghaiCustomerStaffService customerStaffService;

    @Autowired
    public ShanghaiCustomerStaffController(ShanghaiCustomerStaffService service) {
        this.customerStaffService = service;
    }


    @PostMapping("/")
    public Result<Long> addCustomerStaff(
            @RequestBody
            @Validated
            ShanghaiCustomerStaffCreateRequestVO customerStaffCreateRequestVO
    ) {
        ShanghaiCustomerStaff customerStaff =
                ShanghaiCustomerStaffConverter
                        .INSTANCE
                        .convertToEntity(customerStaffCreateRequestVO);

        Long rtn =
                customerStaffService
                        .createCustomerStaff(customerStaff);

        return Result.success(rtn);
    }

    @PutMapping("/")
    public Result<Boolean> updateCustomerStaff(
            @RequestBody
            @Validated
            ShanghaiCustomerStaffUpdateRequestVO vo
    ) {
        ShanghaiCustomerStaff staff =
                ShanghaiCustomerStaffConverter
                        .INSTANCE
                        .convertToEntity(vo);

        Boolean updated =
                customerStaffService
                        .updateCustomerStaff(staff);

        return Result.success(updated);
    }

    @DeleteMapping("/")
    public Result<Boolean> deleteCustomerStaff(
            @RequestParam("id")
            Long id
    ) {
        final Boolean deleted =
                customerStaffService
                        .deleteCustomerStaffById(id);

        return Result.success(deleted);
    }

    @GetMapping("/")
    public Result<List<ShanghaiCustomerStaffResponseVO>> getAllCustomerStaffs() {
        List<ShanghaiCustomerStaff> customerStaffs =
                customerStaffService
                        .findAllCustomerStaffs();

        List<ShanghaiCustomerStaffResponseVO> vos =
                ShanghaiCustomerStaffConverter
                        .INSTANCE
                        .convertToListResponseVO(customerStaffs);

        return Result.success(vos);
    }

    @GetMapping("/")
    public Result<List<ShanghaiCustomerStaffResponseVO>> getCustomerStaffsByUpdatedTime(
            @RequestParam("updatedTime")
            Long updatedTime
    ) {
        List<ShanghaiCustomerStaff> staffs =
                customerStaffService
                        .findCustomerStaffsByUpdatedTime(updatedTime);

        List<ShanghaiCustomerStaffResponseVO> vos =
                ShanghaiCustomerStaffConverter
                        .INSTANCE
                        .convertToListResponseVO(staffs);

        return Result.success(vos);
    }

}

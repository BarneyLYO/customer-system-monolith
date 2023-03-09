package com.customer.hangzhou.controller;

import com.customer.hangzhou.converter.HangzhouCustomerStaffConverter;
import com.customer.hangzhou.entity.HangzhouCustomerStaff;
import com.customer.hangzhou.service.HangzhouCustomerStaffService;
import com.customer.hangzhou.vo.HangzhouCustomerStaffCreateRequestVO;
import com.customer.hangzhou.vo.HangzhouCustomerStaffResponseVO;
import com.customer.hangzhou.vo.HangzhouCustomerStaffUpdatRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.barney.infrastructure.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customerStaffs/hangzhou/")
public class HangzhouCustomerStaffController {

    @Autowired
    private HangzhouCustomerStaffService customerStaffService;

    @PostMapping("/")
    public Result<HangzhouCustomerStaffResponseVO> addCustomerStaff(
            @RequestBody
            @Validated
            HangzhouCustomerStaffCreateRequestVO customerStaffCreateRequestVO
    ) {
        HangzhouCustomerStaff customerStaff =
                HangzhouCustomerStaffConverter
                        .INSTANCE
                        .convertToEntity(customerStaffCreateRequestVO);
        customerStaff = customerStaffService.createCustomerStaff(customerStaff);

        HangzhouCustomerStaffResponseVO vo =
                HangzhouCustomerStaffConverter
                        .INSTANCE
                        .convertToResponseVO(customerStaff);
        return Result.success(vo);
    }

    @PutMapping("/")
    public Result<HangzhouCustomerStaffResponseVO> updateCustomerStaff(
            @RequestBody
            @Validated
            HangzhouCustomerStaffUpdatRequestVO customerStaffUpdatRequestVO
    ) {
        HangzhouCustomerStaff staff =
                HangzhouCustomerStaffConverter
                        .INSTANCE
                        .convertToEntity(customerStaffUpdatRequestVO);

        staff = customerStaffService.updateCustomerStaff(staff);

        HangzhouCustomerStaffResponseVO vo =
                HangzhouCustomerStaffConverter
                        .INSTANCE
                        .convertToResponseVO(staff);

        return Result.success(vo);
    }

    @DeleteMapping("/")
    public Result<HangzhouCustomerStaffResponseVO> deleteCustomerStaff(
            @RequestParam("id")
            Long id
    ) {
        final HangzhouCustomerStaff staff = customerStaffService.deleteCustomerStaffById(id);
        final HangzhouCustomerStaffResponseVO vo =
                HangzhouCustomerStaffConverter
                        .INSTANCE
                        .convertToResponseVO(staff);

        return Result.success(vo);
    }

    @GetMapping("/")
    public Result<List<HangzhouCustomerStaffResponseVO>> getAllCustomerStaffs() {
        List<HangzhouCustomerStaff> staffs = customerStaffService.findAllCustomerStaffs();
        List<HangzhouCustomerStaffResponseVO> vos =
                HangzhouCustomerStaffConverter
                        .INSTANCE
                        .convertToResponseVOList(staffs);
        return Result.success(vos);
    }

    @GetMapping("/updated")
    public Result<List<HangzhouCustomerStaffResponseVO>> getCustomerStaffsByUpdatedTime(
            @RequestParam("updatedTime")
            Long updatedTime
    ) {
        Date updatedTimeForQuery = new Date(updatedTime);
        List<HangzhouCustomerStaff> customerStaffs =
                customerStaffService.findCustomerStaffsByUpdatedTime(updatedTimeForQuery);
        List<HangzhouCustomerStaffResponseVO> vos =
                HangzhouCustomerStaffConverter.INSTANCE.convertToResponseVOList(customerStaffs);
        return Result.success(vos);
    }
}

package org.barney.cs.controller.webmvc;

import org.barney.cs.converter.OutsourcingSystemConverter;
import org.barney.cs.entity.tenant.OutsourcingSystem;
import org.barney.cs.service.OutsourcingSystemService;
import org.barney.cs.vo.AddCustomerStaffRequestVO;
import org.barney.cs.vo.OutsourcingSystemResponseVO;
import org.barney.infrastructure.vo.PageObject;
import org.barney.infrastructure.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outsourcingSystems")
public class OutsourcingSystemController {

    @Autowired
    OutsourcingSystemService outsourcingSystemService;

    @PostMapping("/")
    public Result<Long> addOutsourcingSystem(
            @RequestBody
            AddCustomerStaffRequestVO vo
    ) {
        OutsourcingSystem outsourcingSystem = OutsourcingSystemConverter.INSTANCE.convertToEntity(vo);
        outsourcingSystemService.addOutsourcingSystem(outsourcingSystem);
        return Result.success(outsourcingSystem.getId());
    }

    @GetMapping("/{systemId}")
    public Result<OutsourcingSystemResponseVO> findOutsourcingSystemById(
            @PathVariable("systemId")
            Long systemId
    ) {
        OutsourcingSystem outsourcingSystem = outsourcingSystemService.findOutsourcingSystemById(systemId);
        OutsourcingSystemResponseVO vo = OutsourcingSystemConverter.INSTANCE.convertToVO(outsourcingSystem);
        return Result.success(vo);
    }

    @GetMapping("/page/{pageSize}/{pageIndex}")
    public Result<PageObject<OutsourcingSystemResponseVO>> findOutsourcingSystems(
            @PathVariable("pageSize")
            Long pageSize,
            @PathVariable("pageIndex")
            Long pageIndex
    ) {
        PageObject<OutsourcingSystem> pagedOutsourcingSystem
                = outsourcingSystemService.findPagedOutsourcingSystems(pageSize, pageIndex);

        List<OutsourcingSystemResponseVO> outsourcingSystemResponseVOList
                = OutsourcingSystemConverter.INSTANCE.convertToListVO(pagedOutsourcingSystem.getList());

        PageObject<OutsourcingSystemResponseVO> result =
                new PageObject<OutsourcingSystemResponseVO>()
                        .setList(outsourcingSystemResponseVOList)
                        .setTotal(pagedOutsourcingSystem.getTotal())
                        .setPageIndex(pagedOutsourcingSystem.getPageIndex())
                        .setPageSize(pagedOutsourcingSystem.getPageSize());

        return Result.success(result);
    }


    @DeleteMapping("/{systemId}")
    public Result<Boolean> deleteOutsourcingSystemById(
            @PathVariable("systemId")
            Long systemId
    ) {
        return Result.success(
                outsourcingSystemService.deleteOutsourcingSystemById(systemId));
    }


}

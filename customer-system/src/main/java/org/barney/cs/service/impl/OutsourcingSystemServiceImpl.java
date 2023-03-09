package org.barney.cs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.barney.cs.entity.tenant.OutsourcingSystem;
import org.barney.cs.mapper.OutsourcingSystemMapper;
import org.barney.cs.service.OutsourcingSystemService;
import org.barney.infrastructure.vo.PageObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutsourcingSystemServiceImpl extends ServiceImpl<OutsourcingSystemMapper, OutsourcingSystem> implements OutsourcingSystemService {

    @Override
    public List<OutsourcingSystem> findAllOutSourcingSystems() {
        LambdaQueryWrapper<OutsourcingSystem> queryWrapper
                = new LambdaQueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public PageObject<OutsourcingSystem> findPagedOutsourcingSystems(Long pageSize, Long pageIndex) {
        IPage<OutsourcingSystem> pagedResult
                = baseMapper.findPagedOutsourcingSystems(pageSize,pageIndex);

        PageObject<OutsourcingSystem> pageObject = new PageObject<>();

        pageObject.buildPage(
                pagedResult.getRecords(),
                pagedResult.getTotal(),
                pagedResult.getCurrent(),
                pagedResult.getSize()
        );

        return pageObject;
    }

    @Override
    public OutsourcingSystem findOutsourcingSystemById(Long systemId) {
        return baseMapper.selectById(systemId);
    }

    @Override
    public Boolean addOutsourcingSystem(OutsourcingSystem outsourcingSystem) {
        return save(outsourcingSystem);
    }

    @Override
    public Boolean updateOutsourcingSystem(OutsourcingSystem outsourcingSystem) {
        return updateById(outsourcingSystem);
    }

    @Override
    public Boolean deleteOutsourcingSystemById(Long systemId) {
        return removeById(systemId);
    }
}

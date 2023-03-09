package org.barney.cs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.barney.cs.entity.tenant.OutsourcingSystem;

public interface OutsourcingSystemMapper extends BaseMapper<OutsourcingSystem> {
    default IPage<OutsourcingSystem> findPagedOutsourcingSystems(Long pageSize, Long pageIdx) {
        return selectPage(new Page<>(pageIdx, pageSize), null);
    }
}

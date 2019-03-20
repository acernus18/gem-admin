package org.maples.gem.admin.repository;

import org.apache.ibatis.annotations.Param;
import org.maples.gem.admin.model.GemSoldInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GemSoldInfoMapper extends Mapper<GemSoldInfo> {
    List<GemSoldInfo> listGemSoldInfoBySoldTo(@Param("clientName") String clientName);
}


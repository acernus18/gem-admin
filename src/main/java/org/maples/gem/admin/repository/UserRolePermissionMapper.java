package org.maples.gem.admin.repository;

import org.apache.ibatis.annotations.Param;
import org.maples.gem.admin.model.UserRolePermission;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserRolePermissionMapper extends Mapper<UserRolePermission> {
    List<Integer> selectRoleIdByUserId(@Param("userId") Integer userId);
}
package org.maples.gem.admin.repository;

import org.apache.ibatis.annotations.Param;
import org.maples.gem.admin.model.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    String selectCredentialByPrincipal(@Param("principal") String principal);

    Integer selectUserIdByPrincipal(@Param("principal") String principal);
}
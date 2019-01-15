package demo.mapper;

import demo.pojo.Role;

public interface RoleMapper {
    Role getRole(Long id);
    int deleteRole(Long id);
    int insertRole(Role role);
}

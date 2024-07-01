package dev.ksc.api.mapper;


import dev.ksc.api.base.BaseMapper;
import dev.ksc.api.pojo.PjUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends BaseMapper<PjUser> {
}

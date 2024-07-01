package dev.ksc.api.base;

import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.*;

public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T>, ExampleMapper<T> {
}

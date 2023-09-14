package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    /**
     * 批量插入口味数据
     * ⭐List集合参数在mybatis默认的resultMap中键是"list"
     * 推荐直接设置@Param
     */
    void insertBatch(@Param("flavors") List<DishFlavor> flavors);

    /**
     * 根据菜品id删除口味数据
     */
    @Delete("delete from dish_flavor where dish_id = #{dishId}")
    void deleteByDishId(Long dishId);
}

package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DishMapper {
    /**
     * 根据分类id查询菜品数量
     */
    @Select("select count(*) from dish where category_id = #{id}")
    Integer countByCategoryId(Long id);

    /**
     * 插入菜品
     */
    @AutoFill(OperationType.INSERT)
    void insert(Dish dish);

    /**
     * 菜品分页查询
     */
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);
}






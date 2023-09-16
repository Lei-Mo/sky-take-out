package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据据一个菜品id查询对应套餐id
     */
    @Select("select setmeal_id from setmeal_dish where dish_id = #{dish_id}")
    List<Long> getSetmealIdsByDishId(Long dishId);

    /**
     * 根据据多个菜品id查询对应套餐id
     */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /**
     * 添加套餐和菜品的对应信息
     */
    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 批量删除
     */
    void deleteBySetmealIds(List<Long> setmealIds);

    /**
     * 根据套餐id查询套餐和菜品关联信息
     */
    @Select("select * from setmeal_dish where setmeal_id = #{setmealId}")
    List<SetmealDish> selectBySetmealId(Long setmealId);


}

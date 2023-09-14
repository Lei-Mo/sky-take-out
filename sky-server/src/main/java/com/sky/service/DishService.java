package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {

    /**
     * 新增菜品和对应口味
     */
    void saveWithFlavor(DishDTO dishDTO);

    /**
     * 菜品分页查询
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 菜品批量删除
     */
    void deleteBatch(List<Long> ids);

    DishVO getByIdWithFlavor(Long id);

    /**
     * 修改菜品和口味信息
     */
    void updateWithFlavor(DishDTO dishDTO);

    /**
     * 菜品起售和停售
     */
    void startOrStop(Integer status, Long id);
    
    /**
     * 根据分类id查询菜品
     */
    List<DishVO> getByCategoryId(Long categoryId);
}

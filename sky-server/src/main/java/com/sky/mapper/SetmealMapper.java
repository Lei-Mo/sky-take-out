package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SetmealMapper {
    /**
     * 根据分类id查询套餐数量
     */
    @Select("select count(*) from setmeal where category_id = #{id}")
    Integer countByCategoryId(Long id);

    /**
     * 添加套餐
     */
    @AutoFill(OperationType.INSERT)
    void insert(Setmeal setmeal);

    /**
     * 分页查询
     */
    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 批量删除
     */
    void deleteByIds(List<Long> ids);

    /**
     * 根据id获取状态
     */
    @Select("select status from setmeal where id = #{id}")
    Integer getStatusById(Long id);

    /**
     * 根据id查询
     */
    @Select("select * from setmeal where id = #{id}")
    SetmealVO selectById(Long id);

    /**
     * 修改套餐信息
     */
    @AutoFill(OperationType.UPDATE)
    void update(Setmeal setmeal);

    /**
     * 动态条件查询套餐
     */
    List<Setmeal> list(Setmeal setmeal);

    /**
     * 根据套餐id查询菜品选项
     */
    @Select("select sd.name, sd.copies, d.image, d.description " +
            "from setmeal_dish sd left join dish d on sd.dish_id = d.id " +
            "where sd.setmeal_id = #{setmealId}")
    List<DishItemVO> getDishItemBySetmealId(Long setmealId);


    /**
     * 根据条件统计套餐数量
     */
    Integer countByMap(Map map);
}

package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "套餐相关接口")
@Slf4j
@RequestMapping("/admin/setmeal")
public class SetmealController {
    @Autowired
    SetmealService setmealService;

    /**
     * 添加套餐
     */
    @PostMapping()
    @CacheEvict(cacheNames = "setmealCache", key = "#setmealDTO.categoryId")
    public Result save(@RequestBody SetmealDTO setmealDTO) {
        setmealService.save(setmealDTO);
        return Result.success();
    }

    /**
     * 分页查询
     */
    @GetMapping("/page")
    public Result<PageResult> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO) {
        PageResult pageResult = setmealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 批量删除
     */
    @DeleteMapping()
    @CacheEvict(cacheNames = "setmealCache", allEntries = true)
    public Result delete(@RequestParam List<Long> ids) {
        setmealService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 根据id查询套餐以及相关慈菜品
     */
    @GetMapping("/{id}")
    public Result<SetmealVO> getSetmealById(@PathVariable("id") Long id) {
        SetmealVO setmealVO = setmealService.getSetmealById(id);
        return Result.success(setmealVO);
    }

    /**
     * 修改套餐
     */
    @PutMapping()
    @CacheEvict(cacheNames = "setmealCache", allEntries = true)
    // ⭐一定不要忘记请求体中的参数必须要用@RequestBody才能获取
    public Result update(@RequestBody SetmealDTO setmealDTO) {
        setmealService.update(setmealDTO);
        return Result.success();
    }

    /**
     * 修改套餐起售、停售状态
     */
    @PostMapping("/status/{status}")
    @CacheEvict(cacheNames = "setmealCache", allEntries = true)
    public Result updateStatus(@PathVariable("status") Integer status, @RequestParam("id") Long id) {
        setmealService.updateStatus(status, id);
        return Result.success();
    }
}







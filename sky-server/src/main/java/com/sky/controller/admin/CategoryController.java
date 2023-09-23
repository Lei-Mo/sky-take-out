package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "分类相关接口")
@RequestMapping("/admin/category")
@Slf4j
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * 新增分类
     */
    @PostMapping("")
    @ApiOperation("新增分类")
    public Result save(@RequestBody CategoryDTO categoryDTO) {
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * 分类分页查询
     */
    @ApiOperation("分类分页查询")
    @GetMapping("/page")
    public Result<PageResult> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 修改分类信息
     */
    @ApiOperation("修改分类信息")
    @PutMapping("")
    public Result update(@RequestBody CategoryDTO categoryDTO) {
        categoryService.update(categoryDTO);

        return Result.success();
    }

    /**
     * 启用禁用分类
     */
    @ApiOperation("启用禁用分类")
    @PostMapping("/status/{status}")
    public Result startOrStop(@RequestParam("id") Long id, @PathVariable("status") Integer status) {
        categoryService.startOrStop(id, status);
        return Result.success();
    }

    /**
     * 根据id删除分类
     */
    @ApiOperation("根据id删除分类")
    @DeleteMapping("")
    public Result deleteById(@RequestParam("id") Long id) {
        categoryService.deleteById(id);
        return Result.success();
    }

    /**
     * 根据类型查询分类
     */
    @ApiOperation("根据类型查询分类")
    @GetMapping("/list")
    public Result<List<Category>> queryByType(@RequestParam("type") Integer type) {
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }

}






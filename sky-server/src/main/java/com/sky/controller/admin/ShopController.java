package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")
public class ShopController {
    private static final String KEY = "SHOP_STATUS";

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 修改营业状态
     */
    @ApiOperation("修改营业状态")
    @PutMapping("/{status}")
    public Result setStatus(@PathVariable("status") Integer status) {
        redisTemplate.opsForValue().set(KEY, status);
        return Result.success();
    }

    /**
     * 查询营业状态
     */
    @ApiOperation("查询营业状态")
    @GetMapping("/status")
    public Result getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        return Result.success(status);
    }
}






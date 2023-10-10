package com.sky.controller.admin;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.mapper.OrderMapper;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("AdminOrderController")
@RequestMapping("/admin/order")
@Api(tags = "管理端订单相关接口")
public class OrderController {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderService orderService;

    /**
     * 订单搜索
     */
    @GetMapping("/conditionSearch")
    public Result<PageResult> conditionSearch(OrdersPageQueryDTO pageQueryDTO) {
        PageResult pageResult = orderService.conditionSearch(pageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 订单详情查询
     */
    @GetMapping("/details/{id}")
    public Result<OrderVO> details(@PathVariable("id") Long orderId) {
        OrderVO orderVO = orderService.details(orderId);
        return Result.success(orderVO);
    }
}

package com.sky.controller.user;

import com.sky.dto.OrdersCancelDTO;
import com.sky.dto.OrdersPaymentDTO;
import com.sky.dto.OrdersSubmitDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("userOrderController")
@RequestMapping("/user/order")
@Api(tags = "用户端订单相关接口")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 用户下单
     */
    @PostMapping("/submit")
    public Result<OrderSubmitVO> submit(@RequestBody OrdersSubmitDTO ordersSubmitDTO) {
        OrderSubmitVO orderSubmitVO = orderService.submitOrder(ordersSubmitDTO);
        return Result.success(orderSubmitVO);
    }

    /**
     * 订单支付
     */
    @PutMapping("/payment")
    @ApiOperation("订单支付")
    public Result<OrderPaymentVO> payment(@RequestBody OrdersPaymentDTO ordersPaymentDTO) throws Exception {
        OrderPaymentVO orderPaymentVO = orderService.payment(ordersPaymentDTO);
        return Result.success(orderPaymentVO);
    }

    /**
     * 查询历史订单
     */
    @GetMapping("/historyOrders")
    public Result<PageResult> historyOrders(Integer page, Integer pageSize, Integer status) {
        PageResult pageResult = orderService.pageQueryForUser(page, pageSize, status);
        return Result.success(pageResult);
    }

    /**
     * 查询订单详情
     */
    @GetMapping("/orderDetail/{id}")
    public Result<OrderVO> orderDetail(@PathVariable("id") Long orderId) {
        OrderVO orderVO = orderService.details(orderId);
        return Result.success(orderVO);
    }

    /**
     * 取消订单
     */
    @PutMapping("/cancel/{id}")
    public Result cancel(@PathVariable("id") Long orderId) {
        OrdersCancelDTO ordersCancelDTO = new OrdersCancelDTO();
        ordersCancelDTO.setId(orderId);
        orderService.cancel(ordersCancelDTO);
        return Result.success();
    }

    /**
     * 再来一单
     */
    @PostMapping("/repetition/{id}")
    public Result repetition(@PathVariable("id") Long orderId) {
        orderService.repetition(orderId);
        return Result.success();
    }

    /**
     * 客户催单
     */
    @GetMapping("/reminder/{id}")
    public Result reminder(@PathVariable("id") Long orderId) {
        orderService.reminder(orderId);
        return Result.success();
    }
}





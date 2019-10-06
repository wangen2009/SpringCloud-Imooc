package com.imooc.product.client;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 调用的接口
 * @Author: wenjun
 * @Date: 2019/9/22 15:18
 */
//@FeignClient(name = "product", fallback = ProductClient.ProductClientFallback.class)
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();//方法名可以不一样

    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> cartDTOList);

//    @Component
//    static class ProductClientFallback implements ProductClient {
//
//        @Override
//        public String productMsg() {
//            return null;
//        }
//
//        @Override
//        public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
//            return null;
//        }
//
//        @Override
//        public void decreaseStock(List<DecreaseStockInput> cartDTOList) {
//
//        }
//    }
}

package com.demo.test;

import com.demo.App;
import com.demo.OrderSender;
import com.demo.ProductSender;
import com.demo.UserSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lwx on 2019/6/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class QueueTest {

    @Autowired
    private UserSender userSender;

    @Autowired
    private ProductSender productSender;

    @Autowired
    private OrderSender orderSender;

    @Test
    public void test1() throws InterruptedException {
        this.userSender.send("userSender...........hello rabbitmq");
        this.productSender.send("productSender...........hello rabbitmq");
        this.orderSender.send("orderSender...........hello rabbitmq");
    }
}

package com.demo.test;

import com.demo.App;
import com.demo.Sender;
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
    private Sender sender;

    @Test
    public void test1(){
        this.sender.send("hello rabbitmq");
    }
}

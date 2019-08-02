package com.talenco.lotterysystem;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LotterysystemApplicationTests {

    @Test
    public void contextLoads() {
        String[] myList = {"lizhe","liao","songzhilin","linyicheng","wangzhe","wanghaocong","zhuyingying","zhaogeng","guoxinghui"};
        int size = myList.length;
        for (int i = 0; i < 5; i++) {
            double num = Math.random()*size;

        }
    }

}


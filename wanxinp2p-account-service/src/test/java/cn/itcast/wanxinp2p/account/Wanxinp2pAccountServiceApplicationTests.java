package cn.itcast.wanxinp2p.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Wanxinp2pAccountServiceApplicationTests {

    @Test
    public void contextLoads() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(5);
        integers.add(9);
        integers.add(2);
        integers.add(4);
        integers.add(9);
        integers.add(3);
        integers.add(7);
        integers.add(8);
        integers.add(2,1);
        System.out.println("integers"+integers);
        Iterator<Integer> iterator = integers.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if(integers.indexOf(next) != integers.lastIndexOf(next)){
                iterator.remove();
            }
        }
//        List<Integer> collect = integers.stream().distinct().collect(Collectors.toList());
        System.out.println("integers"+integers);//[2, 5, 9, 4, 3, 7, 8][5, 2, 4, 9, 3, 7, 8]
    }

}

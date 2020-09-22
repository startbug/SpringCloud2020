package com.ggs.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Starbug
 * @Date 2020/9/21 22:50
 */
@Component
public class MyLb implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
            //自旋锁,期待找到current值,并且将其修改为next值;
            //如果实际值不是期待值current,则获取实际值,继续+1,重新判断,直到找到期待的值
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("------------next: " + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> instances) {
        int index = getAndIncrement() % instances.size();
        return instances.get(index);
    }
}

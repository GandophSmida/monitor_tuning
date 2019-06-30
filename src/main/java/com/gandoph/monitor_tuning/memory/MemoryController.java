package com.gandoph.monitor_tuning.memory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class MemoryController {

    private List<User> userList = new ArrayList<>();
    private List<Class<?>> classList = new ArrayList<>();

    /**
     * 堆内存溢出：-Xms32M -Xmx32M
     * @return
     */
    @GetMapping("/heap")
    public String heap(){
        while (true){
            userList.add(new User(UUID.randomUUID().toString(),18));
        }
    }

    /**
     * 非堆内存溢出：-XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     * @return
     */
    @GetMapping("/nonheap")
    public String nonHeap(){
        while (true){
            classList.addAll(Metaspace.createClasses());
        }
    }
}

package com.gandoph.monitor_tuning.TomcatDebug;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ch5")
public class TomcatDebugController {

    @RequestMapping("/hello")
    public String hello() {
        String str = "";
        for(int i=0;i<10;i++) {
            str += i;
        }
        return str;
    }

}
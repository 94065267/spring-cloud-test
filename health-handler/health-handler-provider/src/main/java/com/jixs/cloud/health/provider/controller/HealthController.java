package com.jixs.cloud.health.provider.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {
    /**
     * 标识当前数据库是否可以访问
     */
    public static Boolean canVisitDb = false;

    @RequestMapping(value = "/db/{canVisitDb}", method = RequestMethod.GET)
    @ResponseBody
    public String setConnectState(@PathVariable("canVisitDb") Boolean canVisitDb) {
        HealthController.canVisitDb = canVisitDb;
        return "当前数据库是否正常: " + HealthController.canVisitDb;
    }

}

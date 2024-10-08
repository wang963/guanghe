package com.yh.windnacelle.utils;

import com.yh.windnacelle.domain.WindCompTemperature;
import com.yh.windnacelle.service.IWindCompTemperatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Orion Huo
 * @version 1.0.0
 * @since 2024-10-08 10:34:09
 **/

@Component("timedTask")
public class TimedTask {

    private static Logger logger = LoggerFactory.getLogger(TimedTask.class);

    @Autowired
    private IWindCompTemperatureService windCompTemperatureService;

    public synchronized void updateCompTemperature() {
        List<WindCompTemperature> windCompTemperatures = windCompTemperatureService
                .selectWindCompTemperatureList(new WindCompTemperature());
        for (WindCompTemperature windCompTemperature : windCompTemperatures) {
            windCompTemperature.setTemperature((long) (Math.random() * 50));
            windCompTemperature.setAlarm((windCompTemperature.getTemperature() <= 5
                    || windCompTemperature.getTemperature() >= 30) ? "温度超限" : "");
            windCompTemperature.setTime(new Date());
            windCompTemperature.setUpdatedTime(new Date());
        }

        windCompTemperatureService.updateWindCompTemperatureBatch(windCompTemperatures);
        logger.debug("【定时任务】 温度已更新…………");
    }
}

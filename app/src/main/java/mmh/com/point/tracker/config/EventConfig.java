package mmh.com.point.tracker.config;

/**
 * @author guoqj
 * @version 2.5.4
 * @描述:埋点配置beans
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/17 0017
 */

public class EventConfig {
    boolean eventSwitch;//埋点开关

    public boolean isEventSwitch() {
        return eventSwitch;
    }

    public void setEventSwitch(boolean eventSwitch) {
        this.eventSwitch = eventSwitch;
    }
}

package mmh.com.point.tracker.beans;

import java.util.List;

/*******************************************************************************
 *
 *
 *
 *******************************************************************************/
public class EventListBean {
    int type;//0：pv统计， 1：点击事件统计
    List<EventBean> event;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<EventBean> getEvent() {
        return event;
    }

    public void setEvent(List<EventBean> event) {
        this.event = event;
    }
}

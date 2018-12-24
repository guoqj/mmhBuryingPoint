package mmh.com.point.tracker;

import android.content.Context;
import android.text.TextUtils;

import java.util.List;

import mmh.com.point.tracker.beans.EventBean;
import mmh.com.point.tracker.eventupload.TrackerAssociatedEvent;
import mmh.com.point.tracker.storage.EventLocalStorage;

/**
 * @author guoqj
 * @version 2.5.4
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/12 0012
 */

public class TrackerData {

    private static TrackerData instance;
    /**
     * 需要收集的事件列表id
     */
    private List<EventBean> eventList = null;
    /**
     *
     */
    private List<EventBean> eventPageList = null;

    Context context;

    public static TrackerData getInstance() {
        if (instance == null) {
            synchronized (TrackerData.class) {
                if (instance == null) {
                    instance = new TrackerData();
                }
            }
        }
        return instance;
    }

    public void initConfig(Context context) {
        if (null != context) {
            this.context = context.getApplicationContext();
        }
    }

    /**
     * 添加点击事件
     *
     * @param eventId
     */
    public void addEvent(String eventId) {
        if (TextUtils.isEmpty(eventId))
            return;
        System.out.println(eventId);
        EventBean eventBean = isEventViewVisible(eventId);
        if (null != eventBean) {
            addEvent(eventBean);
        }
    }

    /**
     * 添加页面事件
     *
     * @param eventId
     */
    public void addEventPage(String eventId) {
        if (TextUtils.isEmpty(eventId))
            return;
        EventBean eventBean = isEventPageViewVisible(eventId);
        if (null != eventBean) {
            addPageEvent(eventBean);
        }
    }

    /**
     * 添加页面事件时长
     *
     * @param eventId
     */
    public void addEventPageTime(String eventId) {
        if (TextUtils.isEmpty(eventId))
            return;
        EventBean eventBean = isEventPageViewVisible(eventId);
        if (null != eventBean) {
            addPageEvent(eventBean);
        }
    }

    /**
     * * 事件类型  1.计算事， 0.多参事件
     *
     * @param eventInfo
     */
    private void addEvent(EventBean eventInfo) {
        //根据事件类型
        TrackerAssociatedEvent.setEventTrack(context, eventInfo);
        //用mmkv的事件进行保存
        EventLocalStorage.saveEventStorageByType(context, eventInfo);
    }

    /**
     * 页面事件保存
     *
     * @param eventInfo
     */
    private void addPageEvent(EventBean eventInfo) {
        TrackerAssociatedEvent.setEventPathTrack(context, eventInfo);
        //用mmkv的事件进行保存
        EventLocalStorage.savePageEventStorageByType(context, eventInfo);
    }

    public void setEventList(List<EventBean> eventList) {
        this.eventList = eventList;
    }

    public void setEventPageList(List<EventBean> eventPageList) {
        this.eventPageList = eventPageList;
    }

    private EventBean isEventViewVisible(String eventId) {
        if (!TextUtils.isEmpty(eventId) && eventList != null && eventList.size() > 0) {
            for (int i = 0; i < eventList.size(); i++) {
                if (TextUtils.equals(eventList.get(i).getEventId(), eventId)) {
                    return eventList.get(i);
                }
            }
        }
        return null;
    }

    private EventBean isEventPageViewVisible(String eventId) {
        if (!TextUtils.isEmpty(eventId) && eventPageList != null && eventPageList.size() > 0) {
            for (int i = 0; i < eventList.size(); i++) {
                if (TextUtils.equals(eventList.get(i).getEventId(), eventId)) {
                    return eventList.get(i);
                }
            }
        }
        return null;
    }
}

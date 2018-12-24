package mmh.com.point.tracker.beans;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;

/*******************************************************************************
 * Description: 事件描述
 *
 * Author: Freeman
 *
 * Date: 2018/11/28
 *
 * Copyright: all rights reserved by Freeman.
 *******************************************************************************/
public class EventBean extends BaseBean {

    /**
     * 事件类型
     */
    public final static int EVENT_TYPE_VIEW_SOURCE = 0;      // 页面来源
    public final static int EVENT_TYPE_CLICKED = 1;   // 点击事件
    public final static int EVENT_TYPE_VIEW_TIME = 2;   // 页面时长时间
    public final static int EVENT_TYPE_VIEW_COUNT = 3;      // 页面来源
    private final int MILL_OF_SECOND = 1000;

    /**
     * 事件id
     */
    private String eventId;
    /**
     * 事件名称
     */
    private String eventName;
    /**
     * 事件类型  1.计算事， 0.多参事件
     */
    private int type;
    /**
     * 扩展字段
     */
    private String extension;

    /**
     * 页面时长
     *
     * @param path
     * @param duration
     * @param duration
     */
    public EventBean(int type, String path, long duration) {
        this.type = type;
    }

    /**
     * 页面打开次数/点击事件
     *
     * @param path
     */
    public EventBean(int type, String path) {
        this.type = type;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getType() {
        return type;
    }

    /**
     * 为页面事件生成pathId
     *
     * @param context
     * @param fragment
     * @return
     */
    public static String generateViewPath(@NonNull Context context, Fragment fragment) {
        StringBuilder builder = new StringBuilder();
        builder.append(context.getClass().getName());
        if (fragment != null) {
            builder.append("$").append(fragment.getClass().getName());
        }
        return builder.toString();
    }

    /**
     * 为点击事件生成pathId
     *
     * @param view
     * @param fragment
     * @return
     */
    public static String generateClickedPath(@NonNull View view, Fragment fragment) {
        StringBuilder builder = new StringBuilder(generateViewPath(view.getContext(), fragment));
        builder.append("$").append(view.getClass().getName());
        if (view.getId() != View.NO_ID) {
            String resourceName = view.getResources().getResourceEntryName(view.getId());
            if (!TextUtils.isEmpty(resourceName)) {
                builder.append("$").append(resourceName);
            }
        }
        return builder.toString();
    }
}

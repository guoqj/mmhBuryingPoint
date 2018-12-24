package mmh.com.point.tracker.eventupload;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;

import mmh.com.point.tracker.beans.EventBean;

/**
 * @author guoqj
 * @version 2.5.4
 * @描述:无痕埋点和友盟关联类
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/17 0017
 */

public class TrackerAssociatedEvent {


    public static void setEventTrack(Context context, EventBean eventInfo) {
        //根据事件类型
        switch (eventInfo.getType()) {
            case 0:
                MobclickAgent.onEvent(context.getApplicationContext(), eventInfo.getEventName());
                break;
            case 1:

                break;
        }

    }

    public static void setEventPathTrack(Context context, EventBean eventInfo) {
        //根据事件类型
        switch (eventInfo.getType()) {
            case 0:
                //
                MobclickAgent.onEvent(context.getApplicationContext(), eventInfo.getEventName());
                break;
            case 1:

                break;
        }

    }

}

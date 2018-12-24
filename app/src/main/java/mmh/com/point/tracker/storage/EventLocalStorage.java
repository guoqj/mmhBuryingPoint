package mmh.com.point.tracker.storage;

import android.content.Context;

import com.tencent.mmkv.MMKV;

import mmh.com.point.tracker.beans.EventBean;

/**
 * @author guoqj
 * @version 2.5.4
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/17 0017
 */

public class EventLocalStorage {

    /**
     * 按照-类型-保存本地数据  点击事件
     */
    public static void saveEventStorageByType(Context context, EventBean eventBean) {
        //用mmkv的事件进行保存
        MMKV kv = MMKV.defaultMMKV();
//        String name = kv.getString(eventInfo.getEventId(), "");
        //根据key获取响应的json
        //转换成beans
        //添加数据
        //保存数据


    }

    /**
     * 按照-类型-保存本地数据   页面事件
     */
    public static void savePageEventStorageByType(Context context, EventBean eventBean) {
        //用mmkv的事件进行保存
        MMKV kv = MMKV.defaultMMKV();
//        String name = kv.getString(eventInfo.getEventId(), "");
        //根据key获取响应的json
        //转换成beans
        //添加数据
        //保存数据
    }
}

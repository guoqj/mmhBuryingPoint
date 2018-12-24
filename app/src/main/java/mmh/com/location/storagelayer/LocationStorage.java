package mmh.com.location.storagelayer;

import android.content.Context;

import mmh.com.location.config.ILocationConfig;
import mmh.com.point.SharedPreference;

/**
 * @version 4.2.1
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2017/10/13 0013
 */
public class LocationStorage implements ILocationConfig {

    /**
     * 保存地址
     *
     * @param context
     * @param key
     */
    public static synchronized void saveLocation(Context context, String locationStrs, String key) {
        SharedPreference.saveToSP(context, key, locationStrs);
    }

    /**
     * 获取地址
     *
     * @param context
     * @param key
     */
    public static synchronized void getSaveLocation(Context context, String key) {
        SharedPreference.getString(context, key);
    }

}

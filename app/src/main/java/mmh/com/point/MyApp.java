package mmh.com.point;

import android.app.Application;

import com.tencent.mmkv.MMKV;

import mmh.com.point.tracker.TrackerData;

/*******************************************************************************
 * Description: 
 *
 * Author: Freeman
 *
 * Date: 2018/11/27
 *
 * Copyright: all rights reserved by Freeman.
 *******************************************************************************/
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//		TrackerConfiguration configuration = new TrackerConfiguration();
//		TrackerData.getInstance().init(this, configuration);
        MMKV.initialize(this);
        TrackerData.getInstance().initConfig(this);
    }
}

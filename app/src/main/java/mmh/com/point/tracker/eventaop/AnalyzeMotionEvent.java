package mmh.com.point.tracker.eventaop;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

import mmh.com.point.tracker.TrackerData;
import mmh.com.point.tracker.utils.LogUtil;
import mmh.com.point.tracker.utils.TrackerUtils;

/**
 * @描述: 分析事件
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/10/10
 */
public class AnalyzeMotionEvent {

    private WeakReference<View> mViewRef;

    private String localClassName;

    public AnalyzeMotionEvent(WeakReference<View> mViewRef, String localClassName) {
        this.mViewRef = mViewRef;
        this.localClassName = localClassName;
    }

    public void analyzeMotionEvent() {
        if (mViewRef == null || mViewRef.get() == null) {
            LogUtil.e("window is null");
            return;
        }

        ViewGroup decorView = (ViewGroup) mViewRef.get();
        LogUtil.e("wo shi shen 开始解析一下");
        try {
            Pair<View, ViewValue> viewValuePair = ErgodicViewTarget.findTargetView(decorView, localClassName);
            if (null != viewValuePair && null != viewValuePair.first && null != viewValuePair.second) {
                LogUtil.e("wo shi shen view Id " + viewValuePair.first.getId());
                LogUtil.e("wo shi shen view getViewClassName " + viewValuePair.second.getViewClassName());
                LogUtil.e("wo shi shen view getViewPathName " + viewValuePair.second.getViewPathName());
                LogUtil.e("wo shi shen view getViewReallyId " + viewValuePair.second.getViewReallyId());
                LogUtil.e("wo shi shen view getViewModuleName " + viewValuePair.second.getViewModuleName());
                TrackerData.getInstance().addEvent(TrackerUtils.generateEventId(String.valueOf(viewValuePair.first.getId()), viewValuePair.second));
            }
        } catch (Exception e) {
            LogUtil.e("wo shi shen = " + e.getMessage());
        }
    }
}

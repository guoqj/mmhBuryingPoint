package mmh.com.point.tracker.eventaop;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import java.lang.ref.WeakReference;

/**
 * @描述:注册activity的事件回调
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/10/10
 */
public class IndentationManager implements Window.Callback {

    private Window.Callback callback;

    private WeakReference<View> mViewRef;

    private AnalyzeMotionEvent mAnalyzeMotionEvent;

    public IndentationManager(Window window, Window.Callback callback, String localClassName) {
        this.callback = callback;
        if (null != window) {
            mViewRef = new WeakReference<>(window.getDecorView());
            window.setCallback(this);
            mAnalyzeMotionEvent = new AnalyzeMotionEvent(mViewRef, localClassName);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (mViewRef == null || mViewRef.get() == null) {
//            LogUtil.e("window is null");
            return false;
        }

        int actionMasked = event.getActionMasked();

        if (actionMasked != MotionEvent.ACTION_UP && null != callback) {
            return callback.dispatchTouchEvent(event);
        }

        if (null != mAnalyzeMotionEvent) {
            mAnalyzeMotionEvent.analyzeMotionEvent();
        }
        System.out.println("------1-------");
        if (null != callback)
            return callback.dispatchTouchEvent(event);
        System.out.println("------2-------");
        return false;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (null != callback)
            return callback.dispatchKeyEvent(event);
        return false;
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        if (null != callback)
            return callback.dispatchKeyShortcutEvent(event);
        return false;
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        if (null != callback)
            return callback.dispatchTrackballEvent(event);
        return false;
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        if (null != callback)
            return callback.dispatchGenericMotionEvent(event);
        return false;
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        if (null != callback)
            return callback.dispatchPopulateAccessibilityEvent(event);
        return false;
    }

    @Nullable
    @Override
    public View onCreatePanelView(int featureId) {
        if (null != callback)
            return callback.onCreatePanelView(featureId);
        return null;
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (null != callback)
            return callback.onCreatePanelMenu(featureId, menu);
        return false;
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        if (null != callback)
            return callback.onPreparePanel(featureId, view, menu);
        return false;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (null != callback)
            return callback.onMenuOpened(featureId, menu);
        return false;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (null != callback)
            return callback.onMenuItemSelected(featureId, item);
        return false;
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams attrs) {
        if (null != callback)
            callback.onWindowAttributesChanged(attrs);
    }

    @Override
    public void onContentChanged() {
        if (null != callback)
            callback.onContentChanged();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (null != callback)
            callback.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onAttachedToWindow() {
        if (null != callback)
            callback.onAttachedToWindow();
    }

    @Override
    public void onDetachedFromWindow() {
        if (null != callback)
            callback.onDetachedFromWindow();
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        if (null != callback)
            callback.onPanelClosed(featureId, menu);
    }

    @Override
    public boolean onSearchRequested() {
        if (null != callback)
            return callback.onSearchRequested();
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onSearchRequested(SearchEvent searchEvent) {
        if (null != callback)
            return callback.onSearchRequested(searchEvent);
        return false;
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback mCallback) {
        if (null != callback)
            return callback.onWindowStartingActionMode(mCallback);
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback mCallback, int type) {
        if (null != callback)
            return callback.onWindowStartingActionMode(mCallback, type);
        return null;
    }

    @Override
    public void onActionModeStarted(ActionMode mode) {
        if (null != callback)
            callback.onActionModeStarted(mode);
    }

    @Override
    public void onActionModeFinished(ActionMode mode) {
        if (null != callback)
            callback.onActionModeFinished(mode);
    }
}

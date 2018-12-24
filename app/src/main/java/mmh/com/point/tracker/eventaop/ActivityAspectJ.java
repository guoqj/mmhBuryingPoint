package mmh.com.point.tracker.eventaop;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import java.util.Map;
import java.util.WeakHashMap;

import mmh.com.point.tracker.TrackerData;

/**
 * @author
 * @version 4.2.1
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/8/1
 */
@Aspect
public class ActivityAspectJ {
    private Map<Context, Long> resumeTimeMap = new WeakHashMap<>();
    private Map<Context, Long> durationMap = new WeakHashMap<>();

    /**
     * 拦截activity的生命周期进行注入代码
     *
     * @param joinPoint
     */
    @After("execution(* *..AppCompatActivity+.onCreate(..))")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        Log.e("wo shi shen", "beforeMethodExecutionaop 拦截代码");

    }

    @After("execution(* *..AppCompatActivity+.onPostCreate(..))")
    public void beforeonPostCreateMethodExecution(JoinPoint joinPoint) {
        try {
            Log.e("wo shi shen", "beforeonPostCreateMethodExecutionaop 拦截代码");
            Activity activity = ((Activity) joinPoint.getTarget());
            if (null != activity) {
                new IndentationManager(activity.getWindow(), activity, activity.getClass().getName());
                durationMap.put(activity, 0L);
                TrackerData.getInstance().addEventPage(activity.getClass().getName());
            }
        } catch (Exception e) {
        }
    }

    /***
     *onPostResume 方法
     * @param joinPoint
     */
    @After("execution(* *..AppCompatActivity+.onPostResume(..))")
    public void beforeResumedMethodExecution(JoinPoint joinPoint) {
        try {
            Activity activity = ((Activity) joinPoint.getTarget());
            if (null != activity)
                resumeTimeMap.put(activity, System.currentTimeMillis());
        } catch (Exception e) {
        }
    }

    /**
     * onPause的方法
     *
     * @param joinPoint
     */
    @After("execution(* *..FragmentActivity+.onPause(..))")
    public void beforePausedMethodExecution(JoinPoint joinPoint) {
        try {
            Activity activity = ((Activity) joinPoint.getTarget());
            if (null != activity) {
                durationMap.put(activity, durationMap.get(activity)
                        + (System.currentTimeMillis() - resumeTimeMap.get(activity)));
            }
        } catch (Exception e) {
        }
    }

    /**
     * 结束时候的方法
     *
     * @param joinPoint
     */
    @After("execution(* *..AppCompatActivity+.onDestroy(..))")
    public void beforeDestroyedMethodExecution(JoinPoint joinPoint) {
        try {
            Activity activity = ((Activity) joinPoint.getTarget());
            if (null != activity) {
                long duration = durationMap.get(activity);
                System.out.println(activity.getClass().getName() + "时长" + duration / 1000 + "秒");
                resumeTimeMap.remove(activity);
                durationMap.remove(activity);
                //统计时长
                TrackerData.getInstance().addEventPage(activity.getClass().getName());
            }
        } catch (Exception e) {
//            LogUtil.e("wo shi shen" + e.getMessage());
        }
    }
}

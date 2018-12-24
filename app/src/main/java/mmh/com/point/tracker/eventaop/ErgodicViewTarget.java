package mmh.com.point.tracker.eventaop;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.lang.reflect.Field;

import mmh.com.point.tracker.utils.LogUtil;

/**
 * @描述:发现view
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/10/24
 */
public class ErgodicViewTarget {

    /***
     * 获取 点击view 的相关数据
     * @param decorView
     * @param localClassName
     * @return
     */
    public static Pair<View, ViewValue> findTargetView(ViewGroup decorView, String localClassName) {
        try {
            Object touchTarget = getTouchTarget(decorView);

            View simpleView = null;

            StringBuilder viewPathName = new StringBuilder();
            while (touchTarget != null) {
                View foundView = getTouchTargetChildView(touchTarget);
                if (null == foundView) {
                    break;
                }

                String classPathName = foundView.getClass().getSimpleName();
                viewPathName.append(classPathName);
                try {
                    ViewGroup viewGroup = ((ViewGroup) foundView.getParent());
                    int count = viewGroup.indexOfChild(foundView);
                    int index = 0;
                    for (int i = 0; i < count; i++) {
                        try {
                            View view = viewGroup.getChildAt(i);
                            if (view.getClass() == foundView.getClass()) {
                                index = index + 1;
                            }
                        } catch (Exception e) {
                        }
                    }

                    viewPathName.append("[").append(index).append("]");

                } catch (Exception e) {
                }
                try {
                    String viewReallyId = foundView.getResources().getResourceEntryName(foundView.getId());
                    viewPathName.append("#").append(viewReallyId);
                } catch (Exception e) {
                }

                touchTarget = getTouchTarget(foundView);
                if (null == touchTarget) {
                    simpleView = foundView;
                    break;
                }
                viewPathName.append("/");
            }

            if (null == simpleView) return null;

            String viewClassName = simpleView.getClass().getName();
            String viewReallyId = "";
            try {
                viewReallyId = simpleView.getResources().getResourceEntryName(simpleView.getId());
            } catch (Exception e) {
            }
            ViewValue viewValue = new ViewValue();
            viewValue.setViewClassName(viewClassName);
            viewValue.setViewPathName(viewPathName.toString());
            viewValue.setViewReallyId(viewReallyId);
            viewValue.setViewModuleName(localClassName);
            if (simpleView instanceof Button) {
                System.out.println(((Button) simpleView).getText() + " dddddddddddddddd-================ ");
            }
            return new Pair<>(simpleView, viewValue);
        } catch (Exception e) {
            LogUtil.e("wo shi shen = " + e.getMessage());
        }
        return null;
    }

    /***
     * 根据 根级 View 逐层查找 touchTarget
     * @param view
     * @return
     */
    private static Object getTouchTarget(View view) {
        if (null == view) return null;
        try {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                Field field = ViewGroup.class.getDeclaredField("mFirstTouchTarget");
                field.setAccessible(true);
                Object touchTarget = field.get(viewGroup);
                return touchTarget;
            }
        } catch (Exception e) {
            LogUtil.e("wo shi shen = " + e.getMessage());
        }
        return null;
    }

    /***
     * 根据 根级 touchTarget 逐层向下查找没有消费的 touchTarget 即最终点击的 目标view
     * @param touchTarget
     * @return
     */
    private static View getTouchTargetChildView(Object touchTarget) {
        if (null == touchTarget) return null;
        try {
            Field fieldView = touchTarget.getClass().getDeclaredField("child");
            fieldView.setAccessible(true);
            Object view = fieldView.get(touchTarget);
            if (null != view && view instanceof View) {
                return (View) view;
            }
        } catch (Exception e) {
            LogUtil.e("wo shi shen = " + e.getMessage());
        }
        return null;
    }
}

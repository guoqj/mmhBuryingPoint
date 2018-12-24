package mmh.com.point.tracker.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import mmh.com.point.tracker.eventaop.ViewValue;

/**
 * @author guoqj
 * @version 2.5.4
 * @描述:无痕埋点的方法
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/17 0017
 */

public class TrackerUtils {
    /**
     *
     * @return
     */
    public static String generateEventId(String viewId, ViewValue value) {
        StringBuilder builder = new StringBuilder();
        builder.append(value.getViewModuleName()).append("#");
        builder.append(value.getViewPathName()).append("#");
        builder.append(viewId);
        System.out.println(builder.toString());
        return md5(builder.toString());
    }

    /**
     * 返回md5
     * @param string
     * @return
     */
    @NonNull
    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result.append(temp);
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}

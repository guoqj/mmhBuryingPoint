//package mmh.com.location.storagelayer;
//
//import android.content.Context;
//import android.text.TextUtils;
//
//import com.mmh.base_library.bean.address.areaInfo.AreaInfoJsonBeans;
//import com.mmh.base_library.domain.DeliveryAddr;
//import com.mmh.base_library.network.GsonTools;
//import com.mmh.base_library.utils.SharedPreference;
//
//import mmh.com.location.config.ILocationConfig;
//
///**
// * @author tianyuan
// * @version 4.2.1
// * @描述:
// * @Copyright Copyright (c) 2016
// * @Company 昆山妈妈好网络科技有限公司
// * @date 2017/10/13 0013
// */
//public class LocationUtils implements ILocationConfig {
//    /**
//     * 保存默认收货地址
//     *
//     * @param context
//     * @param beans
//     */
//    public static void setLocalLoactionBeans(Context context, DeliveryAddr beans) {
//        if (beans == null) {
//            SharedPreference.saveToSP(context, "locallocationbeans", "");
//            MamaHaoAddressApi.getInstance().setLocalDeliveryAddr(null);
//            return;
//        }
//        beans.setType(location_type_three);
//        SharedPreference.saveToSP(context, "locallocationbeans", beans.toString());
//        MamaHaoAddressApi.getInstance().setLocalDeliveryAddr(beans);
//    }
//
//    /**
//     * 获取默认收货地址
//     * F @param context
//     *
//     * @return
//     */
//    public static DeliveryAddr getLocalLoactionBeans(Context context) {
//        return GsonTools.getBean(SharedPreference.getString(context, "locallocationbeans"),
//                DeliveryAddr.class) == null ? null : GsonTools.getBean(SharedPreference.getString(context, "locallocationbeans"), DeliveryAddr.class);
//    }
//
//    /**
//     * 保存gps定位
//     *
//     * @param context
//     * @param beans
//     */
//    public static void setLoactionBeans(Context context, DeliveryAddr beans) {
//        if (beans == null) {
//            setLoactionBeansClear(context);
//            MamaHaoAddressApi.getInstance().setDeliveryAddrGps(null);
//            return;
//        }
//        beans.setType(location_type_two);
//        SharedPreference.saveToSP(context, "locationbeans", beans.toString());
//        MamaHaoAddressApi.getInstance().setDeliveryAddrGps(beans);
//    }
//
//    /**
//     * 获取定位地址
//     * <p>
//     * 获取定位地址顺序  1手动切换地址,2 gps地址 3默认收货地址 4杭州市
//     *
//     * @param context
//     * @return
//     */
//    public static DeliveryAddr getLoactionBeans(Context context) {
////        // 1获取手动选择的地址
////        if (null != MamaHaoAddressApi.getInstance().getActionDeliveryAddr() && !TextUtils.isEmpty(MamaHaoAddressApi.getInstance().getActionDeliveryAddr().getAreaId())) {
////            return MamaHaoAddressApi.getInstance().getActionDeliveryAddr();
////        }
////        // 2获取gps定位信息
////        if (null != getGpsLoactionBeans(context) && !TextUtils.isEmpty(getGpsLoactionBeans(context).getAreaId())) {
////            return getGpsLoactionBeans(context);
////        }
////        // 3获取用户默认收货地址
////        if (null != getLocalLoactionBeans(context) && !TextUtils.isEmpty(getLocalLoactionBeans(context).getAreaId())) {
////            return getLocalLoactionBeans(context);
////        }
////        // 4获取本地杭州收货地址
////        if (null != MamaHaoAddressApi.getInstance().getDefaultDelivery() && !TextUtils.isEmpty(MamaHaoAddressApi.getInstance().getDefaultDelivery().getAreaId())) {
////            return MamaHaoAddressApi.getInstance().getDefaultDelivery();
////        }
////        // 获取本地杭州收货地址
//
//        //用新的方式实现  内存获取
//        return getLoactionBeans();
//    }
//
//    public static DeliveryAddr getLoactionBeans() {
//        //用新的方式实现  内存获取
//        return MamaHaoAddressApi.getInstance().getLoactionBeans();
//    }
//
//    /**
//     * 获取gps定位
//     *
//     * @param context
//     * @return
//     */
//    public static DeliveryAddr getGpsLoactionBeans(Context context) {
//        return GsonTools.getBean(SharedPreference.getString(context, "locationbeans"),
//                DeliveryAddr.class) == null ? null : GsonTools.getBean(
//                SharedPreference.getString(context, "locationbeans"), DeliveryAddr.class);
//    }
//
//    /**
//     * 清空gps定位
//     *
//     * @param context
//     */
//    public static void setLoactionBeansClear(Context context) {
//        SharedPreference.saveToSP(context, "locationbeans", "");
//    }
//
//    public static boolean isFirstGetHomeData(Context context) {
//        boolean flag = false;
//        if (null == getLoactionBeans(context)) {
//            flag = true;
//        } else {
//            if (TextUtils.isEmpty(getLoactionBeans(context).getAreaId())) {
//                flag = true;
//            }
//        }
//        return flag;
//    }
//
//    /**
//     * 地区json--2018-03-02新增（包含areaId，lng，lat，gpsAreaId，gpsLng，gpsLat）
//     */
//    public static String getAreaInfoJson() {
//        DeliveryAddr deliveryAddr = MamaHaoAddressApi.getInstance().getLoactionBeans();
//        AreaInfoJsonBeans jsonBeans = new AreaInfoJsonBeans();
//        if (!TextUtils.isEmpty(deliveryAddr.getAreaId()))
//            jsonBeans.setAreaId(deliveryAddr.getAreaId());
//        if (!TextUtils.isEmpty(deliveryAddr.getLat()))
//            jsonBeans.setLat(deliveryAddr.getLat());
//        if (!TextUtils.isEmpty(deliveryAddr.getLng()))
//            jsonBeans.setLng(deliveryAddr.getLng());
//        DeliveryAddr deliveryAddrGps = MamaHaoAddressApi.getInstance().getDeliveryAddrGps();
//        if (null != deliveryAddrGps) {
//            if (!TextUtils.isEmpty(deliveryAddrGps.getAreaId()))
//                jsonBeans.setGpsAreaId(deliveryAddrGps.getAreaId());
//            if (!TextUtils.isEmpty(deliveryAddrGps.getLat()))
//                jsonBeans.setGpsLat(deliveryAddrGps.getLat());
//            if (!TextUtils.isEmpty(deliveryAddrGps.getLng()))
//                jsonBeans.setGpsLng(deliveryAddrGps.getLng());
//        }
//        return jsonBeans.toString();
//    }
//
//}

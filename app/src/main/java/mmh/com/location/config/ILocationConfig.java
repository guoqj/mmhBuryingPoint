package mmh.com.location.config;

/**
 * @author tianyuan
 * @version 4.2.1
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2017/10/13 0013
 */
public interface ILocationConfig {
    //1手动切换地址,2 gps地址 3默认收货地址 4杭州市
    int type_action = 1;
    int type_gps = 2;
    int type_mime = 3;
    int type_local = 4;
}

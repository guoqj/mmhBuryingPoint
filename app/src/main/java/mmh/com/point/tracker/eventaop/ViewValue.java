package mmh.com.point.tracker.eventaop;

/**
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/10/10
 */
public class ViewValue {

    private String viewClassName;

    private String viewReallyId;

    private String viewPathName;

    private String viewModuleName;

    public String getViewModuleName() {
        return viewModuleName;
    }

    public void setViewModuleName(String viewModuleName) {
        this.viewModuleName = viewModuleName;
    }

    public String getViewClassName() {
        return viewClassName;
    }

    public void setViewClassName(String viewClassName) {
        this.viewClassName = viewClassName;
    }

    public String getViewReallyId() {
        return viewReallyId;
    }

    public void setViewReallyId(String viewReallyId) {
        this.viewReallyId = viewReallyId;
    }

    public String getViewPathName() {
        return viewPathName;
    }

    public void setViewPathName(String viewPathName) {
        this.viewPathName = viewPathName;
    }
}

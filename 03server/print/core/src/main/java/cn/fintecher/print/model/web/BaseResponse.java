package cn.fintecher.print.model.web;

/**
 * Created by sun on 2017/4/25 0025.
 */
public class BaseResponse<T> {
    public enum ReturnValue {
        SUCCESS, FAILURE
    }
    private String returnValue;
    private String reason;
    T data;

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

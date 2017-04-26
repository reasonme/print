package cn.fintecher.print.model;

import java.io.Serializable;

/**
 * Created by sun on 2017/4/25 0025.
 */
public class Result implements Serializable {
    public enum ReturnValue {
        SUCCESS, FAILURE
    }

    private String returnValue;
    private String reason;
    private Object object;
    public Result(){

    }
    public Result(ReturnValue returnValue, String reason) {
        this.returnValue = returnValue.name();
        this.reason = reason;
    }
    public Result(ReturnValue returnValue, String reason,Object  object) {
        this.returnValue = returnValue.name();
        this.reason = reason;
        this.object=object;
    }

    public Boolean isSuccess(){
        return "SUCCESS".equals(getReturnValue());
    }

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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Result{" +
                "returnValue='" + returnValue + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}

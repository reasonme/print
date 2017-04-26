package cn.fintecher.print.model.web;

/**
 * Created by sun on 2017/4/25 0025.
 */
public class BaseRequest<T> {
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

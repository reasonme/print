package cn.fintecher.print.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * @Author: PeiShouWen
 * @Description: 线程工具抽象类，系统中的线程类从此派生
 * @Date 14:47 2017/3/7
 */
public abstract class ThredUtil implements Runnable,Callable<Object> {

    private final Logger logger = LoggerFactory.getLogger(ThredUtil.class);
    //public abstract Object call() throws Exception;

    @Override
    public void run(){
        //如果子类要使用请重写
    }
    /**
     * 睡眠时间,秒为单位
     * @param second
     */
    public void sleep(long second){
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(),e);
        }
    }
}

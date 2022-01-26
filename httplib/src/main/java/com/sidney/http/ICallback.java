package com.sidney.http;

import okhttp3.Call;

/**
 * 描 述：顶层的回调接口
 * 作 者：hxl  2022/1/18 16:19
 * 修改描述：
 * 修 改 人：xxx  2022/1/18 16:19
 * 修改版本：
 */
public interface ICallback<T> {

    /**
     * 请求成功
     *
     * @param cache 是否是通过缓存请求成功的
     */
    default void onSucceed(T result, boolean cache) {
        onSucceed(result);
    }

    /**
     * 请求成功
     */
    void onSucceed(T result);

    /**
     * 请求出错
     */
    void onFail(Exception e);


}

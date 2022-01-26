package com.sidney.http.processor;

import androidx.lifecycle.LifecycleOwner;

import com.hjq.http.config.IRequestApi;
import com.sidney.http.ICallback;

import java.util.Map;

/**
 * 描 述：网络请求代理
 * 作 者：hxl  2022/1/18 16:23
 * 修改描述：
 * 修 改 人：xxx  2022/1/18 16:23
 * 修改版本：
 */
public interface IHttpProcessor {

    <T> void post(LifecycleOwner lifecycleOwner, IRequestApi iRequestApi, ICallback<T> callback);

    void get(String url, Map<String, Object> params, ICallback callback);
}

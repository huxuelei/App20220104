package com.sidney.http;

import androidx.lifecycle.LifecycleOwner;

import com.hjq.http.config.IRequestApi;
import com.sidney.http.processor.IHttpProcessor;

import java.util.Map;

/**
 * 描 述：接口请求入口
 * 作 者：hxl  2022/1/18 16:25
 * 修改描述：
 * 修 改 人：xxx  2022/1/18 16:25
 * 修改版本：
 */
public class HttpHelper implements IHttpProcessor {

    private static IHttpProcessor mIHttpProcessor = null;

    public static void init(IHttpProcessor httpProcessor) {
        mIHttpProcessor = httpProcessor;
    }

    private static HttpHelper instance;

    public static HttpHelper obtain() {
        synchronized (HttpHelper.class) {
            if (instance == null) {
                instance = new HttpHelper();
            }
        }
        return instance;
    }

    private HttpHelper() {

    }


    @Override
    public void post(LifecycleOwner lifecycleOwner, IRequestApi iRequestApi, ICallback callback) {
        mIHttpProcessor.post(lifecycleOwner, iRequestApi, callback);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
        mIHttpProcessor.get(url, params, callback);
    }

}

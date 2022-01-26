package com.sidney.http.processor.easyhttp;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;

import com.hjq.http.EasyConfig;
import com.hjq.http.EasyHttp;
import com.hjq.http.config.IRequestApi;
import com.hjq.http.config.IRequestHandler;
import com.hjq.http.config.IRequestInterceptor;
import com.hjq.http.listener.OnHttpListener;
import com.sidney.http.BuildConfig;
import com.sidney.http.ICallback;
import com.sidney.http.processor.IAllHeader;
import com.sidney.http.processor.IAllReqParam;
import com.sidney.http.processor.IHttpProcessor;
import com.sidney.http.processor.easyhttp.httpserver.HttpServer;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 描 述：使用EasyHttp  第三方框架
 * 作 者：hxl  2022/1/18 16:28
 * 修改描述：
 * 修 改 人：xxx  2022/1/18 16:28
 * 修改版本：
 */
public class EasyHttpProcessor implements IHttpProcessor {

    /**
     * 初始化配置
     *
     * @param server          服务器请求链接配置
     * @param iRequestHandler 设置请求处理策略
     */
    public EasyHttpProcessor(Context context, HttpServer server,
                             IRequestHandler iRequestHandler) {
        new EasyHttpProcessor(context,0, 0, 0,
                server, iRequestHandler);
    }

    /**
     * 初始化配置
     *
     * @param connectTimeout  连接超时 单位TimeUnit.MILLISECONDS
     * @param server          服务器请求链接配置
     * @param iRequestHandler 设置请求处理策略
     */
    public EasyHttpProcessor(Context context,long connectTimeout, HttpServer server,
                             IRequestHandler iRequestHandler) {
        new EasyHttpProcessor(context,connectTimeout, 0, 0,
                server, iRequestHandler);
    }

    /**
     * 初始化配置
     *
     * @param connectTimeout  连接超时 单位TimeUnit.MILLISECONDS
     * @param writeTimeout    读取超时 单位TimeUnit.MILLISECONDS
     * @param readTimeout     写超时 单位TimeUnit.MILLISECONDS
     * @param server          服务器请求链接配置
     * @param iRequestHandler 设置请求处理策略
     */
    public EasyHttpProcessor(Context context,long connectTimeout, long writeTimeout,
                             long readTimeout, HttpServer server,
                             IRequestHandler iRequestHandler) {
        new EasyHttpProcessor(context,connectTimeout, writeTimeout, readTimeout,
                server, iRequestHandler, null);
    }

    /**
     * 初始化配置
     *
     * @param connectTimeout      连接超时 单位TimeUnit.MILLISECONDS
     * @param writeTimeout        读取超时 单位TimeUnit.MILLISECONDS
     * @param readTimeout         写超时 单位TimeUnit.MILLISECONDS
     * @param server              服务器请求链接配置
     * @param iRequestHandler     设置请求处理策略
     * @param iRequestInterceptor 设置请求参数拦截器
     */
    public EasyHttpProcessor(Context context,long connectTimeout, long writeTimeout,
                             long readTimeout, HttpServer server,
                             IRequestHandler iRequestHandler,
                             IRequestInterceptor iRequestInterceptor) {
        new EasyHttpProcessor(context,connectTimeout, writeTimeout, readTimeout,
                server, iRequestHandler, iRequestInterceptor,
                null, null);
    }

    /**
     * 初始化配置
     *
     * @param connectTimeout      连接超时 单位TimeUnit.MILLISECONDS
     * @param writeTimeout        读取超时 单位TimeUnit.MILLISECONDS
     * @param readTimeout         写超时 单位TimeUnit.MILLISECONDS
     * @param server              服务器请求配置
     * @param iRequestHandler     设置请求处理策略
     * @param iRequestInterceptor 设置请求参数拦截器
     * @param allReqParam         添加全局请求参数
     * @param iAllHeader          添加全局请求头
     */
    public EasyHttpProcessor(Context context, long connectTimeout,
                             long writeTimeout, long readTimeout,
                             HttpServer server, IRequestHandler iRequestHandler,
                             IRequestInterceptor iRequestInterceptor,
                             IAllReqParam allReqParam, IAllHeader iAllHeader) {
        try {
            if (null == context) {
                throw new NullPointerException("上下文为空");
            }
            long tempConnectTimeout;
            if (connectTimeout > 0) {
                tempConnectTimeout = connectTimeout;
            } else {
                tempConnectTimeout = 60000;
            }
            long tempWriteTimeout;
            if (writeTimeout > 0) {
                tempWriteTimeout = writeTimeout;
            } else {
                tempWriteTimeout = 60000;
            }
            long tempReadTimeout;
            if (readTimeout > 0) {
                tempReadTimeout = readTimeout;
            } else {
                tempReadTimeout = 60000;
            }
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(tempConnectTimeout, TimeUnit.MILLISECONDS)
                    .writeTimeout(tempWriteTimeout, TimeUnit.MILLISECONDS)
                    .readTimeout(tempReadTimeout, TimeUnit.MILLISECONDS)
                    .build();

            if (null == server) {
                throw new IllegalStateException("-----请设置服务器配置-----");
            }
            if (null == iRequestHandler) {
                throw new IllegalStateException("-----请设置请求处理策略-----");
            }
            EasyConfig easyConfig = EasyConfig.with(okHttpClient);
            // 是否打印日志
            easyConfig.setLogEnabled(BuildConfig.DEBUG)
                    // 设置服务器配置
                    .setServer(server.getIRequestServer())
                    // 设置请求处理策略
                    .setHandler(iRequestHandler)
                    // 设置请求重试次数
                    .setRetryCount(1)
                    // 设置请求重试时间
                    .setRetryTime(2000);
            // 设置请求参数拦截器
            if (null != iRequestInterceptor) {
                easyConfig.setInterceptor(iRequestInterceptor);
            }
            // 添加全局请求参数
            if (null != allReqParam) {
                easyConfig.addParam(allReqParam.getReqKey(), allReqParam.getReqValue());
            }
            // 添加全局请求头
            if (null != iAllHeader) {
                easyConfig.addHeader(iAllHeader.getReqKey(), iAllHeader.getReqValue());
            }
            easyConfig.into();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("-----初始化异常-----");
        }
    }

    @Override
    public <T> void post(LifecycleOwner lifecycleOwner, IRequestApi iRequestApi, ICallback<T> callback) {
        EasyHttp.post(lifecycleOwner)
                .api(iRequestApi)
                .request(new OnHttpListener<T>() {

                    @Override
                    public void onSucceed(T result) {
                        if (null != callback) {
                            callback.onSucceed(result);
                        } else {
                            throw new NullPointerException("ICallback is null");
                        }
                    }

                    @Override
                    public void onSucceed(T result, boolean cache) {
                        if (null != callback) {
                            callback.onSucceed(result, cache);
                        } else {
                            throw new NullPointerException("ICallback is null");
                        }
                    }

                    @Override
                    public void onFail(Exception e) {
                        if (null != callback) {
                            callback.onFail(e);
                        } else {
                            throw new NullPointerException("ICallback is null");
                        }
                    }
                });
    }


    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {

    }


}

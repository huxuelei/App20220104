package com.sidney.http.processor.easyhttp.httpserver;

import com.hjq.http.EasyConfig;
import com.hjq.http.config.IRequestServer;
import com.hjq.http.model.BodyType;
import com.hjq.http.model.CacheMode;

import okhttp3.OkHttpClient;

/**
 * 描 述：服务器配置
 * 作 者：hxl 2022/1/19 14:54
 * 修改描述： XXX
 * 修 改 人： XXX  2022/1/19 14:54
 * 修改版本： XXX
 */
public class HttpServer {

    private String mHostServer;//服务器地址

    @ValidEasyBodyType(EasyBodyType.FORM)
    private String mBodyType;//参数提交方式

    @ValidEasyCacheMode(EasyCacheMode.DEFAULT)
    private String mCacheMode;//默认的缓存方式

    private long mCacheTime;//获取缓存的有效时长（以毫秒为单位）

    /**
     * 服务器配置
     *
     * @param hostServer 服务器地址
     */
    public HttpServer(String hostServer) {
        new HttpServer(hostServer, "", "", 0);
    }

    /**
     * 服务器配置
     *
     * @param hostServer 服务器地址
     * @param bodyType   参数提交方式
     * @param cacheMode  默认的缓存方式
     * @param cacheTime  获取缓存的有效时长（以毫秒为单位）
     */
    public HttpServer(String hostServer, String bodyType,
                      String cacheMode, long cacheTime) {
        this.mHostServer = hostServer;
        this.mBodyType = bodyType;
        this.mCacheMode = cacheMode;
        this.mCacheTime = cacheTime;
    }

    /**
     * 服务器配置
     *
     * @return
     */
    public IRequestServer getIRequestServer() {

        IRequestServer iRequestServer = new IRequestServer() {
            @Override
            public String getHost() {
                return mHostServer;
            }

            @Override
            public BodyType getBodyType() {
                if (EasyBodyType.FORM.equals(mBodyType)) {
                    return BodyType.FORM;
                } else if (EasyBodyType.JSON.equals(mBodyType)) {
                    return BodyType.JSON;
                }
                return BodyType.FORM;
            }

            @Override
            public CacheMode getCacheMode() {
                if (EasyCacheMode.DEFAULT.equals(mCacheMode)) {
                    return CacheMode.DEFAULT;
                } else if (EasyCacheMode.NO_CACHE.equals(mCacheMode)) {
                    return CacheMode.NO_CACHE;
                } else if (EasyCacheMode.USE_CACHE_ONLY.equals(mCacheMode)) {
                    return CacheMode.USE_CACHE_ONLY;
                } else if (EasyCacheMode.USE_CACHE_FIRST.equals(mCacheMode)) {
                    return CacheMode.USE_CACHE_FIRST;
                } else if (EasyCacheMode.USE_CACHE_AFTER_FAILURE.equals(mCacheMode)) {
                    return CacheMode.USE_CACHE_AFTER_FAILURE;
                }
                return CacheMode.DEFAULT;
            }

            @Override
            public long getCacheTime() {
                if (mCacheTime > 0) {
                    return mCacheTime;
                }
                return Long.MAX_VALUE;
            }

            @Override
            public OkHttpClient getOkHttpClient() {
                return EasyConfig.getInstance().getClient();
            }
        };
        return iRequestServer;
    }


}

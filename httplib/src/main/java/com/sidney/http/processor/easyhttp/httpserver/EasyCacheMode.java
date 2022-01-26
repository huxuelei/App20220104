package com.sidney.http.processor.easyhttp.httpserver;

/**
 * 描 述：数据缓存模式
 * 作 者：hxl 2022/1/19 17:00
 * 修改描述： XXX
 * 修 改 人： XXX  2022/1/19 17:00
 * 修改版本： XXX
 */
public enum EasyCacheMode {

    /**
     * 默认（按照 Http 协议来缓存）
     */
    DEFAULT,

    /**
     * 不使用缓存（禁用 Http 协议缓存）
     */
    NO_CACHE,

    /**
     * 只使用缓存
     * <p>
     * 已有缓存的情况下：读取缓存 -> 回调成功
     * 没有缓存的情况下：请求网络 -> 写入缓存 -> 回调成功
     */
    USE_CACHE_ONLY,

    /**
     * 优先使用缓存
     * <p>
     * 已有缓存的情况下：先读缓存 —> 回调成功 —> 请求网络 —> 刷新缓存
     * 没有缓存的情况下：请求网络 -> 写入缓存 -> 回调成功
     */
    USE_CACHE_FIRST,

    /**
     * 只在网络请求失败才去读缓存
     */
    USE_CACHE_AFTER_FAILURE
}

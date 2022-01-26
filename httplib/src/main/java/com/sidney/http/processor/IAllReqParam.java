package com.sidney.http.processor;

/**
 * 描 述：添加全局请求参数 比如token
 * 作 者：hxl 2022/1/19 10:52
 * 修改描述： XXX
 * 修 改 人： XXX  2022/1/19 10:52
 * 修改版本： XXX
 */
public interface IAllReqParam {

    /**
     * 请求的key  比如token
     *
     * @return
     */
    String getReqKey();

    /**
     * 请求的值  比如”123456“
     *
     * @return
     */
    String getReqValue();
}

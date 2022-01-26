package com.sidney.http.processor;

/**
 * 描 述：添加全局请求头
 * 作 者：hxl 2022/1/19 10:52
 * 修改描述： XXX
 * 修 改 人： XXX  2022/1/19 10:52
 * 修改版本： XXX
 */
public interface IAllHeader {

    /**
     * 请求的key
     *
     * @return
     */
    String getReqKey();

    /**
     * 请求的值
     *
     * @return
     */
    String getReqValue();
}

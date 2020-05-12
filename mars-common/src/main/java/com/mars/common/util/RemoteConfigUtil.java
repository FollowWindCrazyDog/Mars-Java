package com.mars.common.util;

import com.alibaba.fastjson.JSONObject;
import com.mars.common.constant.MarsConstant;

import java.util.HashMap;
import java.util.Map;

public class RemoteConfigUtil {

    /**
     * 从远程配置中心读取配置信息
     * @param object 本地配置
     * @return 远程配置
     * @throws Exception 异常
     */
    public static JSONObject remoteConfig(JSONObject object) throws  Exception {
        try{
            Map<String,Object> params = new HashMap<>();

            /* 读取并判断用户有无使用远程配置中心，如果没有 则直接返回本地配置文件信息 */
            JSONObject config =  object.getJSONObject("config");
            if(config == null){
                return object;
            }

            /* 解析远程配置 并获取数据 */
            String furl = config.getString("url");
            String url = MarsConstant.READ_REMOTE_CONFIG.replace("${0}",furl);

            params.put("name",config.getString("name"));
            params.put("myIp", MarsAddressUtil.getLocalIp());
            params.put("port", MarsAddressUtil.getPort());

            Object result = HttpUtil.post(url,params,30000);

            JSONObject jsonObject = JSONObject.parseObject(result.toString());

            if(jsonObject.get("result") != null
                    && jsonObject.getString("result").trim().equals("no")){
                throw new Exception("远程配置中心没有相应的配置文件,请及时创建");
            }

            return jsonObject;
        } catch (Exception e){
            throw new Exception("读取远程配置中心失败",e);
        }
    }
}

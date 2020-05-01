package com.zlk.eye.util;

import java.util.UUID;

/**
 * @ClassName： UUIDUtil
 * @Description： 生成id类
 * @Author： wy
 * @Date： 2020/5/1 11:11
 */
public class UUIDUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}

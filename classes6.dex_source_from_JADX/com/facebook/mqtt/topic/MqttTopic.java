package com.facebook.mqtt.topic;

import com.facebook.mqtt.model.thrift.TopicType;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: timed_out */
public class MqttTopic {
    static final Map<String, Integer> f3002a;

    static {
        Map hashMap = new HashMap();
        for (Entry entry : TopicType.b.entrySet()) {
            hashMap.put("/" + ((String) entry.getValue()), entry.getKey());
        }
        f3002a = hashMap;
    }

    public static Integer m4020a(String str) {
        return (Integer) f3002a.get(str);
    }
}

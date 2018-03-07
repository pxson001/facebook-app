package com.facebook.mqttlite;

import com.facebook.mqtt.model.thrift.TopicType;
import com.facebook.rti.common.thrift.MqttTopic;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: first_body_byte_flushed_ratio */
public class ThriftMqttTopic implements MqttTopic {
    static final Map<String, Integer> f23626a;
    private final boolean f23627b;

    static {
        Map hashMap = new HashMap();
        for (Entry entry : TopicType.f23490b.entrySet()) {
            hashMap.put("/" + ((String) entry.getValue()), entry.getKey());
        }
        f23626a = hashMap;
    }

    public ThriftMqttTopic(boolean z) {
        this.f23627b = z;
    }

    public final String m32029a(String str) {
        if (!this.f23627b) {
            return str;
        }
        Integer num = (Integer) f23626a.get(str);
        if (num != null) {
            return num.toString();
        }
        return null;
    }

    public final String m32031b(String str) {
        if (!this.f23627b || str.startsWith("/")) {
            return str;
        }
        try {
            String str2 = (String) TopicType.f23490b.get(Integer.valueOf(Integer.parseInt(str)));
            if (str2 != null) {
                return "/" + str2;
            }
        } catch (NumberFormatException e) {
        }
        return null;
    }

    public final boolean m32030a() {
        return this.f23627b;
    }
}

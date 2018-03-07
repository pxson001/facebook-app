package com.facebook.http.observer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: intern_settings_history */
public class TimeInfo {
    private final Integer f19729a;
    private final Integer f19730b;
    private List<String> f19731c = null;
    private Map<String, String> f19732d = null;

    public TimeInfo(Integer num, Integer num2) {
        this.f19729a = num;
        this.f19730b = num2;
    }

    public final Map<String, String> m27420a() {
        if (this.f19732d != null) {
            return this.f19732d;
        }
        this.f19732d = new HashMap();
        m27419a("device_auto_time_setting", this.f19729a);
        m27419a("device_auto_time_zone_setting", this.f19730b);
        return this.f19732d;
    }

    private void m27419a(String str, Object obj) {
        if (obj != null) {
            this.f19732d.put(str, String.valueOf(obj));
        }
    }
}

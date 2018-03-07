package com.facebook.contextual;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: outgoing */
public class RawConfig {
    public final String f8536a;
    public Map<String, String> f8537b = new HashMap();

    public RawConfig(String str) {
        this.f8536a = str;
    }

    public final RawConfig m12341a(String str, String str2) {
        this.f8537b.put(str, str2);
        return this;
    }

    public final String m12342a() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Entry entry : this.f8537b.entrySet()) {
            if (i > 0) {
                stringBuilder.append(" , ");
            }
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append(": ");
            stringBuilder.append((String) entry.getValue());
            i++;
        }
        return stringBuilder.toString();
    }

    public final String m12343b() {
        return this.f8536a;
    }
}

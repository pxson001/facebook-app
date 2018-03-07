package com.facebook.analytics.tagging;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: qp_impression_counter */
public class ModuleInfo {
    public final String f8470a;
    public final String f8471b;
    public final Map<String, ?> f8472c;

    public ModuleInfo(String str, String str2, @Nullable Map<String, ?> map) {
        this.f8470a = str;
        this.f8471b = str2;
        if (map == null) {
            this.f8472c = new HashMap();
        } else {
            this.f8472c = new HashMap(map);
        }
    }

    public final String m13031a() {
        return this.f8470a;
    }

    public final String m13032b() {
        return this.f8471b;
    }

    public String toString() {
        return this.f8471b + ":" + (this.f8470a != null ? this.f8470a.toString() : "");
    }
}

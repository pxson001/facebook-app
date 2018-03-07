package com.facebook.stetho.inspector.helper;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: num_ads_in_first_fetch_storyset */
public class ChromePeerManager {
    @GuardedBy("this")
    private final Map<Object, Object> f11993a = new HashMap();

    public final synchronized boolean m17685a() {
        return !this.f11993a.isEmpty();
    }
}

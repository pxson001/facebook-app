package com.facebook.debug.activitytracer;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.debug.tracer.AsyncTracer;
import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: user_data/ */
public class ActivityTrace {
    private final DefaultAndroidThreadUtil f1452a;
    public final AsyncTracer f1453b;
    private final Map<String, Object> f1454c = Maps.m838c();
    private final String f1455d = SafeUUIDGenerator.m2795a().toString();
    private final List<String> f1456e = Lists.m1296a();
    private String f1457f;
    public String f1458g;
    public String f1459h;
    public String f1460i;
    public String f1461j;
    private AppStartupType f1462k = AppStartupType.NONE;
    public boolean f1463l = false;
    public long f1464m = -1;

    @Inject
    public ActivityTrace(DefaultAndroidThreadUtil defaultAndroidThreadUtil, @Assisted AsyncTracer asyncTracer, @Assisted String str) {
        this.f1452a = defaultAndroidThreadUtil;
        this.f1453b = (AsyncTracer) Preconditions.checkNotNull(asyncTracer);
        this.f1457f = (String) Preconditions.checkNotNull(str);
    }

    public final ActivityTrace m2791a(String str, Object obj) {
        this.f1452a.m1649a();
        this.f1454c.put(str, obj);
        return this;
    }

    public final void m2793a(String str) {
        this.f1452a.m1649a();
        this.f1456e.add(str);
    }

    public final ActivityTrace m2794c(@Nullable String str) {
        if (!(this.f1459h == null || this.f1459h == str)) {
            m2793a("prev_dest:" + str);
        }
        this.f1459h = str;
        return this;
    }

    public final void m2792a(@Nullable AppStartupType appStartupType) {
        this.f1462k = appStartupType;
    }
}

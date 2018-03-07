package com.facebook.common.propertybag;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: sv_SE */
public class PropertyBagHelper {
    @GuardedBy("this")
    private Map<Object, Object> f3732a;

    public final synchronized void m6132a(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        if (this.f3732a == null) {
            this.f3732a = Maps.m838c();
        }
        this.f3732a.put(obj, obj2);
    }

    public final synchronized Object m6131a(Object obj) {
        Preconditions.checkNotNull(obj);
        return this.f3732a != null ? this.f3732a.get(obj) : null;
    }
}

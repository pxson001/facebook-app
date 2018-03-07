package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
/* compiled from: link_fb_invite */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> f17431a = new IdentityHashMap();
    @GuardedBy("this")
    private T f17432b;
    @GuardedBy("this")
    private int f17433c = 1;
    private final ResourceReleaser<T> f17434d;

    public SharedReference(T t, ResourceReleaser<T> resourceReleaser) {
        this.f17432b = Preconditions.a(t);
        this.f17434d = (ResourceReleaser) Preconditions.a(resourceReleaser);
        m24528a((Object) t);
    }

    private static void m24528a(Object obj) {
        synchronized (f17431a) {
            Integer num = (Integer) f17431a.get(obj);
            if (num == null) {
                f17431a.put(obj, Integer.valueOf(1));
            } else {
                f17431a.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void m24530b(Object obj) {
        synchronized (f17431a) {
            Integer num = (Integer) f17431a.get(obj);
            if (num == null) {
                FLog.b("SharedReference", "No entry in sLiveObjects for value of type %s", new Object[]{obj.getClass()});
            } else if (num.intValue() == 1) {
                f17431a.remove(obj);
            } else {
                f17431a.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public final synchronized T m24534a() {
        return this.f17432b;
    }

    private synchronized boolean m24531d() {
        return this.f17433c > 0;
    }

    private static boolean m24529a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.m24531d();
    }

    public final synchronized void m24535b() {
        m24533f();
        this.f17433c++;
    }

    public final void m24536c() {
        if (m24532e() == 0) {
            Object obj;
            synchronized (this) {
                obj = this.f17432b;
                this.f17432b = null;
            }
            this.f17434d.mo2019a(obj);
            m24530b(obj);
        }
    }

    private synchronized int m24532e() {
        m24533f();
        Preconditions.a(this.f17433c > 0);
        this.f17433c--;
        return this.f17433c;
    }

    private void m24533f() {
        if (!m24529a(this)) {
            throw new NullReferenceException();
        }
    }
}

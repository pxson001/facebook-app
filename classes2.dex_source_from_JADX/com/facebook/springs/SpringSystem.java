package com.facebook.springs;

import com.facebook.common.collect.ReentrantCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.DefaultChoreographerWrapper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Platform;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;

/* compiled from: sponsored_impressions_log_duration_enabled */
public class SpringSystem {
    public final Map<String, Spring> f4237a = new HashMap();
    private final Set<Spring> f4238b = Platform.m644a(new ConcurrentHashMap());
    private final ChoreographerWrapper f4239c;
    private final SpringSystemFrameCallbackWrapper f4240d;
    private final Clock f4241e;
    private long f4242f = -1;
    private ReentrantCallback<Object> f4243g = new ReentrantCallback();
    private boolean f4244h = true;

    public static SpringSystem m7835b(InjectorLike injectorLike) {
        return new SpringSystem(SystemClockMethodAutoProvider.m1498a(injectorLike), DefaultChoreographerWrapper.m11555a(injectorLike), SpringSystemFrameCallbackWrapper.m11563a(injectorLike));
    }

    public static SpringSystem m7833a(InjectorLike injectorLike) {
        return m7835b(injectorLike);
    }

    @Inject
    public SpringSystem(Clock clock, ChoreographerWrapper choreographerWrapper, SpringSystemFrameCallbackWrapper springSystemFrameCallbackWrapper) {
        this.f4241e = clock;
        this.f4239c = choreographerWrapper;
        this.f4240d = springSystemFrameCallbackWrapper;
        this.f4240d.f6969a = this;
    }

    private boolean m7837d() {
        return this.f4244h;
    }

    public final Spring m7838a() {
        Spring spring = new Spring(this);
        m7836b(spring);
        return spring;
    }

    @VisibleForTesting
    private void m7836b(Spring spring) {
        boolean z;
        Preconditions.checkNotNull(spring);
        if (this.f4237a.containsKey(spring.f4217d)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z);
        this.f4237a.put(spring.f4217d, spring);
    }

    @Deprecated
    @VisibleForTesting
    public final void m7839a(Spring spring) {
        Preconditions.checkNotNull(spring);
        this.f4238b.remove(spring);
        this.f4237a.remove(spring.f4217d);
    }

    @VisibleForTesting
    private void m7834a(long j, long j2) {
        for (Spring spring : this.f4238b) {
            Object obj;
            if (spring.m7829k() && spring.f4223j) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                spring.m7826f(((double) j2) / 1000.0d);
            } else {
                this.f4238b.remove(spring);
            }
        }
    }

    @VisibleForTesting
    public final void m7841c() {
        long a = this.f4241e.mo211a();
        if (this.f4242f == -1) {
            this.f4242f = a - 1;
        }
        long j = a - this.f4242f;
        this.f4242f = a;
        Iterator it = this.f4243g.iterator();
        while (it.hasNext()) {
            it.next();
        }
        m7834a(a, j);
        synchronized (this) {
            if (this.f4238b.size() == 0) {
                this.f4244h = true;
                this.f4242f = -1;
            }
        }
        Iterator it2 = this.f4243g.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
        this.f4239c.mo1638b(this.f4240d);
        if (!this.f4244h) {
            this.f4239c.mo1636a(this.f4240d);
        }
    }

    @VisibleForTesting
    public final void m7840a(String str) {
        Spring spring = (Spring) this.f4237a.get(str);
        if (spring == null) {
            throw new IllegalArgumentException("springId " + str + " does not reference a registered spring");
        }
        synchronized (this) {
            this.f4238b.add(spring);
            if (m7837d()) {
                this.f4244h = false;
                this.f4239c.mo1636a(this.f4240d);
            }
        }
    }
}

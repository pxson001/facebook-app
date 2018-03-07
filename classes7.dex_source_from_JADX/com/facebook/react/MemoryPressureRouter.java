package com.facebook.react;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.facebook.react.bridge.MemoryPressure;
import com.facebook.react.bridge.MemoryPressureListener;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: has_bottom_border */
public class MemoryPressureRouter {
    private final Set<MemoryPressureListener> f11355a = Collections.synchronizedSet(new LinkedHashSet());
    private final ComponentCallbacks2 f11356b = new C09991(this);

    /* compiled from: has_bottom_border */
    class C09991 implements ComponentCallbacks2 {
        final /* synthetic */ MemoryPressureRouter f11354a;

        C09991(MemoryPressureRouter memoryPressureRouter) {
            this.f11354a = memoryPressureRouter;
        }

        public void onTrimMemory(int i) {
            this.f11354a.m13231a(i);
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }
    }

    MemoryPressureRouter(Context context) {
        context.getApplicationContext().registerComponentCallbacks(this.f11356b);
    }

    public final void m13235a(MemoryPressureListener memoryPressureListener) {
        this.f11355a.add(memoryPressureListener);
    }

    public final void m13236b(MemoryPressureListener memoryPressureListener) {
        this.f11355a.remove(memoryPressureListener);
    }

    public final void m13234a(Context context) {
        context.getApplicationContext().unregisterComponentCallbacks(this.f11356b);
    }

    private void m13231a(int i) {
        if (i >= 80) {
            m13233a(MemoryPressure.CRITICAL);
        } else if (i >= 40 || i == 15) {
            m13233a(MemoryPressure.MODERATE);
        } else if (i == 20) {
            m13233a(MemoryPressure.UI_HIDDEN);
        }
    }

    private void m13233a(MemoryPressure memoryPressure) {
        for (MemoryPressureListener a : (MemoryPressureListener[]) this.f11355a.toArray(new MemoryPressureListener[this.f11355a.size()])) {
            a.mo650a(memoryPressure);
        }
    }
}

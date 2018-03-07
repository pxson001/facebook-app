package com.facebook.common.objectpool;

import com.facebook.common.time.MonotonicClock;
import java.util.HashMap;

/* compiled from: show_objectionable_warning */
public class ObjectPoolManager {
    public final HashMap<Class, ObjectPool> f2721a = new HashMap();
    public final MonotonicClock f2722b;

    public ObjectPoolManager(MonotonicClock monotonicClock) {
        this.f2722b = monotonicClock;
    }
}

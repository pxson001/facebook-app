package com.facebook.compactdisk;

import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* compiled from: max_packets */
public class CallableLazySingletonMap<K, V> {
    private Map<K, FutureTask<V>> f8189a = new HashMap();

    public final synchronized void m8490a() {
        this.f8189a.clear();
    }

    public final V m8489a(K k, Callable<V> callable) {
        Object obj = null;
        synchronized (this) {
            Future future = (FutureTask) this.f8189a.get(k);
            if (future == null) {
                obj = 1;
                future = new FutureTask(callable);
                this.f8189a.put(k, future);
            }
        }
        if (obj != null) {
            future.run();
        }
        try {
            return FutureDetour.a(future, 1544676562);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}

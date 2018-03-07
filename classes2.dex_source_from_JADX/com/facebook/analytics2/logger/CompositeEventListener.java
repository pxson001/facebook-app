package com.facebook.analytics2.logger;

import com.facebook.common.collectlite.CopyOnWriteArray;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: target_locale */
public class CompositeEventListener implements EventListener {
    private final CopyOnWriteArray<EventListener> f3161a = new CopyOnWriteArray();

    public final void m5329a(EventListener eventListener) {
        this.f3161a.m5331a(eventListener);
    }

    public final void mo733a() {
        List a = this.f3161a.m5330a();
        try {
            int size = a.size();
            for (int i = 0; i < size; i++) {
                ((EventListener) a.get(i)).mo733a();
            }
        } finally {
            this.f3161a.m5332b();
        }
    }
}

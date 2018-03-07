package com.facebook.content.event;

import com.facebook.common.internal.Preconditions;
import com.facebook.inject.InjectorLike;
import java.util.ArrayList;
import java.util.List;

/* compiled from: prefetch_staleness_time */
public class FbEventSubscriberListManager {
    private final List<FbEventSubscriber> f9214a = new ArrayList();

    public static FbEventSubscriberListManager m14130a(InjectorLike injectorLike) {
        return new FbEventSubscriberListManager();
    }

    public final boolean m14133a(FbEventSubscriber fbEventSubscriber) {
        if (fbEventSubscriber == null) {
            return false;
        }
        return this.f9214a.add(fbEventSubscriber);
    }

    public final boolean m14135b(FbEventSubscriber fbEventSubscriber) {
        return this.f9214a.remove(fbEventSubscriber);
    }

    public final void m14132a(FbEventSubscriber... fbEventSubscriberArr) {
        for (FbEventSubscriber a : fbEventSubscriberArr) {
            m14133a(a);
        }
    }

    public final void m14131a(FbEventBus fbEventBus) {
        Preconditions.a(fbEventBus);
        int size = this.f9214a.size();
        for (int i = 0; i < size; i++) {
            fbEventBus.m4568a((FbEventSubscriber) this.f9214a.get(i));
        }
    }

    public final void m14134b(FbEventBus fbEventBus) {
        Preconditions.a(fbEventBus);
        int size = this.f9214a.size();
        for (int i = 0; i < size; i++) {
            fbEventBus.m4569b((FbEventSubscriber) this.f9214a.get(i));
        }
    }
}

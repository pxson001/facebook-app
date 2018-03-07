package com.facebook.messaging.send.client;

import com.facebook.common.time.MonotonicClock;
import com.facebook.messaging.model.send.PendingSendQueueKey;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: deleteThread */
public class PendingThreadSendMap {
    private final MonotonicClock f16678a;
    public final Map<PendingSendQueueKey, PendingThreadSends> f16679b = Maps.c();

    PendingThreadSendMap(MonotonicClock monotonicClock) {
        this.f16678a = monotonicClock;
    }

    public final PendingThreadSends m16706a(PendingSendQueueKey pendingSendQueueKey) {
        return (PendingThreadSends) this.f16679b.get(pendingSendQueueKey);
    }

    public final PendingThreadSends m16708b(PendingSendQueueKey pendingSendQueueKey) {
        return (PendingThreadSends) this.f16679b.remove(pendingSendQueueKey);
    }

    public final Collection<PendingThreadSends> m16707a() {
        return Collections.unmodifiableCollection(this.f16679b.values());
    }

    final PendingThreadSends m16709c(PendingSendQueueKey pendingSendQueueKey) {
        PendingThreadSends pendingThreadSends = (PendingThreadSends) this.f16679b.get(pendingSendQueueKey);
        if (pendingThreadSends != null) {
            return pendingThreadSends;
        }
        pendingThreadSends = new PendingThreadSends(this.f16678a, pendingSendQueueKey);
        this.f16679b.put(pendingSendQueueKey, pendingThreadSends);
        return pendingThreadSends;
    }
}

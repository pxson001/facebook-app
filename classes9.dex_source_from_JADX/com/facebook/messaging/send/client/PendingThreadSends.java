package com.facebook.messaging.send.client;

import com.facebook.common.time.MonotonicClock;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.send.PendingSendQueueKey;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: deletePaymentPinParams */
public class PendingThreadSends {
    public final PendingSendQueueKey f16680a;
    public final MonotonicClock f16681b;
    public final LinkedList<Message> f16682c = Lists.b();
    public long f16683d;
    public boolean f16684e;
    public String f16685f;
    public int f16686g;
    public long f16687h;
    public long f16688i;
    public boolean f16689j;

    PendingThreadSends(MonotonicClock monotonicClock, PendingSendQueueKey pendingSendQueueKey) {
        this.f16681b = monotonicClock;
        this.f16680a = pendingSendQueueKey;
        this.f16683d = this.f16681b.now();
    }

    final void m16710a(Message message) {
        this.f16682c.add(message);
    }

    final void m16713b(Message message) {
        this.f16682c.add(0, message);
    }

    final boolean m16712a(String str) {
        Iterator it = this.f16682c.iterator();
        while (it.hasNext()) {
            if (Objects.equal(((Message) it.next()).n, str)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public final boolean m16711a() {
        return this.f16682c.isEmpty();
    }

    public final long m16714c() {
        return this.f16683d;
    }

    public final int m16715j() {
        return this.f16686g;
    }

    public final long m16716l() {
        return this.f16687h;
    }

    public final List<Message> m16717o() {
        return Collections.unmodifiableList(this.f16682c);
    }
}

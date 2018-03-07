package com.facebook.messaging.sync.tempcache;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@UserScoped
@ThreadSafe
/* compiled from: post/<post_id> */
public class UncommittedThreadModificationsCache {
    private static final Object f4680g = new Object();
    private final Clock f4681a;
    @GuardedBy("mDeliveryWatermarks")
    private final LinkedHashMap<SeenStateKey, SeenState> f4682b = Maps.d();
    @GuardedBy("mReceivedMessages")
    private final LinkedHashMultimap<ThreadKey, Message> f4683c = LinkedHashMultimap.u();
    @GuardedBy("mReceivedMessages")
    private final HashMap<String, Message> f4684d = Maps.c();
    @GuardedBy("mReceivedMessages")
    private final HashMap<String, Long> f4685e = Maps.c();
    @GuardedBy("mReceivedMessages")
    private final HashMap<ThreadKey, ThreadSummary> f4686f = Maps.c();

    private static UncommittedThreadModificationsCache m4226b(InjectorLike injectorLike) {
        return new UncommittedThreadModificationsCache((Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.tempcache.UncommittedThreadModificationsCache m4224a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f4680g;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m4226b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4680g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.tempcache.UncommittedThreadModificationsCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.tempcache.UncommittedThreadModificationsCache) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f4680g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.tempcache.UncommittedThreadModificationsCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.tempcache.UncommittedThreadModificationsCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.tempcache.UncommittedThreadModificationsCache");
    }

    @Inject
    public UncommittedThreadModificationsCache(Clock clock) {
        this.f4681a = clock;
    }

    public final ThreadSummary m4229a(ThreadSummary threadSummary) {
        if (threadSummary == null) {
            return null;
        }
        m4225a();
        Builder builder = ImmutableList.builder();
        ImmutableList immutableList = threadSummary.h;
        int size = immutableList.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
            synchronized (this.f4682b) {
                SeenState seenState = (SeenState) this.f4682b.get(new SeenStateKey(threadSummary.a, threadParticipant.b().b()));
            }
            if (seenState == null || seenState.f4676a <= threadParticipant.d) {
                builder.c(threadParticipant);
                obj2 = obj;
            } else {
                builder.c(new ThreadParticipantBuilder().a(threadParticipant).b(seenState.f4676a).f());
                ThreadKey threadKey = threadSummary.a;
                Long.valueOf(seenState.f4676a);
                obj2 = 1;
            }
            i++;
            obj = obj2;
        }
        return obj != null ? ThreadSummary.newBuilder().a(threadSummary).a(builder.b()).V() : threadSummary;
    }

    private void m4225a() {
        long a = this.f4681a.a();
        synchronized (this.f4682b) {
            Iterator it = this.f4682b.entrySet().iterator();
            while (it.hasNext() && a - ((SeenState) ((Entry) it.next()).getValue()).f4677b > 30000) {
                it.remove();
            }
        }
    }

    public final void m4231a(ImmutableCollection<String> immutableCollection) {
        Preconditions.checkNotNull(immutableCollection);
        synchronized (this.f4683c) {
            Iterator it = immutableCollection.iterator();
            while (it.hasNext()) {
                Message message = (Message) this.f4684d.remove((String) it.next());
                if (message != null) {
                    this.f4683c.c(message.b, message);
                    this.f4685e.remove(message.n);
                }
            }
        }
    }

    public final void m4230a(ThreadKey threadKey) {
        synchronized (this.f4683c) {
            if (this.f4683c.f(threadKey)) {
                Iterator it = this.f4683c.a(threadKey).iterator();
                while (it.hasNext()) {
                    this.f4684d.remove(((Message) it.next()).n);
                    it.remove();
                }
                this.f4686f.remove(threadKey);
                return;
            }
        }
    }

    public final List<Message> m4233b(ThreadKey threadKey) {
        List<Message> a;
        synchronized (this.f4683c) {
            m4227b();
            a = Lists.a(Lists.a(this.f4683c.a(threadKey)));
        }
        return a;
    }

    public final boolean m4232a(ThreadKey threadKey, List<Message> list) {
        boolean a;
        synchronized (this.f4683c) {
            a = Iterables.a(Lists.a(list), this.f4683c.a(threadKey));
        }
        return a;
    }

    @Nullable
    public final Message m4228a(String str) {
        Message message;
        synchronized (this.f4683c) {
            message = (Message) this.f4684d.get(str);
        }
        return message;
    }

    @GuardedBy("mReceivedMessages")
    private void m4227b() {
        long a = this.f4681a.a();
        Iterator it = this.f4683c.t().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            ThreadKey threadKey = (ThreadKey) entry.getKey();
            Message message = (Message) entry.getValue();
            if (a - ((Long) this.f4685e.get(message.n)).longValue() >= 30000) {
                it.remove();
                this.f4685e.remove(message.n);
                if (!this.f4683c.f(threadKey)) {
                    this.f4686f.remove(threadKey);
                }
            } else {
                return;
            }
        }
    }
}

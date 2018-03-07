package com.facebook.feed.rows.core.events;

import android.util.Pair;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: phone_verified */
public class EventsStream {
    private static final Object f10111a = new Object();
    private static volatile EventsStream f10112e;
    private final ArrayListMultimap<Pair, Action<?>> f10113b = ArrayListMultimap.m2971t();
    private boolean f10114c;
    private final List<KeyedEvent> f10115d = Lists.m1296a();

    public static com.facebook.feed.rows.core.events.EventsStream m15220a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10112e;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feed.rows.core.events.EventsStream.class;
        monitor-enter(r1);
        r0 = f10112e;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m15227c();	 Catch:{ all -> 0x0034 }
        f10112e = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f10112e;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.rows.core.events.EventsStream.a(com.facebook.inject.InjectorLike):com.facebook.feed.rows.core.events.EventsStream");
    }

    private static EventsStream m15227c() {
        return new EventsStream();
    }

    public final <E extends KeyedEvent<K>, K> void m15231a(E e) {
        if (this.f10114c) {
            this.f10115d.add(e);
            return;
        }
        m15221a();
        try {
            m15225b((KeyedEvent) e);
        } finally {
            m15224b();
        }
    }

    public final <E extends KeyedEvent<K>, K> Subscription<E, K> m15229a(Class<E> cls, Action<E> action) {
        return m15230a(cls, null, action);
    }

    public final <E extends KeyedEvent<K>, K> Subscription<E, K> m15230a(Class<E> cls, @Nullable K k, Action<E> action) {
        Pair a = m15219a((Class) cls, (Object) k);
        if (this.f10114c) {
            m15231a(new SubscribeEvent(a, action));
        } else {
            m15222a((Action) action, a);
        }
        return new Subscription(cls, k, action);
    }

    public final <K> void m15232a(Subscription<? extends KeyedEvent<K>, K> subscription) {
        if (this.f10114c) {
            m15231a(new UnsubscribeEvent(subscription));
        } else {
            m15226b((Subscription) subscription);
        }
    }

    private void m15221a() {
        Preconditions.checkState(!this.f10114c);
        this.f10114c = true;
    }

    private void m15224b() {
        Preconditions.checkState(this.f10114c);
        while (!this.f10115d.isEmpty()) {
            try {
                m15228c((KeyedEvent) this.f10115d.remove(0));
            } finally {
                this.f10115d.clear();
                this.f10114c = false;
            }
        }
    }

    private <E extends KeyedEvent<K>, K> void m15225b(E e) {
        if (e.mo1976c() != null) {
            m15223a((KeyedEvent) e, e.mo1976c());
        }
        m15223a((KeyedEvent) e, null);
    }

    private <E extends KeyedEvent<K>, K> void m15223a(E e, @Nullable K k) {
        Pair a = m15219a(e.getClass(), (Object) k);
        if (this.f10113b.mo414f(a)) {
            List a2 = this.f10113b.mo424a(a);
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                ((Action) a2.get(i)).mo1977a(e);
            }
        }
    }

    private <E> void m15222a(Action<E> action, Pair pair) {
        this.f10113b.mo431a((Object) pair, (Object) action);
    }

    private static <E extends KeyedEvent<K>, K> Pair<Class<E>, ?> m15219a(Class<E> cls, @Nullable K k) {
        if (k == null) {
            return Pair.create(cls, f10111a);
        }
        return Pair.create(cls, k);
    }

    private <K> void m15226b(Subscription<? extends KeyedEvent<K>, K> subscription) {
        this.f10113b.mo412c(m15219a(subscription.f10137a, subscription.f10138b), subscription.f10139c);
    }

    private void m15228c(KeyedEvent keyedEvent) {
        if (keyedEvent instanceof SubscribeEvent) {
            SubscribeEvent subscribeEvent = (SubscribeEvent) keyedEvent;
            m15222a(subscribeEvent.b, subscribeEvent.a);
        } else if (keyedEvent instanceof UnsubscribeEvent) {
            m15226b((Subscription) keyedEvent.mo1976c());
        } else {
            m15225b(keyedEvent);
        }
    }
}

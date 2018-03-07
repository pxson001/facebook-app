package com.facebook.pages.common.job_sequencer;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.job_sequencer.SequencedJob.Builder;
import com.facebook.pages.common.job_sequencer.SequencedJob.Priority;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: share_timeline */
public class PagesJobSequencer {
    private static volatile PagesJobSequencer f1624f;
    private final ListeningExecutorService f1625a;
    private final ListeningExecutorService f1626b;
    private final Set<SequencedJob>[] f1627c = new Set[this.f1628d];
    private final int f1628d = Priority.values().length;
    private final Map<String, Long> f1629e;

    public static com.facebook.pages.common.job_sequencer.PagesJobSequencer m2443a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1624f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.common.job_sequencer.PagesJobSequencer.class;
        monitor-enter(r1);
        r0 = f1624f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m2447b(r0);	 Catch:{ all -> 0x0035 }
        f1624f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1624f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.job_sequencer.PagesJobSequencer.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.job_sequencer.PagesJobSequencer");
    }

    private static PagesJobSequencer m2447b(InjectorLike injectorLike) {
        return new PagesJobSequencer((ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PagesJobSequencer(ListeningExecutorService listeningExecutorService, ListeningExecutorService listeningExecutorService2) {
        this.f1625a = listeningExecutorService;
        this.f1626b = listeningExecutorService2;
        for (int i = 0; i < this.f1628d; i++) {
            this.f1627c[i] = new HashSet();
        }
        this.f1629e = new HashMap();
    }

    public final synchronized void m2450a(String str, @Nullable ImmutableSet<SequencerSignal> immutableSet) {
        if (!(Strings.isNullOrEmpty(str) || immutableSet == null || immutableSet.isEmpty())) {
            m2445a(this, str, SequencedJob.m2457a((ImmutableSet) immutableSet));
        }
    }

    public final synchronized void m2449a(SequencedJob sequencedJob) {
        if (sequencedJob != null) {
            if (sequencedJob.m2460a(m2446b(sequencedJob.m2461b()))) {
                m2448b(sequencedJob);
            } else {
                this.f1627c[sequencedJob.m2458a().ordinal()].add(sequencedJob);
            }
        }
    }

    public final synchronized void m2451b(final String str, @Nullable ImmutableSet<SequencerSignal> immutableSet) {
        if (immutableSet != null) {
            if (!immutableSet.isEmpty()) {
                m2449a(new Builder().m2455a(new Callable<Object>(this) {
                    final /* synthetic */ PagesJobSequencer f1621b;

                    public Object call() {
                        PagesJobSequencer.m2444a(this.f1621b, str);
                        return null;
                    }
                }, false).m2452a(Priority.CAN_WAIT).m2454a(str).m2453a((ImmutableSet) immutableSet).m2456a());
            }
        }
        m2444a(this, str);
    }

    private synchronized <T> void m2448b(final SequencedJob<T> sequencedJob) {
        Futures.a(sequencedJob.m2459a(this.f1625a, this.f1626b), new FutureCallback<T>(this) {
            final /* synthetic */ PagesJobSequencer f1623b;

            public void onSuccess(@Nullable T t) {
                if (sequencedJob.f1642d != 0) {
                    PagesJobSequencer.m2445a(this.f1623b, sequencedJob.f1640b, sequencedJob.f1642d);
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f1625a);
    }

    public static synchronized void m2445a(PagesJobSequencer pagesJobSequencer, String str, long j) {
        synchronized (pagesJobSequencer) {
            pagesJobSequencer.f1629e.put(str, Long.valueOf(pagesJobSequencer.m2446b(str) | j));
            for (int i = 0; i < pagesJobSequencer.f1628d; i++) {
                Collection hashSet = new HashSet();
                for (SequencedJob sequencedJob : pagesJobSequencer.f1627c[i]) {
                    if (sequencedJob.m2461b().equals(str) && sequencedJob.m2460a(pagesJobSequencer.m2446b(sequencedJob.m2461b()))) {
                        hashSet.add(sequencedJob);
                        pagesJobSequencer.m2448b(sequencedJob);
                    }
                }
                pagesJobSequencer.f1627c[i].removeAll(hashSet);
            }
        }
    }

    public static synchronized void m2444a(PagesJobSequencer pagesJobSequencer, String str) {
        synchronized (pagesJobSequencer) {
            for (int i = 0; i < pagesJobSequencer.f1628d; i++) {
                Collection hashSet = new HashSet();
                for (SequencedJob sequencedJob : pagesJobSequencer.f1627c[i]) {
                    if (sequencedJob.m2461b().equals(str)) {
                        hashSet.add(sequencedJob);
                    }
                }
                pagesJobSequencer.f1627c[i].removeAll(hashSet);
            }
            pagesJobSequencer.f1629e.remove(str);
        }
    }

    private synchronized long m2446b(String str) {
        return this.f1629e.get(str) == null ? 0 : ((Long) this.f1629e.get(str)).longValue();
    }
}

package com.facebook.backgroundworklog.observer;

import android.app.Service;
import android.content.Intent;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.inject.ProviderLazy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: website_promotion/?page_id=%s&source=%s&referral=%s */
public class MultiplexBackgroundWorkObserver implements BackgroundWorkObserver {
    private static volatile MultiplexBackgroundWorkObserver f873h;
    public final MonotonicClock f874a;
    private final Lazy<Set<BackgroundWorkObserver>> f875b;
    private OnBackgroundWorkObservedChanged f876c;
    @GuardedBy("this")
    private Set<BackgroundWorkObserver> f877d;
    @GuardedBy("this")
    private ArrayList<BackgroundWorkObserver> f878e;
    private volatile boolean f879f;
    @GuardedBy("this")
    private ArrayList<WeakReference<OnBackgroundWorkObservedChanged>> f880g;

    /* compiled from: website_promotion/?page_id=%s&source=%s&referral=%s */
    class C00951 implements OnBackgroundWorkObservedChanged {
        final /* synthetic */ MultiplexBackgroundWorkObserver f1393a;

        C00951(MultiplexBackgroundWorkObserver multiplexBackgroundWorkObserver) {
            this.f1393a = multiplexBackgroundWorkObserver;
        }

        public final void mo366a() {
            MultiplexBackgroundWorkObserver.m1674i(this.f1393a);
        }
    }

    public static com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver m1670a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f873h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver.class;
        monitor-enter(r1);
        r0 = f873h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m1671b(r0);	 Catch:{ all -> 0x0035 }
        f873h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f873h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver.a(com.facebook.inject.InjectorLike):com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver");
    }

    private static MultiplexBackgroundWorkObserver m1671b(InjectorLike injectorLike) {
        MonotonicClock a = AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike);
        InjectorLike applicationInjector = injectorLike.getApplicationInjector();
        return new MultiplexBackgroundWorkObserver(a, ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$BackgroundWorkObserver(applicationInjector.getScopeAwareInjector()), applicationInjector.getScopeAwareInjector()));
    }

    @Inject
    public MultiplexBackgroundWorkObserver(MonotonicClock monotonicClock, @NeedsApplicationInjector Lazy<Set<BackgroundWorkObserver>> lazy) {
        this.f874a = monotonicClock;
        this.f875b = lazy;
    }

    public final boolean mo238a() {
        ArrayList h = m1673h();
        return (h == null || h.isEmpty()) ? false : true;
    }

    public final synchronized void mo237a(OnBackgroundWorkObservedChanged onBackgroundWorkObservedChanged) {
        if (this.f880g == null) {
            this.f880g = new ArrayList(1);
        }
        this.f880g.add(new WeakReference(onBackgroundWorkObservedChanged));
    }

    public final void mo232a(int i, String str, Object obj) {
        for (BackgroundWorkObserver a : m1672g()) {
            a.mo232a(i, str, obj);
        }
        m1675j();
    }

    public final long m1684b() {
        return this.f874a.now();
    }

    public final void mo233a(long j, @Nullable Intent intent, @Nullable Class<?> cls) {
        ArrayList h = m1673h();
        if (h != null) {
            int size = h.size();
            for (int i = 0; i < size; i++) {
                ((BackgroundWorkObserver) h.get(i)).mo233a(j, intent, (Class) cls);
            }
        }
    }

    public final void mo236a(long j, @Nullable String str, @Nullable Object obj) {
        ArrayList h = m1673h();
        if (h != null) {
            int size = h.size();
            for (int i = 0; i < size; i++) {
                ((BackgroundWorkObserver) h.get(i)).mo236a(j, str, obj);
            }
        }
    }

    public final long m1686d() {
        return this.f874a.now();
    }

    public final void mo234a(long j, @Nullable Class<? extends Service> cls) {
        ArrayList h = m1673h();
        if (h != null) {
            int size = h.size();
            for (int i = 0; i < size; i++) {
                ((BackgroundWorkObserver) h.get(i)).mo234a(j, cls);
            }
        }
    }

    public final long m1687e() {
        return this.f874a.now();
    }

    public final void mo235a(long j, @Nullable Class<? extends Service> cls, @Nullable Intent intent) {
        ArrayList h = m1673h();
        if (h != null) {
            int size = h.size();
            for (int i = 0; i < size; i++) {
                ((BackgroundWorkObserver) h.get(i)).mo235a(j, (Class) cls, intent);
            }
        }
    }

    public final long m1688f() {
        return this.f874a.now();
    }

    public final void mo239b(long j, @Nullable Class<? extends Service> cls) {
        ArrayList h = m1673h();
        if (h != null) {
            int size = h.size();
            for (int i = 0; i < size; i++) {
                ((BackgroundWorkObserver) h.get(i)).mo239b(j, cls);
            }
        }
    }

    private synchronized Set<BackgroundWorkObserver> m1672g() {
        Set<BackgroundWorkObserver> set;
        if (this.f877d != null) {
            set = this.f877d;
        } else {
            this.f876c = new C00951(this);
            Set<BackgroundWorkObserver> set2 = (Set) this.f875b.get();
            for (BackgroundWorkObserver a : set2) {
                a.mo237a(this.f876c);
            }
            this.f877d = set2;
            set = this.f877d;
        }
        return set;
    }

    @Nullable
    private synchronized ArrayList<BackgroundWorkObserver> m1673h() {
        ArrayList<BackgroundWorkObserver> arrayList;
        if (this.f879f) {
            arrayList = this.f878e;
        } else {
            this.f878e = null;
            Set<BackgroundWorkObserver> g = m1672g();
            for (BackgroundWorkObserver backgroundWorkObserver : g) {
                if (backgroundWorkObserver.mo238a()) {
                    if (this.f878e == null) {
                        this.f878e = new ArrayList(g.size());
                    }
                    this.f878e.add(backgroundWorkObserver);
                }
            }
            this.f879f = true;
            arrayList = this.f878e;
        }
        return arrayList;
    }

    public static void m1674i(MultiplexBackgroundWorkObserver multiplexBackgroundWorkObserver) {
        multiplexBackgroundWorkObserver.m1675j();
        multiplexBackgroundWorkObserver.m1676k();
    }

    private synchronized void m1675j() {
        this.f879f = false;
        this.f878e = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1676k() {
        /*
        r5 = this;
        r0 = 0;
        monitor-enter(r5);
        r1 = r5.f880g;	 Catch:{ all -> 0x0027 }
        if (r1 != 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r5);	 Catch:{ all -> 0x0027 }
    L_0x0007:
        return;
    L_0x0008:
        r1 = r5.f880g;	 Catch:{ all -> 0x0027 }
        r3 = r1.size();	 Catch:{ all -> 0x0027 }
        r1 = r5.f880g;	 Catch:{ all -> 0x0027 }
        r4 = r1.iterator();	 Catch:{ all -> 0x0027 }
        r2 = r0;
    L_0x0015:
        r0 = r4.hasNext();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x0042;
    L_0x001b:
        r0 = r4.next();	 Catch:{ all -> 0x0027 }
        r0 = (java.lang.ref.WeakReference) r0;	 Catch:{ all -> 0x0027 }
        if (r0 != 0) goto L_0x002a;
    L_0x0023:
        r4.remove();	 Catch:{ all -> 0x0027 }
        goto L_0x0015;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r0 = r0.get();	 Catch:{  }
        r0 = (com.facebook.backgroundworklog.observer.OnBackgroundWorkObservedChanged) r0;	 Catch:{  }
        if (r0 != 0) goto L_0x0036;
    L_0x0032:
        r4.remove();	 Catch:{  }
        goto L_0x0015;
    L_0x0036:
        if (r2 != 0) goto L_0x005a;
    L_0x0038:
        r1 = new java.util.ArrayList;	 Catch:{  }
        r1.<init>(r3);	 Catch:{  }
    L_0x003d:
        r1.add(r0);	 Catch:{  }
        r2 = r1;
        goto L_0x0015;
    L_0x0042:
        monitor-exit(r5);	 Catch:{  }
        if (r2 == 0) goto L_0x0007;
    L_0x0045:
        r3 = r2.size();
        r0 = 0;
        r1 = r0;
    L_0x004b:
        if (r1 >= r3) goto L_0x0007;
    L_0x004d:
        r0 = r2.get(r1);
        r0 = (com.facebook.backgroundworklog.observer.OnBackgroundWorkObservedChanged) r0;
        r0.mo366a();
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x004b;
    L_0x005a:
        r1 = r2;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver.k():void");
    }
}

package com.facebook.analytics.eventlisteners;

import android.text.Editable;
import android.text.TextWatcher;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: surround_max_comments */
public class InteractionEventListenerDispatcher implements TextWatcher {
    private static volatile InteractionEventListenerDispatcher f3756c;
    public final Lazy<Set<AnalyticsEventListener>> f3757a;
    public final Clock f3758b;

    public static com.facebook.analytics.eventlisteners.InteractionEventListenerDispatcher m6205a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3756c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.eventlisteners.InteractionEventListenerDispatcher.class;
        monitor-enter(r1);
        r0 = f3756c;	 Catch:{ all -> 0x003a }
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
        r0 = m6206b(r0);	 Catch:{ all -> 0x0035 }
        f3756c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3756c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.eventlisteners.InteractionEventListenerDispatcher.a(com.facebook.inject.InjectorLike):com.facebook.analytics.eventlisteners.InteractionEventListenerDispatcher");
    }

    private static InteractionEventListenerDispatcher m6206b(InjectorLike injectorLike) {
        return new InteractionEventListenerDispatcher(SystemClockMethodAutoProvider.m1498a(injectorLike), ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$AnalyticsEventListener(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()));
    }

    @Inject
    public InteractionEventListenerDispatcher(Clock clock, Lazy<Set<AnalyticsEventListener>> lazy) {
        this.f3757a = lazy;
        this.f3758b = clock;
    }

    public final void m6207a() {
        long a = this.f3758b.mo211a();
        for (AnalyticsEventListener a2 : (Set) this.f3757a.get()) {
            a2.mo2663a(a);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        long a = this.f3758b.mo211a();
        for (AnalyticsEventListener b : (Set) this.f3757a.get()) {
            b.mo2664b(a);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
    }
}

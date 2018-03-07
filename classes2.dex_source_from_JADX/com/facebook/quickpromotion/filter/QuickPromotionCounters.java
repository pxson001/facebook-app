package com.facebook.quickpromotion.filter;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.counters.UiCounters;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: reactions_cancel */
public class QuickPromotionCounters implements IHaveUserData {
    private static volatile QuickPromotionCounters f8012b;
    public final UiCounters f8013a;

    public static com.facebook.quickpromotion.filter.QuickPromotionCounters m12575a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8012b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.filter.QuickPromotionCounters.class;
        monitor-enter(r1);
        r0 = f8012b;	 Catch:{ all -> 0x003a }
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
        r0 = m12577b(r0);	 Catch:{ all -> 0x0035 }
        f8012b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8012b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.filter.QuickPromotionCounters.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.filter.QuickPromotionCounters");
    }

    private static QuickPromotionCounters m12577b(InjectorLike injectorLike) {
        return new QuickPromotionCounters(UiCounters.m12583a(injectorLike));
    }

    @Inject
    QuickPromotionCounters(UiCounters uiCounters) {
        this.f8013a = uiCounters;
    }

    final int m12578a(String str, CounterType counterType) {
        return this.f8013a.m12589a(m12576a(counterType), str);
    }

    public final int m12580c(QuickPromotionDefinition quickPromotionDefinition, CounterType counterType) {
        return this.f8013a.m12589a(m12576a(counterType), quickPromotionDefinition.promotionId);
    }

    public final long m12581d(QuickPromotionDefinition quickPromotionDefinition, CounterType counterType) {
        return this.f8013a.m12592b(m12576a(counterType), quickPromotionDefinition.promotionId);
    }

    public final long m12579b(String str, CounterType counterType) {
        return this.f8013a.m12592b(m12576a(counterType), str);
    }

    public final void m12582e(QuickPromotionDefinition quickPromotionDefinition, CounterType counterType) {
        this.f8013a.m12594c(m12576a(counterType), quickPromotionDefinition.promotionId);
    }

    public static String m12576a(CounterType counterType) {
        switch (1.a[counterType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "qp_impression_counter";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "qp_primary_action_counter";
            case 3:
                return "qp_secondary_action_counter";
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return "qp_dismiss_action_counter";
            case 5:
                return "qp_dismiss_event_counter";
            default:
                throw new IllegalStateException("Unknown CounterType");
        }
    }

    public void clearUserData() {
        for (CounterType a : CounterType.values()) {
            this.f8013a.f8015a.edit().mo1278b(UiCounters.m12585e(m12576a(a))).commit();
        }
    }
}

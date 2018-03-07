package com.facebook.quickpromotion.filter;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.counters.UiCounters;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: reaction_overlay_displayed */
public class SecondsSinceMessageSentPredicate extends AbstractContextualFilterPredicate {
    private static volatile SecondsSinceMessageSentPredicate f4731c;
    private final UiCounters f4732a;
    private final Clock f4733b;

    public static com.facebook.quickpromotion.filter.SecondsSinceMessageSentPredicate m4597a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4731c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.filter.SecondsSinceMessageSentPredicate.class;
        monitor-enter(r1);
        r0 = f4731c;	 Catch:{ all -> 0x003a }
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
        r0 = m4598b(r0);	 Catch:{ all -> 0x0035 }
        f4731c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4731c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.filter.SecondsSinceMessageSentPredicate.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.filter.SecondsSinceMessageSentPredicate");
    }

    private static SecondsSinceMessageSentPredicate m4598b(InjectorLike injectorLike) {
        return new SecondsSinceMessageSentPredicate(UiCounters.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SecondsSinceMessageSentPredicate(UiCounters uiCounters, Clock clock) {
        this.f4732a = uiCounters;
        this.f4733b = clock;
    }

    public final boolean mo217a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        return this.f4732a.b(QuickPromotionUserEvent.MESSAGE_SENT.toEventName()) + (Long.parseLong(contextualFilter.value) * 1000) >= this.f4733b.a();
    }
}

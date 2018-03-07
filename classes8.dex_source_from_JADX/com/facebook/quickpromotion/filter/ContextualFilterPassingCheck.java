package com.facebook.quickpromotion.filter;

import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition$ContextualFilter$Type;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys;
import com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys.FilterState;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: reaction_videos */
public class ContextualFilterPassingCheck {
    private static volatile ContextualFilterPassingCheck f4693c;
    public final ContextualFilterPredicateMap f4694a;
    private final FbSharedPreferences f4695b;

    public static com.facebook.quickpromotion.filter.ContextualFilterPassingCheck m4548a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4693c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.filter.ContextualFilterPassingCheck.class;
        monitor-enter(r1);
        r0 = f4693c;	 Catch:{ all -> 0x003a }
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
        r0 = m4549b(r0);	 Catch:{ all -> 0x0035 }
        f4693c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4693c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.filter.ContextualFilterPassingCheck.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.filter.ContextualFilterPassingCheck");
    }

    private static ContextualFilterPassingCheck m4549b(InjectorLike injectorLike) {
        return new ContextualFilterPassingCheck((ContextualFilterPredicateMap) ContextualFilterPredicateMapImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public ContextualFilterPassingCheck(ContextualFilterPredicateMap contextualFilterPredicateMap, FbSharedPreferences fbSharedPreferences) {
        this.f4694a = contextualFilterPredicateMap;
        this.f4695b = fbSharedPreferences;
    }

    public final boolean m4550a(ContextualFilter contextualFilter, QuickPromotionDefinition quickPromotionDefinition, InterstitialTrigger interstitialTrigger) {
        FilterState filterState = FilterState.values()[this.f4695b.a(QuickPromotionPrefKeys.m4648a(contextualFilter.a()), FilterState.DEFAULT.ordinal())];
        if (filterState.equals(FilterState.ALWAYS_PASS)) {
            return true;
        }
        AbstractContextualFilterPredicate a = this.f4694a.mo220a(contextualFilter.a());
        if (a == null) {
            a = this.f4694a.mo220a(QuickPromotionDefinition$ContextualFilter$Type.UNKNOWN);
        }
        AbstractContextualFilterPredicate abstractContextualFilterPredicate = a;
        if (abstractContextualFilterPredicate == null) {
            return true;
        }
        if (!filterState.equals(FilterState.ALWAYS_FAIL) && abstractContextualFilterPredicate.mo222a(quickPromotionDefinition, contextualFilter, interstitialTrigger)) {
            return true;
        }
        abstractContextualFilterPredicate.mo219b(quickPromotionDefinition, contextualFilter);
        return false;
    }
}

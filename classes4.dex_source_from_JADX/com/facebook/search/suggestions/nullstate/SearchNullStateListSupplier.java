package com.facebook.search.suggestions.nullstate;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.model.GapTypeaheadUnit;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.ui.typeahead.OnFetchStateChangedListener;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: localTZ */
public class SearchNullStateListSupplier extends NullStateSupplier {
    private static volatile SearchNullStateListSupplier f9212g;
    public final ImmutableList<NullStateSupplier> f9213a;
    private final NearbyNullStateSupplier f9214b;
    private final QeAccessor f9215c;
    private int f9216d = 15;
    private final NullStateSupplier$NullStateStatusListener f9217e = new C04271(this);
    public NullStateSupplier$NullStateStatusListener f9218f;

    /* compiled from: localTZ */
    class C04271 implements NullStateSupplier$NullStateStatusListener {
        final /* synthetic */ SearchNullStateListSupplier f9271a;

        C04271(SearchNullStateListSupplier searchNullStateListSupplier) {
            this.f9271a = searchNullStateListSupplier;
        }

        public final void mo745a(NullStateStatus nullStateStatus) {
            if (this.f9271a.f9218f != null) {
                NullStateStatus nullStateStatus2 = NullStateStatus.READY;
                for (int i = 0; i < this.f9271a.f9213a.size(); i++) {
                    if (NullStateStatus.NOT_READY.equals(((NullStateSupplier) this.f9271a.f9213a.get(i)).c())) {
                        nullStateStatus2 = NullStateStatus.PARTIAL;
                    }
                }
                this.f9271a.f9218f.mo745a(nullStateStatus2);
            }
        }
    }

    public static com.facebook.search.suggestions.nullstate.SearchNullStateListSupplier m9555a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9212g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.nullstate.SearchNullStateListSupplier.class;
        monitor-enter(r1);
        r0 = f9212g;	 Catch:{ all -> 0x003a }
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
        r0 = m9557b(r0);	 Catch:{ all -> 0x0035 }
        f9212g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9212g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.nullstate.SearchNullStateListSupplier.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.nullstate.SearchNullStateListSupplier");
    }

    private static SearchNullStateListSupplier m9557b(InjectorLike injectorLike) {
        return new SearchNullStateListSupplier(QrCodePromoNullStateSupplier.m9565a(injectorLike), RecentSearchesNullStateSupplier.m9574a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3401), IdBasedSingletonScopeProvider.a(injectorLike, 3393), IdBasedSingletonScopeProvider.a(injectorLike, 3388), IdBasedSingletonScopeProvider.a(injectorLike, 3389), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public Object get() {
        NearbySectionHelper nearbySectionHelper = new NearbySectionHelper(this.f9214b);
        Builder builder = new Builder();
        builder.c(new GapTypeaheadUnit());
        int size = this.f9213a.size();
        for (int i = 0; i < size; i++) {
            NullStateSupplier nullStateSupplier = (NullStateSupplier) this.f9213a.get(i);
            if (nullStateSupplier.a() && !NullStateStatus.NOT_READY.equals(nullStateSupplier.c())) {
                m9556a(nullStateSupplier);
                ImmutableList immutableList = (ImmutableList) nullStateSupplier.get();
                int size2 = immutableList.size();
                boolean z = false;
                for (int i2 = 0; i2 < size2; i2++) {
                    TypeaheadUnit typeaheadUnit = (TypeaheadUnit) immutableList.get(i2);
                    if (typeaheadUnit.jG_()) {
                        if (z) {
                            nearbySectionHelper.a(builder, false);
                            z = false;
                        }
                        builder.c(typeaheadUnit);
                        nearbySectionHelper.a(builder, false);
                    } else {
                        builder.c(typeaheadUnit);
                        z = true;
                    }
                }
                if (z) {
                    nearbySectionHelper.a(builder, false);
                }
            }
        }
        nearbySectionHelper.a(builder, true);
        return builder.b();
    }

    @Inject
    public SearchNullStateListSupplier(QrCodePromoNullStateSupplier qrCodePromoNullStateSupplier, RecentSearchesNullStateSupplier recentSearchesNullStateSupplier, Provider<SearchSpotlightNullStateSupplier> provider, Provider<PYMKNullStateSupplier> provider2, Provider<ContentDiscoveryNullStateSupplier> provider3, Provider<NearbyNullStateSupplier> provider4, QeAccessor qeAccessor) {
        this.f9214b = (NearbyNullStateSupplier) provider4.get();
        this.f9215c = qeAccessor;
        Builder builder = ImmutableList.builder();
        builder.c(qrCodePromoNullStateSupplier);
        if (!this.f9215c.a(ExperimentsForSearchAbTestModule.aK, false)) {
            builder.c(recentSearchesNullStateSupplier);
        }
        PYMKNullStateSupplier pYMKNullStateSupplier = (PYMKNullStateSupplier) provider2.get();
        if (pYMKNullStateSupplier.a()) {
            builder.c(pYMKNullStateSupplier);
        } else if (!recentSearchesNullStateSupplier.m9596m()) {
            builder.c(provider3.get());
        }
        this.f9213a = builder.b();
    }

    public final void m9558a(@Nullable CallerContext callerContext, NullStateSupplier$RefreshPolicy nullStateSupplier$RefreshPolicy) {
        int size = this.f9213a.size();
        for (int i = 0; i < size; i++) {
            NullStateSupplier nullStateSupplier = (NullStateSupplier) this.f9213a.get(i);
            if (nullStateSupplier.a() && !(nullStateSupplier$RefreshPolicy == NullStateSupplier$RefreshPolicy.MEMORY && NullStateStatus.READY.equals(nullStateSupplier.c()))) {
                nullStateSupplier.a(callerContext, nullStateSupplier$RefreshPolicy);
            }
        }
    }

    public final void m9563b() {
        int size = this.f9213a.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f9213a.get(i)).b();
        }
    }

    public final boolean m9562a() {
        return true;
    }

    public final NullStateStatus m9564c() {
        int size = this.f9213a.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            NullStateSupplier nullStateSupplier = (NullStateSupplier) this.f9213a.get(i);
            if (obj == null && NullStateStatus.READY.equals(nullStateSupplier.c()) && nullStateSupplier.a()) {
                obj2 = 1;
            } else if (obj != null && !NullStateStatus.READY.equals(nullStateSupplier.c()) && nullStateSupplier.a()) {
                return NullStateStatus.PARTIAL;
            } else {
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
        return obj != null ? NullStateStatus.READY : NullStateStatus.NOT_READY;
    }

    public final void m9561a(NullStateSupplier$NullStateStatusListener nullStateSupplier$NullStateStatusListener, OnFetchStateChangedListener onFetchStateChangedListener) {
        this.f9218f = nullStateSupplier$NullStateStatusListener;
        int size = this.f9213a.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f9213a.get(i)).a(nullStateSupplier$NullStateStatusListener != null ? this.f9217e : null, onFetchStateChangedListener);
        }
    }

    public final void m9560a(Type type) {
        int size = this.f9213a.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f9213a.get(i)).a(type);
        }
    }

    public final void m9559a(GraphSearchQuery graphSearchQuery) {
        int size = this.f9213a.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f9213a.get(i)).a(graphSearchQuery);
        }
    }

    private void m9556a(NullStateSupplier nullStateSupplier) {
        int i = 3;
        if (nullStateSupplier instanceof RecentSearchesNullStateSupplier) {
            int a;
            RecentSearchesNullStateSupplier recentSearchesNullStateSupplier = (RecentSearchesNullStateSupplier) nullStateSupplier;
            if (recentSearchesNullStateSupplier.f9239p) {
                a = this.f9215c.a(ExperimentsForSearchAbTestModule.aO, 3);
            } else {
                a = recentSearchesNullStateSupplier.f9241r;
            }
            a = 15 - a;
            if (a <= 0 || a >= 3) {
                i = a;
            }
            this.f9216d = i;
        } else if (nullStateSupplier instanceof PYMKNullStateSupplier) {
            ((PYMKNullStateSupplier) nullStateSupplier).f9310n = this.f9216d;
        }
    }
}

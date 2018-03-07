package com.facebook.search.suggestions.nullstate;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.NullStateStatusListener;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.RefreshPolicy;
import com.facebook.ui.typeahead.OnFetchStateChangedListener;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: wmv */
public class DefaultSearchNullStateListSupplier extends NullStateSupplier implements IHaveUserData, INeedInit {
    private static volatile DefaultSearchNullStateListSupplier f180e;
    public final ImmutableList<NullStateSupplier> f181a;
    private final Provider<String> f182b;
    private final NullStateStatusListener f183c = new C00241(this);
    public NullStateStatusListener f184d;

    /* compiled from: wmv */
    class C00241 implements NullStateStatusListener {
        final /* synthetic */ DefaultSearchNullStateListSupplier f179a;

        C00241(DefaultSearchNullStateListSupplier defaultSearchNullStateListSupplier) {
            this.f179a = defaultSearchNullStateListSupplier;
        }

        public final void m311a(NullStateStatus nullStateStatus) {
            if (this.f179a.f184d != null) {
                NullStateStatus nullStateStatus2 = NullStateStatus.READY;
                for (int i = 0; i < this.f179a.f181a.size(); i++) {
                    if (NullStateStatus.NOT_READY.equals(((NullStateSupplier) this.f179a.f181a.get(i)).c())) {
                        nullStateStatus2 = NullStateStatus.PARTIAL;
                    }
                }
                this.f179a.f184d.a(nullStateStatus2);
            }
        }
    }

    public static com.facebook.search.suggestions.nullstate.DefaultSearchNullStateListSupplier m312a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f180e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.nullstate.DefaultSearchNullStateListSupplier.class;
        monitor-enter(r1);
        r0 = f180e;	 Catch:{ all -> 0x003a }
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
        r0 = m313b(r0);	 Catch:{ all -> 0x0035 }
        f180e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f180e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.nullstate.DefaultSearchNullStateListSupplier.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.nullstate.DefaultSearchNullStateListSupplier");
    }

    private static DefaultSearchNullStateListSupplier m313b(InjectorLike injectorLike) {
        return new DefaultSearchNullStateListSupplier(IdBasedProvider.a(injectorLike, 4442), IdBasedSingletonScopeProvider.a(injectorLike, 3401), IdBasedSingletonScopeProvider.a(injectorLike, 3399));
    }

    @Inject
    public DefaultSearchNullStateListSupplier(Provider<String> provider, Provider<SearchSpotlightNullStateSupplier> provider2, Provider<SearchNullStateListSupplier> provider3) {
        this.f182b = provider;
        Builder builder = ImmutableList.builder();
        SearchSpotlightNullStateSupplier searchSpotlightNullStateSupplier = (SearchSpotlightNullStateSupplier) provider2.get();
        if (searchSpotlightNullStateSupplier.a()) {
            builder.c(searchSpotlightNullStateSupplier);
        }
        SearchNullStateListSupplier searchNullStateListSupplier = (SearchNullStateListSupplier) provider3.get();
        if (searchNullStateListSupplier.a()) {
            builder.c(searchNullStateListSupplier);
        }
        this.f181a = builder.b();
    }

    public final NullStateStatus m320c() {
        int size = this.f181a.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            NullStateSupplier nullStateSupplier = (NullStateSupplier) this.f181a.get(i);
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

    public final boolean m318a() {
        return true;
    }

    public final void m314a(@Nullable CallerContext callerContext, RefreshPolicy refreshPolicy) {
        int size = this.f181a.size();
        for (int i = 0; i < size; i++) {
            NullStateSupplier nullStateSupplier = (NullStateSupplier) this.f181a.get(i);
            if (nullStateSupplier.a() && !(refreshPolicy == RefreshPolicy.MEMORY && NullStateStatus.READY.equals(nullStateSupplier.c()))) {
                nullStateSupplier.a(callerContext, refreshPolicy);
            }
        }
    }

    public final void m319b() {
        int size = this.f181a.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f181a.get(i)).b();
        }
    }

    public void clearUserData() {
        int size = this.f181a.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f181a.get(i)).b();
        }
    }

    public void init() {
        if (!Strings.isNullOrEmpty((String) this.f182b.get())) {
            a(null, RefreshPolicy.MEMORY);
        }
    }

    public Object get() {
        Builder builder = new Builder();
        int size = this.f181a.size();
        for (int i = 0; i < size; i++) {
            NullStateSupplier nullStateSupplier = (NullStateSupplier) this.f181a.get(i);
            if (nullStateSupplier.a() && !NullStateStatus.NOT_READY.equals(nullStateSupplier.c())) {
                ImmutableList immutableList = (ImmutableList) nullStateSupplier.get();
                if (!immutableList.isEmpty()) {
                    builder.b(immutableList);
                }
            }
        }
        return builder.b();
    }

    public final void m317a(NullStateStatusListener nullStateStatusListener, OnFetchStateChangedListener onFetchStateChangedListener) {
        this.f184d = nullStateStatusListener;
        int size = this.f181a.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f181a.get(i)).a(nullStateStatusListener != null ? this.f183c : null, onFetchStateChangedListener);
        }
    }

    public final void m315a(GraphSearchQuery graphSearchQuery) {
        int size = this.f181a.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f181a.get(i)).a(graphSearchQuery);
        }
    }

    public final void m316a(Type type) {
        int size = this.f181a.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f181a.get(i)).a(type);
        }
    }
}

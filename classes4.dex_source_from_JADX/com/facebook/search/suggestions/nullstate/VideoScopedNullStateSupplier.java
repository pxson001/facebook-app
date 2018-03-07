package com.facebook.search.suggestions.nullstate;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.abtest.VideoSearchExperimentHelper;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery$ScopedEntityType;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.model.EmptyScopedNullStateTypeaheadUnit;
import com.facebook.search.model.GapTypeaheadUnit;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.OnFetchStateChangedListener;
import com.facebook.ui.typeahead.TypeaheadFetcher$OnSuggestionsFetchedListener;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.facebook.ultralight.Inject;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: list_type */
public class VideoScopedNullStateSupplier extends NullStateSupplier implements IHaveUserData, INeedInit, OnFetchStateChangedListener, TypeaheadFetcher$OnSuggestionsFetchedListener<TypeaheadUnit> {
    private static final TypeaheadUnit f9319a = new EmptyScopedNullStateTypeaheadUnit(GraphSearchQuery$ScopedEntityType.VIDEO);
    private static volatile VideoScopedNullStateSupplier f9320g;
    private final VideoSearchExperimentHelper f9321b;
    private final Provider<String> f9322c;
    public final ImmutableList<NullStateSupplier> f9323d;
    private final NullStateSupplier$NullStateStatusListener f9324e = new C04291(this);
    public NullStateSupplier$NullStateStatusListener f9325f;

    /* compiled from: list_type */
    class C04291 implements NullStateSupplier$NullStateStatusListener {
        final /* synthetic */ VideoScopedNullStateSupplier f9342a;

        C04291(VideoScopedNullStateSupplier videoScopedNullStateSupplier) {
            this.f9342a = videoScopedNullStateSupplier;
        }

        public final void mo745a(NullStateStatus nullStateStatus) {
            if (this.f9342a.f9325f != null) {
                NullStateStatus nullStateStatus2 = NullStateStatus.READY;
                for (int i = 0; i < this.f9342a.f9323d.size(); i++) {
                    if (NullStateStatus.NOT_READY.equals(((NullStateSupplier) this.f9342a.f9323d.get(i)).c())) {
                        nullStateStatus2 = NullStateStatus.PARTIAL;
                    }
                }
                this.f9342a.f9325f.mo745a(nullStateStatus2);
            }
        }
    }

    public static com.facebook.search.suggestions.nullstate.VideoScopedNullStateSupplier m9696a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9320g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.nullstate.VideoScopedNullStateSupplier.class;
        monitor-enter(r1);
        r0 = f9320g;	 Catch:{ all -> 0x003a }
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
        r0 = m9697b(r0);	 Catch:{ all -> 0x0035 }
        f9320g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9320g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.nullstate.VideoScopedNullStateSupplier.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.nullstate.VideoScopedNullStateSupplier");
    }

    private static VideoScopedNullStateSupplier m9697b(InjectorLike injectorLike) {
        return new VideoScopedNullStateSupplier(VideoSearchExperimentHelper.b(injectorLike), IdBasedProvider.a(injectorLike, 4442), RecentVideoSearchesNullStateSupplier.m9721a(injectorLike));
    }

    public Object get() {
        Builder builder = new Builder();
        builder.c(new GapTypeaheadUnit());
        Object obj = 1;
        int size = this.f9323d.size();
        int i = 0;
        while (i < size) {
            Object obj2;
            NullStateSupplier nullStateSupplier = (NullStateSupplier) this.f9323d.get(i);
            if (!nullStateSupplier.a() || NullStateStatus.NOT_READY.equals(nullStateSupplier.c())) {
                obj2 = null;
            } else {
                builder.b((Iterable) nullStateSupplier.get());
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
        if (obj != null) {
            builder.c(f9319a);
        }
        return builder.b();
    }

    @Inject
    private VideoScopedNullStateSupplier(VideoSearchExperimentHelper videoSearchExperimentHelper, Provider<String> provider, RecentVideoSearchesNullStateSupplier recentVideoSearchesNullStateSupplier) {
        this.f9321b = videoSearchExperimentHelper;
        this.f9322c = provider;
        this.f9323d = ImmutableList.of(recentVideoSearchesNullStateSupplier);
    }

    public final boolean m9704a() {
        return this.f9321b.a();
    }

    public final NullStateStatus m9706c() {
        int size = this.f9323d.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            NullStateSupplier nullStateSupplier = (NullStateSupplier) this.f9323d.get(i);
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

    public final void m9701a(NullStateSupplier$NullStateStatusListener nullStateSupplier$NullStateStatusListener, OnFetchStateChangedListener onFetchStateChangedListener) {
        this.f9325f = nullStateSupplier$NullStateStatusListener;
        int size = this.f9323d.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f9323d.get(i)).a(nullStateSupplier$NullStateStatusListener != null ? this.f9324e : null, onFetchStateChangedListener);
        }
    }

    public void init() {
        if (a() && !Strings.isNullOrEmpty((String) this.f9322c.get())) {
            a(null, NullStateSupplier$RefreshPolicy.MEMORY);
        }
    }

    public final void m9699a(GraphSearchQuery graphSearchQuery) {
        int size = this.f9323d.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f9323d.get(i)).a(graphSearchQuery);
        }
    }

    public final void m9698a(@Nullable CallerContext callerContext, NullStateSupplier$RefreshPolicy nullStateSupplier$RefreshPolicy) {
        int size = this.f9323d.size();
        for (int i = 0; i < size; i++) {
            NullStateSupplier nullStateSupplier = (NullStateSupplier) this.f9323d.get(i);
            if (nullStateSupplier.a() && !(nullStateSupplier$RefreshPolicy == NullStateSupplier$RefreshPolicy.MEMORY && NullStateStatus.READY.equals(nullStateSupplier.c()))) {
                nullStateSupplier.a(callerContext, nullStateSupplier$RefreshPolicy);
            }
        }
    }

    public final void mo748a(FetchState fetchState) {
    }

    public final void mo749a(TypeaheadResponse<TypeaheadUnit> typeaheadResponse) {
    }

    public final void m9700a(Type type) {
        int size = this.f9323d.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f9323d.get(i)).a(type);
        }
    }

    public void clearUserData() {
        b();
    }

    public final void m9705b() {
        int size = this.f9323d.size();
        for (int i = 0; i < size; i++) {
            ((NullStateSupplier) this.f9323d.get(i)).b();
        }
    }
}

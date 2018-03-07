package com.facebook.search.suggestions.loader;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.QueueingListeningExecutorService;
import com.facebook.common.executors.QueueingListeningExecutorService_SearchTypeaheadNetworkExecutorMethodAutoProvider;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.SearchTypeaheadResult;
import com.facebook.search.api.SearchTypeaheadResult.Type;
import com.facebook.search.api.protocol.FetchGraphSearchTypeaheadApiMethod;
import com.facebook.search.api.protocol.FetchSearchTypeaheadResultParams;
import com.facebook.search.api.protocol.FetchSearchTypeaheadResultParams.Builder;
import com.facebook.search.api.protocol.FetchSearchTypeaheadResultParams.KeywordMode;
import com.facebook.search.api.protocol.FetchSimpleSearchTypeaheadApiMethod;
import com.facebook.search.api.protocol.SearchTypeaheadApiMethod;
import com.facebook.search.bootstrap.common.normalizer.NormalizedTokenHelper;
import com.facebook.search.bootstrap.common.phonetic.PhoneticNameToNameConverter;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.KeywordTypeaheadUnit.Source;
import com.facebook.search.model.ShortcutTypeaheadUnit;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.Name;
import com.facebook.user.names.ContactNameLookupBuilder;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: {apiErrorCode= */
public class RemoteTypeaheadLoader {
    private static final ImmutableList<Type> f122k = ImmutableList.of(Type.SHORTCUT, Type.APP, Type.USER, Type.PAGE, Type.GROUP, Type.EVENT);
    private static final ImmutableList<Type> f123l = ImmutableList.of(Type.USER, Type.GROUP, Type.EVENT);
    private static volatile RemoteTypeaheadLoader f124m;
    private final Resources f125a;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<NormalizedTokenHelper> f126b = UltralightRuntime.b;
    public final QueueingListeningExecutorService f127c;
    public final Provider<? extends SearchTypeaheadApiMethod> f128d;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SingleMethodRunner> f129e = UltralightRuntime.b;
    private final boolean f130f;
    private final GraphSearchConfig f131g;
    private final GatekeeperStoreImpl f132h;
    private final QeAccessor f133i;
    private final int f134j;

    public static com.facebook.search.suggestions.loader.RemoteTypeaheadLoader m217a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f124m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.loader.RemoteTypeaheadLoader.class;
        monitor-enter(r1);
        r0 = f124m;	 Catch:{ all -> 0x003a }
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
        r0 = m219b(r0);	 Catch:{ all -> 0x0035 }
        f124m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f124m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.loader.RemoteTypeaheadLoader.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.loader.RemoteTypeaheadLoader");
    }

    private static RemoteTypeaheadLoader m219b(InjectorLike injectorLike) {
        RemoteTypeaheadLoader remoteTypeaheadLoader = new RemoteTypeaheadLoader(ResourcesMethodAutoProvider.a(injectorLike), QueueingListeningExecutorService_SearchTypeaheadNetworkExecutorMethodAutoProvider.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), GraphSearchConfig.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 10454), IdBasedProvider.a(injectorLike, 10453));
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 10457);
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 2289);
        remoteTypeaheadLoader.f126b = a;
        remoteTypeaheadLoader.f129e = b;
        return remoteTypeaheadLoader;
    }

    @Inject
    public RemoteTypeaheadLoader(Resources resources, QueueingListeningExecutorService queueingListeningExecutorService, Boolean bool, GraphSearchConfig graphSearchConfig, GatekeeperStore gatekeeperStore, QeAccessor qeAccessor, Provider<FetchSimpleSearchTypeaheadApiMethod> provider, Provider<FetchGraphSearchTypeaheadApiMethod> provider2) {
        this.f125a = resources;
        this.f127c = queueingListeningExecutorService;
        this.f130f = bool.booleanValue();
        this.f131g = graphSearchConfig;
        this.f132h = gatekeeperStore;
        this.f133i = qeAccessor;
        if (!gatekeeperStore.a(SearchAbTestGatekeepers.f).asBoolean(false)) {
            provider2 = provider;
        }
        this.f128d = provider2;
        this.f134j = this.f125a.getDimensionPixelSize(gatekeeperStore.a(SearchAbTestGatekeepers.g, false) ? 2131427457 : 2131427458);
    }

    public final ListenableFuture<SearchResponse<TypeaheadUnit>> m220a(KeywordMode keywordMode, final GraphSearchQuery graphSearchQuery, int i, String str, String str2) {
        List list;
        if (graphSearchQuery.h == ScopedEntityType.URL) {
            keywordMode = KeywordMode.WEB_VIEW_SINGLE_STATE_MODE;
        } else if (graphSearchQuery.h == ScopedEntityType.VIDEO) {
            keywordMode = KeywordMode.VIDEO_HOME_SEARCH_KEYWORD_ONLY_MODE;
        } else if (this.f131g.e(graphSearchQuery)) {
            keywordMode = KeywordMode.SCOPED;
        } else if (this.f131g.h(graphSearchQuery)) {
            keywordMode = KeywordMode.SINGLE_STATE_MODE;
        } else if (this.f132h.a(SearchAbTestGatekeepers.u, false)) {
            keywordMode = KeywordMode.ENTITY_ONLY_MODE;
        }
        if (keywordMode == KeywordMode.VIDEO_HOME_SEARCH_KEYWORD_ONLY_MODE) {
            i = 6;
        }
        Builder builder = new Builder();
        builder.a = graphSearchQuery;
        builder = builder;
        builder.e = i;
        builder = builder;
        builder.b = str;
        Builder builder2 = builder;
        if (this.f130f) {
            list = f123l;
        } else {
            list = f122k;
        }
        builder2.d = list;
        builder = builder2;
        builder.g = false;
        builder = builder;
        builder.c = this.f134j;
        builder = builder;
        builder.i = keywordMode;
        builder2 = builder;
        if (str2 != null) {
            builder2.h = str2;
        }
        if (this.f132h.a(SearchAbTestGatekeepers.j, false)) {
            builder2.j = keywordMode == KeywordMode.DEFAULT_KEYWORD_MODE ? this.f133i.a(ExperimentsForSearchAbTestModule.L, "kw_first_3andgrow_usergroup") : "kw_first_3andgrow_usergroup";
        }
        final FetchSearchTypeaheadResultParams a = builder2.a();
        return Futures.a(this.f127c.a(new Callable<SearchResponse<SearchTypeaheadResult>>(this) {
            final /* synthetic */ RemoteTypeaheadLoader f118b;

            public Object call() {
                return (SearchResponse) ((AbstractSingleMethodRunner) this.f118b.f129e.get()).a((ApiMethod) this.f118b.f128d.get(), a);
            }
        }), new Function<SearchResponse<SearchTypeaheadResult>, SearchResponse<TypeaheadUnit>>(this) {
            final /* synthetic */ RemoteTypeaheadLoader f121c;

            public Object apply(@Nullable Object obj) {
                SearchResponse searchResponse = (SearchResponse) obj;
                if (searchResponse == null) {
                    return new SearchResponse(RegularImmutableList.a);
                }
                int i;
                LinkedHashMap d = Maps.d();
                ImmutableList immutableList = searchResponse.b;
                int size = immutableList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Object obj2;
                    Object obj3;
                    SearchTypeaheadResult searchTypeaheadResult = (SearchTypeaheadResult) immutableList.get(i2);
                    Integer valueOf = Integer.valueOf(searchTypeaheadResult.a());
                    Integer num;
                    switch (valueOf.intValue()) {
                        case 811944494:
                            ShortcutTypeaheadUnit b = RemoteTypeaheadLoader.m218b(searchTypeaheadResult);
                            num = valueOf;
                            ShortcutTypeaheadUnit shortcutTypeaheadUnit = b;
                            break;
                        case 907720311:
                            KeywordTypeaheadUnit a = RemoteTypeaheadLoader.m216a(this.f121c, graphSearchQuery, keywordMode, searchTypeaheadResult);
                            num = valueOf;
                            KeywordTypeaheadUnit keywordTypeaheadUnit = a;
                            break;
                        default:
                            valueOf = Integer.valueOf(0);
                            EntityTypeaheadUnit a2 = RemoteTypeaheadLoader.m214a(this.f121c, graphSearchQuery, searchTypeaheadResult);
                            obj2 = valueOf;
                            obj3 = a2;
                            break;
                    }
                    if (!d.containsKey(obj2)) {
                        d.put(obj2, new ImmutableList.Builder());
                    }
                    ((ImmutableList.Builder) d.get(obj2)).c(obj3);
                }
                ImmutableList.Builder builder = ImmutableList.builder();
                for (Object obj22 : d.keySet()) {
                    builder.b(((ImmutableList.Builder) d.get(obj22)).b());
                }
                if (keywordMode != KeywordMode.KEYWORD_ONLY_MODE) {
                    i = searchResponse.c;
                } else {
                    i = 0;
                }
                return new SearchResponse(builder.b(), i);
            }
        }, MoreExecutors.a());
    }

    public static ShortcutTypeaheadUnit m218b(SearchTypeaheadResult searchTypeaheadResult) {
        ShortcutTypeaheadUnit.Builder builder = new ShortcutTypeaheadUnit.Builder();
        builder.a = String.valueOf(searchTypeaheadResult.m);
        builder = builder;
        builder.b = searchTypeaheadResult.k;
        builder = builder;
        builder.c = new GraphQLObjectType(searchTypeaheadResult.a());
        builder = builder;
        builder.d = searchTypeaheadResult.f;
        builder = builder;
        builder.e = searchTypeaheadResult.g;
        builder = builder;
        builder.f = searchTypeaheadResult.a;
        builder = builder;
        builder.g = searchTypeaheadResult.e;
        builder = builder;
        builder.h = searchTypeaheadResult.b;
        return builder.i();
    }

    public static KeywordTypeaheadUnit m216a(RemoteTypeaheadLoader remoteTypeaheadLoader, GraphSearchQuery graphSearchQuery, KeywordMode keywordMode, SearchTypeaheadResult searchTypeaheadResult) {
        Source source;
        KeywordTypeaheadUnit.Builder builder = new KeywordTypeaheadUnit.Builder();
        builder.b = searchTypeaheadResult.k;
        builder = builder;
        builder.c = searchTypeaheadResult.s;
        builder = builder;
        builder.d = searchTypeaheadResult.k;
        builder = builder;
        builder.e = "content";
        KeywordTypeaheadUnit.Builder builder2 = builder;
        if (Strings.isNullOrEmpty(graphSearchQuery.f)) {
            source = Source.SUGGESTION;
        } else {
            source = Source.SINGLE_STATE;
        }
        builder2.k = source;
        builder = builder2;
        builder.l = keywordMode.getValue();
        builder = builder;
        builder.r = searchTypeaheadResult.g;
        builder = builder;
        builder.s = searchTypeaheadResult.h;
        builder = builder;
        builder.v = GraphSearchConfig.a(graphSearchQuery);
        builder = builder;
        builder.h = searchTypeaheadResult.j;
        builder = builder;
        builder.y = searchTypeaheadResult.u;
        builder = builder;
        builder.z = searchTypeaheadResult.v;
        builder = builder;
        builder.A = searchTypeaheadResult.w;
        builder2 = builder;
        if (searchTypeaheadResult.i != null) {
            builder2.g = m215a(searchTypeaheadResult.i);
        }
        if (!remoteTypeaheadLoader.f131g.e(graphSearchQuery)) {
            return builder2.b();
        }
        Object obj;
        if (graphSearchQuery.h == ScopedEntityType.VIDEO) {
            obj = 1;
        } else {
            obj = null;
        }
        if (searchTypeaheadResult.p || r0 != null) {
            builder2.a(graphSearchQuery.f, graphSearchQuery.g, graphSearchQuery.h);
            builder2.v = GraphSearchConfig.a(graphSearchQuery);
            builder2.w = graphSearchQuery.k;
        } else {
            builder2.o = true;
            KeywordTypeaheadUnit.Builder builder3 = builder2;
        }
        return builder2.b();
    }

    public static EntityTypeaheadUnit m214a(RemoteTypeaheadLoader remoteTypeaheadLoader, GraphSearchQuery graphSearchQuery, SearchTypeaheadResult searchTypeaheadResult) {
        ImmutableList immutableList;
        boolean z;
        EntityTypeaheadUnit.Builder builder = new EntityTypeaheadUnit.Builder();
        builder.a = searchTypeaheadResult.k;
        builder = builder;
        builder.d = searchTypeaheadResult.f;
        builder = builder;
        builder.b = String.valueOf(searchTypeaheadResult.m);
        builder = builder.a(searchTypeaheadResult.a());
        builder.e = searchTypeaheadResult.g;
        builder = builder;
        builder.f = searchTypeaheadResult.a;
        EntityTypeaheadUnit.Builder builder2 = builder;
        NormalizedTokenHelper normalizedTokenHelper = (NormalizedTokenHelper) remoteTypeaheadLoader.f126b.get();
        String str = searchTypeaheadResult.k;
        ImmutableList immutableList2 = searchTypeaheadResult.r;
        int a = searchTypeaheadResult.a();
        ImmutableList a2 = normalizedTokenHelper.c.a(str);
        if (2645995 != a) {
            immutableList = a2;
        } else {
            ContactNameLookupBuilder contactNameLookupBuilder = (ContactNameLookupBuilder) normalizedTokenHelper.a.get();
            contactNameLookupBuilder.i = false;
            if (str != null) {
                contactNameLookupBuilder.a(new Name(str));
            }
            if (null != null) {
                contactNameLookupBuilder.a(PhoneticNameToNameConverter.a(null));
            }
            if (immutableList2 != null) {
                contactNameLookupBuilder.a(immutableList2);
            }
            ImmutableSet.Builder builder3 = ImmutableSet.builder();
            builder3.b(a2);
            builder3.b(contactNameLookupBuilder.f);
            immutableList = ImmutableList.copyOf(builder3.b());
        }
        builder2.k = immutableList;
        builder = builder2;
        builder.g = searchTypeaheadResult.n;
        builder = builder;
        builder.h = searchTypeaheadResult.o;
        builder2 = builder;
        if (remoteTypeaheadLoader.f131g.e(graphSearchQuery) && graphSearchQuery.h == ScopedEntityType.VIDEO) {
            z = true;
        } else {
            z = false;
        }
        builder2.m = z;
        builder = builder2;
        builder.o = searchTypeaheadResult.w;
        return builder.p();
    }

    private static KeywordType m215a(String str) {
        try {
            return KeywordType.valueOf(str);
        } catch (IllegalArgumentException e) {
            return KeywordType.keyword;
        }
    }
}

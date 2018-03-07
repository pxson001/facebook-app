package com.facebook.search.suggestions.simplesearch;

import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.bootstrap.db.DbBootstrapPerformanceLogger;
import com.facebook.search.bootstrap.db.model.BootstrapDbModel;
import com.facebook.search.bootstrap.db.model.EntityDbModel;
import com.facebook.search.bootstrap.db.model.KeywordDbModel;
import com.facebook.search.bootstrap.db.resolvers.BootstrapSuggestionResolver;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.KeywordTypeaheadUnit.Source;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: voip_shortcut_nux */
public class LocalTypeaheadLoader {
    private static volatile LocalTypeaheadLoader f260e;
    public final BootstrapSuggestionResolver f261a;
    public final DbBootstrapPerformanceLogger f262b;
    public final QeAccessor f263c;
    public final GatekeeperStoreImpl f264d;

    /* compiled from: voip_shortcut_nux */
    public class C00311 implements Function<ImmutableList<BootstrapDbModel>, SearchResponse<TypeaheadUnit>> {
        final /* synthetic */ TypeaheadRequest f257a;
        final /* synthetic */ LocalTypeaheadLoader f258b;

        public C00311(LocalTypeaheadLoader localTypeaheadLoader, TypeaheadRequest typeaheadRequest) {
            this.f258b = localTypeaheadLoader;
            this.f257a = typeaheadRequest;
        }

        public Object apply(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            Builder builder = ImmutableList.builder();
            GraphSearchQuery graphSearchQuery = this.f257a instanceof GraphSearchQuery ? (GraphSearchQuery) this.f257a : null;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                BootstrapDbModel bootstrapDbModel = (BootstrapDbModel) immutableList.get(i);
                if (bootstrapDbModel instanceof KeywordDbModel) {
                    String o;
                    KeywordDbModel keywordDbModel = (KeywordDbModel) bootstrapDbModel;
                    KeywordTypeaheadUnit.Builder builder2 = new KeywordTypeaheadUnit.Builder();
                    builder2.b = keywordDbModel.b;
                    builder2 = builder2;
                    builder2.d = keywordDbModel.b;
                    KeywordTypeaheadUnit.Builder builder3 = builder2;
                    if (StringUtil.a(keywordDbModel.a)) {
                        o = SearchQueryFunctions.o(keywordDbModel.b);
                    } else {
                        o = keywordDbModel.a;
                    }
                    builder3.c = o;
                    builder2 = builder3;
                    builder2.e = "content";
                    builder2 = builder2;
                    builder2.g = LocalTypeaheadLoader.m379b(keywordDbModel.d);
                    builder2 = builder2;
                    builder2.k = Source.BOOTSTRAP;
                    builder2 = builder2;
                    builder2.m = true;
                    builder2 = builder2;
                    builder2.r = keywordDbModel.c;
                    builder2 = builder2;
                    builder2.s = keywordDbModel.b;
                    builder2 = builder2;
                    builder2.h = keywordDbModel.c;
                    KeywordTypeaheadUnit.Builder builder4 = builder2;
                    builder4.v = GraphSearchConfig.a(graphSearchQuery);
                    builder.c(builder4.b());
                } else {
                    EntityDbModel entityDbModel = (EntityDbModel) bootstrapDbModel;
                    EntityTypeaheadUnit.Builder builder5 = new EntityTypeaheadUnit.Builder();
                    builder5.b = entityDbModel.a;
                    builder5 = builder5;
                    builder5.a = entityDbModel.b;
                    builder5 = builder5;
                    builder5.f = entityDbModel.a;
                    builder5 = builder5;
                    builder5.e = entityDbModel.c;
                    builder5 = builder5;
                    builder5.d = Uri.parse(entityDbModel.b);
                    builder5 = builder5;
                    builder5.c = new GraphQLObjectType(entityDbModel.d);
                    builder5 = builder5;
                    builder5.i = entityDbModel.c;
                    builder5 = builder5;
                    builder5.j = true;
                    builder5 = builder5;
                    builder5.g = entityDbModel.d;
                    builder5 = builder5;
                    builder5.l = entityDbModel.e;
                    builder.c(builder5.p());
                }
            }
            ImmutableList b = builder.b();
            this.f258b.f262b.b(this.f257a);
            return new SearchResponse(b);
        }
    }

    /* compiled from: voip_shortcut_nux */
    public class C00322 implements Function<List<EntityDbModel>, ImmutableList<BootstrapDbModel>> {
        final /* synthetic */ LocalTypeaheadLoader f259a;

        public C00322(LocalTypeaheadLoader localTypeaheadLoader) {
            this.f259a = localTypeaheadLoader;
        }

        public Object apply(Object obj) {
            return ImmutableList.builder().b((List) obj).b();
        }
    }

    public static com.facebook.search.suggestions.simplesearch.LocalTypeaheadLoader m378a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f260e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.simplesearch.LocalTypeaheadLoader.class;
        monitor-enter(r1);
        r0 = f260e;	 Catch:{ all -> 0x003a }
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
        r0 = m380b(r0);	 Catch:{ all -> 0x0035 }
        f260e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f260e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.simplesearch.LocalTypeaheadLoader.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.simplesearch.LocalTypeaheadLoader");
    }

    private static LocalTypeaheadLoader m380b(InjectorLike injectorLike) {
        return new LocalTypeaheadLoader(BootstrapSuggestionResolver.b(injectorLike), DbBootstrapPerformanceLogger.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LocalTypeaheadLoader(BootstrapSuggestionResolver bootstrapSuggestionResolver, DbBootstrapPerformanceLogger dbBootstrapPerformanceLogger, QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f261a = bootstrapSuggestionResolver;
        this.f262b = dbBootstrapPerformanceLogger;
        this.f263c = qeAccessor;
        this.f264d = gatekeeperStoreImpl;
    }

    public static KeywordType m379b(String str) {
        try {
            return KeywordType.valueOf(str);
        } catch (IllegalArgumentException e) {
            return KeywordType.keyword;
        }
    }
}

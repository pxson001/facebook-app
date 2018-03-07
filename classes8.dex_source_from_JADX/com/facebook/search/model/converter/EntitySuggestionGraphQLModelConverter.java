package com.facebook.search.model.converter;

import android.net.Uri;
import com.facebook.inject.InjectorLike;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.EntityTypeaheadUnit.Builder;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLModels.FB4AGraphSearchUserWithFiltersQueryModel.FilteredQueryModel.ResultsModel;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQLModels.FetchSimpleSearchEntitiesQueryModel.SearchResultsModel.EdgesModel;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQLModels.FetchSimpleSearchEntitiesQueryModel.SearchResultsModel.EdgesModel.NodeModel;
import com.facebook.search.protocol.SnippetsUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: THANK_YOU */
public class EntitySuggestionGraphQLModelConverter {
    private static volatile EntitySuggestionGraphQLModelConverter f22319b;
    private final SnippetsUtil f22320a;

    public static com.facebook.search.model.converter.EntitySuggestionGraphQLModelConverter m25799a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22319b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.model.converter.EntitySuggestionGraphQLModelConverter.class;
        monitor-enter(r1);
        r0 = f22319b;	 Catch:{ all -> 0x003a }
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
        r0 = m25800b(r0);	 Catch:{ all -> 0x0035 }
        f22319b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22319b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.model.converter.EntitySuggestionGraphQLModelConverter.a(com.facebook.inject.InjectorLike):com.facebook.search.model.converter.EntitySuggestionGraphQLModelConverter");
    }

    private static EntitySuggestionGraphQLModelConverter m25800b(InjectorLike injectorLike) {
        return new EntitySuggestionGraphQLModelConverter(SnippetsUtil.m8990a(injectorLike));
    }

    @Inject
    public EntitySuggestionGraphQLModelConverter(SnippetsUtil snippetsUtil) {
        this.f22320a = snippetsUtil;
    }

    public static EntityTypeaheadUnit m25798a(EdgesModel edgesModel) {
        Preconditions.checkNotNull(edgesModel);
        Preconditions.checkNotNull(edgesModel.m8815b());
        Preconditions.checkNotNull(edgesModel.m8815b().m8806b());
        NodeModel b = edgesModel.m8815b();
        String d = b.m8808d();
        int g = b.m8806b().g();
        String g2 = b.m8809g();
        if (Strings.isNullOrEmpty(d)) {
            throw new GraphSearchException(GraphSearchError.BAD_SUGGESTION, "Missing id for entity of type " + g);
        } else if (Strings.isNullOrEmpty(edgesModel.m8815b().m8809g())) {
            throw new GraphSearchException(GraphSearchError.BAD_SUGGESTION, "Missing name for entity with type " + g + ", id " + d);
        } else {
            Builder builder = new Builder();
            builder.f22031b = d;
            Builder a = builder.m25604a(g);
            a.f22030a = g2;
            a = a;
            a.f22035f = edgesModel.m8814a();
            a = a;
            a.f22034e = edgesModel.m8816c();
            a = a;
            a.f22036g = b.jD_();
            a = a;
            if (b.m8806b().g() == 69076575 && b.m8807c() != null) {
                a.f22033d = Uri.parse(edgesModel.m8815b().m8807c().m8796a());
            } else if (b.jE_() != null) {
                a.f22033d = Uri.parse(edgesModel.m8815b().jE_().b());
            }
            return a.m25606p();
        }
    }

    public final EntityTypeaheadUnit m25801a(ResultsModel.EdgesModel edgesModel) {
        String str = null;
        Preconditions.checkNotNull(edgesModel);
        Preconditions.checkNotNull(edgesModel.m8403a());
        Preconditions.checkNotNull(edgesModel.m8403a().m8394b());
        ResultsModel.EdgesModel.NodeModel a = edgesModel.m8403a();
        String d = a.m8396d();
        int g = a.m8394b().g();
        String g2 = a.m8397g();
        if (Strings.isNullOrEmpty(d)) {
            throw new GraphSearchException(GraphSearchError.BAD_SUGGESTION, "Missing id for entity of type " + g);
        } else if (Strings.isNullOrEmpty(g2)) {
            throw new GraphSearchException(GraphSearchError.BAD_SUGGESTION, "Missing name for entity with type " + g + ", id " + d);
        } else {
            String str2;
            if (edgesModel.m8404b() != null) {
                ImmutableList a2 = this.f22320a.m8991a(edgesModel.m8404b());
                if (a2.size() > 0) {
                    str2 = (String) a2.get(0);
                } else {
                    str2 = null;
                }
                if (a2.size() > 1) {
                    str = (String) a2.get(1);
                }
            } else {
                str2 = null;
            }
            Builder builder = new Builder();
            builder.f22031b = d;
            builder = builder.m25604a(g);
            builder.f22030a = g2;
            builder = builder;
            builder.f22035f = str2;
            builder = builder;
            builder.f22034e = str;
            builder = builder;
            builder.f22036g = a.jv_();
            builder = builder;
            if (a.m8394b().g() == 69076575 && a.m8395c() != null) {
                builder.f22033d = Uri.parse(edgesModel.m8403a().m8395c().m8381a());
            } else if (a.jw_() != null) {
                builder.f22033d = Uri.parse(edgesModel.m8403a().jw_().b());
            }
            return builder.m25606p();
        }
    }
}

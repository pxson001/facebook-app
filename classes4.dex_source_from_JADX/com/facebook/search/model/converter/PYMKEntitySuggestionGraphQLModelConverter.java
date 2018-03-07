package com.facebook.search.model.converter;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.inject.InjectorLike;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit.Builder;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.protocol.FetchTypeaheadPYMKGraphQLModels.FBTypeaheadPYMKQueryModel.PeopleYouMayKnowModel.NodesModel;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: listener */
public class PYMKEntitySuggestionGraphQLModelConverter {
    private static volatile PYMKEntitySuggestionGraphQLModelConverter f9317b;
    private final GraphSearchErrorReporter f9318a;

    public static com.facebook.search.model.converter.PYMKEntitySuggestionGraphQLModelConverter m9693a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9317b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.model.converter.PYMKEntitySuggestionGraphQLModelConverter.class;
        monitor-enter(r1);
        r0 = f9317b;	 Catch:{ all -> 0x003a }
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
        r0 = m9694b(r0);	 Catch:{ all -> 0x0035 }
        f9317b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9317b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.model.converter.PYMKEntitySuggestionGraphQLModelConverter.a(com.facebook.inject.InjectorLike):com.facebook.search.model.converter.PYMKEntitySuggestionGraphQLModelConverter");
    }

    private static PYMKEntitySuggestionGraphQLModelConverter m9694b(InjectorLike injectorLike) {
        return new PYMKEntitySuggestionGraphQLModelConverter(GraphSearchErrorReporter.a(injectorLike));
    }

    @Inject
    public PYMKEntitySuggestionGraphQLModelConverter(GraphSearchErrorReporter graphSearchErrorReporter) {
        this.f9318a = graphSearchErrorReporter;
    }

    private static NullStateSuggestionTypeaheadUnit m9692a(NodesModel nodesModel) {
        Preconditions.checkNotNull(nodesModel);
        Preconditions.checkNotNull(Integer.valueOf(nodesModel.jK_()));
        String j = nodesModel.j();
        if (Strings.isNullOrEmpty(j)) {
            throw new GraphSearchException(GraphSearchError.BAD_SUGGESTION, "Missing id for user");
        } else if (Strings.isNullOrEmpty(nodesModel.k())) {
            throw new GraphSearchException(GraphSearchError.BAD_SUGGESTION, "Missing name for user with id " + j);
        } else {
            Builder builder = new Builder();
            builder.b = j;
            Builder builder2 = builder;
            builder2.c = new GraphQLObjectType(nodesModel.jK_());
            builder2 = builder2;
            builder2.a = nodesModel.k();
            builder2 = builder2;
            if (nodesModel.l() != null) {
                builder2.e = Uri.parse(nodesModel.l().m2094b());
            }
            builder2.d = false;
            return builder2.j();
        }
    }

    public final ImmutableList<TypeaheadUnit> m9695a(@Nullable ImmutableList<NodesModel> immutableList) {
        if (immutableList == null) {
            return ImmutableList.of();
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            try {
                builder.c(m9692a((NodesModel) immutableList.get(i)));
            } catch (GraphSearchException e) {
                this.f9318a.a(e);
            }
        }
        return builder.b();
    }
}

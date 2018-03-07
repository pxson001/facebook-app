package com.facebook.search.model.converter;

import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.FilterInputMode;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels$DefaultImageFieldsModel;
import com.facebook.inject.InjectorLike;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit.Builder;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLModels.FBRecentSearchesQueryModel.RecentSearchesModel.EdgesModel;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLModels.FBRecentSearchesQueryModel.RecentSearchesModel.EdgesModel.NodeModel;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLModels.FBRecentSearchesQueryModel.RecentSearchesModel.EdgesModel.NodeModel.GroupIconModel;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLModels.FBRecentSearchesQueryModel.RecentSearchesModel.EdgesModel.NodeModel.GroupIconModel.DarkIconModel;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: loadAdminedPagesParam */
public class RecentSearchSuggestionGraphQLModelConverter {
    private static volatile RecentSearchSuggestionGraphQLModelConverter f9248c;
    private final GraphSearchErrorReporter f9249a;
    private final AbstractFbErrorReporter f9250b;

    public static com.facebook.search.model.converter.RecentSearchSuggestionGraphQLModelConverter m9608a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9248c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.model.converter.RecentSearchSuggestionGraphQLModelConverter.class;
        monitor-enter(r1);
        r0 = f9248c;	 Catch:{ all -> 0x003a }
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
        r0 = m9610b(r0);	 Catch:{ all -> 0x0035 }
        f9248c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9248c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.model.converter.RecentSearchSuggestionGraphQLModelConverter.a(com.facebook.inject.InjectorLike):com.facebook.search.model.converter.RecentSearchSuggestionGraphQLModelConverter");
    }

    private static RecentSearchSuggestionGraphQLModelConverter m9610b(InjectorLike injectorLike) {
        return new RecentSearchSuggestionGraphQLModelConverter(GraphSearchErrorReporter.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public RecentSearchSuggestionGraphQLModelConverter(GraphSearchErrorReporter graphSearchErrorReporter, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9249a = graphSearchErrorReporter;
        this.f9250b = abstractFbErrorReporter;
    }

    @Nullable
    private static NullStateSuggestionTypeaheadUnit m9607a(EdgesModel edgesModel, FilterInputMode filterInputMode) {
        if (edgesModel == null || edgesModel.m12342a() == null) {
            return null;
        }
        String o = edgesModel.m12342a().o();
        int g = edgesModel.m12342a().j().g();
        if (Strings.isNullOrEmpty(o)) {
            Object obj;
            if (g == -466486798 || g == 907720311) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                throw new GraphSearchException(GraphSearchError.BAD_SUGGESTION, "Missing id for recent search of type " + g);
            }
        }
        Builder builder = new Builder();
        builder.b = o;
        Builder builder2 = builder;
        builder2.a = edgesModel.m12342a().p();
        builder2 = builder2;
        builder2.c = edgesModel.m12342a().j();
        builder = builder2;
        if (g == 811944494) {
            if (Strings.isNullOrEmpty(edgesModel.m12342a().q())) {
                throw new GraphSearchException(GraphSearchError.BAD_SUGGESTION, "Missing path for shortcut: " + edgesModel.m12342a().o());
            } else if (Strings.isNullOrEmpty(edgesModel.m12342a().l())) {
                throw new GraphSearchException(GraphSearchError.BAD_SUGGESTION, "Missing fallback_path for shortcut: " + edgesModel.m12342a().o());
            } else {
                builder.f = Uri.parse(edgesModel.m12342a().q());
                builder.g = Uri.parse(edgesModel.m12342a().l());
                builder.e = Uri.parse(edgesModel.m12342a().n());
            }
        } else if (g == 69076575) {
            builder.e = Uri.parse(edgesModel.m12342a().k() != null ? edgesModel.m12342a().k().a().a().a() : edgesModel.m12342a().m().a().a());
        } else if (edgesModel.m12342a().r() != null) {
            builder.e = Uri.parse(edgesModel.m12342a().r().m2094b());
        }
        builder.i = edgesModel.m12342a().s();
        builder.d = true;
        if (filterInputMode == FilterInputMode.VIDEO_SEARCH) {
            builder.k = ImmutableList.of(GraphQLGraphSearchResultsDisplayStyle.BLENDED_VIDEOS);
        }
        return builder.j();
    }

    public static EdgesModel m9609a(NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit) {
        String str;
        int g = nullStateSuggestionTypeaheadUnit.c.g();
        NodeModel.Builder builder = new NodeModel.Builder();
        builder.f = nullStateSuggestionTypeaheadUnit.a;
        builder = builder;
        builder.g = nullStateSuggestionTypeaheadUnit.b;
        builder = builder;
        builder.a = nullStateSuggestionTypeaheadUnit.c;
        NodeModel.Builder builder2 = builder;
        if (nullStateSuggestionTypeaheadUnit.e == null) {
            str = null;
        } else {
            str = nullStateSuggestionTypeaheadUnit.e.toString();
        }
        if (str != null) {
            if (g == 811944494) {
                builder2.e = str;
                if (nullStateSuggestionTypeaheadUnit.f != null) {
                    builder2.h = nullStateSuggestionTypeaheadUnit.f.toString();
                }
            } else if (g == 69076575) {
                GroupIconModel.Builder builder3 = new GroupIconModel.Builder();
                DarkIconModel.Builder builder4 = new DarkIconModel.Builder();
                builder4.a = str;
                builder3.a = builder4.a();
                builder2.d = builder3.a();
            } else {
                CommonGraphQLModels$DefaultImageFieldsModel.Builder builder5 = new CommonGraphQLModels$DefaultImageFieldsModel.Builder();
                builder5.b = str;
                builder2.j = builder5.a();
            }
        }
        EdgesModel.Builder builder6 = new EdgesModel.Builder();
        builder6.a = builder2.a();
        builder6 = builder6;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, builder6.a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public final ImmutableList<TypeaheadUnit> m9611a(ImmutableList<EdgesModel> immutableList, FilterInputMode filterInputMode) {
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            try {
                NullStateSuggestionTypeaheadUnit a = m9607a((EdgesModel) immutableList.get(i), filterInputMode);
                if (a == null) {
                    this.f9250b.a(SoftError.m4758a(GraphSearchError.FETCH_NULL_STATE_RECENT_SEARCHES_FAIL.name(), "Edge or node is null in one of the recent search results").m4763a(true).m4765g());
                } else {
                    builder.c(a);
                }
            } catch (GraphSearchException e) {
                this.f9249a.a(e);
            }
        }
        return builder.b();
    }
}

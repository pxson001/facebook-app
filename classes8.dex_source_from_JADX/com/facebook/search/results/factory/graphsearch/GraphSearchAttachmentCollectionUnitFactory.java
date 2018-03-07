package com.facebook.search.results.factory.graphsearch;

import com.facebook.feed.rows.sections.attachments.ui.MultistoryCollageLayoutProperties;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLNodeConversionHelper;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment.Results;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.ModuleResultEdgeModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: SUBTITLES */
public class GraphSearchAttachmentCollectionUnitFactory extends GraphSearchBaseCollectionUnitFactory<GraphQLStoryAttachment> {
    private static final GraphQLObjectType f22730a = new GraphQLObjectType(-1267730472);
    private static volatile GraphSearchAttachmentCollectionUnitFactory f22731b;

    public static com.facebook.search.results.factory.graphsearch.GraphSearchAttachmentCollectionUnitFactory m26291a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f22731b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.results.factory.graphsearch.GraphSearchAttachmentCollectionUnitFactory.class;
        monitor-enter(r1);
        r0 = f22731b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m26292b();	 Catch:{ all -> 0x0034 }
        f22731b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f22731b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.factory.graphsearch.GraphSearchAttachmentCollectionUnitFactory.a(com.facebook.inject.InjectorLike):com.facebook.search.results.factory.graphsearch.GraphSearchAttachmentCollectionUnitFactory");
    }

    private static GraphSearchAttachmentCollectionUnitFactory m26292b() {
        return new GraphSearchAttachmentCollectionUnitFactory();
    }

    @Nullable
    protected final String mo1264c(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
        return graphQLStoryAttachment.r() != null ? graphQLStoryAttachment.r().b() : null;
    }

    protected final ImmutableList<GraphQLStoryAttachment> mo1262a(Results results, @Nullable String str) {
        Builder builder = new Builder();
        ImmutableList a = results.m8515a();
        int size = a.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Object obj;
            int i3;
            ModuleResultEdgeModel moduleResultEdgeModel = (ModuleResultEdgeModel) a.get(i);
            if (moduleResultEdgeModel.m8668b() != null) {
                GraphQLStory a2 = GraphQLNodeConversionHelper.a(moduleResultEdgeModel.m8668b());
                Object o = a2 != null ? StoryAttachmentHelper.o(a2) : null;
                if (o == null) {
                    o = null;
                } else {
                    if (!(o.x() == null || o.x().isEmpty())) {
                        o = (GraphQLStoryAttachment) o.x().get(0);
                    }
                    if (!MultistoryCollageLayoutProperties.a.apply(o)) {
                        o = null;
                    }
                }
                obj = o;
            } else {
                obj = null;
            }
            if (obj != null) {
                i3 = i2 + 1;
                builder.c(obj);
            } else {
                i3 = i2;
            }
            if (i3 == 5) {
                break;
            }
            i++;
            i2 = i3;
        }
        return builder.b();
    }

    @Nullable
    protected final GraphQLObjectType mo1263b(@Nullable Object obj) {
        return f22730a;
    }
}

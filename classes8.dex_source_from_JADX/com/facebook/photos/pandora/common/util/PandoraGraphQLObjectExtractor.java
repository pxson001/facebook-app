package com.facebook.photos.pandora.common.util;

import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.facebook.prefetch.feed.scheduler.NewsFeedPrefetchBroadcastReceiver.INITIATE_BACKGROUND_FETCH */
public class PandoraGraphQLObjectExtractor {
    private static volatile PandoraGraphQLObjectExtractor f17574a;

    public static com.facebook.photos.pandora.common.util.PandoraGraphQLObjectExtractor m21542a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f17574a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.photos.pandora.common.util.PandoraGraphQLObjectExtractor.class;
        monitor-enter(r1);
        r0 = f17574a;	 Catch:{ all -> 0x0039 }
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
        r0 = m21541a();	 Catch:{ all -> 0x0034 }
        f17574a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f17574a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.pandora.common.util.PandoraGraphQLObjectExtractor.a(com.facebook.inject.InjectorLike):com.facebook.photos.pandora.common.util.PandoraGraphQLObjectExtractor");
    }

    private static PandoraGraphQLObjectExtractor m21541a() {
        return new PandoraGraphQLObjectExtractor();
    }

    public final GraphQLPhoto m21545a(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment c = m21543c(graphQLStory);
        if (c == null || c.r() == null) {
            return null;
        }
        return GraphQLMediaConversionHelper.a(c.r());
    }

    public final ImmutableList<GraphQLPhoto> m21546b(GraphQLStory graphQLStory) {
        List<GraphQLStoryAttachment> d = m21544d(graphQLStory);
        if (d == null || d.isEmpty()) {
            return null;
        }
        Builder builder = new Builder();
        for (GraphQLStoryAttachment graphQLStoryAttachment : d) {
            if (!(graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r() == null)) {
                builder.c(GraphQLMediaConversionHelper.a(graphQLStoryAttachment.r()));
            }
        }
        return builder.b();
    }

    @VisibleForTesting
    private GraphQLStoryAttachment m21543c(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return null;
        }
        if (graphQLStory.M() != null && !graphQLStory.M().isEmpty() && ((GraphQLStoryAttachment) graphQLStory.M().get(0)).r() != null) {
            return (GraphQLStoryAttachment) graphQLStory.M().get(0);
        }
        if (graphQLStory.M() == null || graphQLStory.M().isEmpty() || ((GraphQLStoryAttachment) graphQLStory.M().get(0)).x() == null || ((GraphQLStoryAttachment) graphQLStory.M().get(0)).x().isEmpty() || ((GraphQLStoryAttachment) graphQLStory.M().get(0)).x().get(0) == null || ((GraphQLStoryAttachment) ((GraphQLStoryAttachment) graphQLStory.M().get(0)).x().get(0)).r() == null) {
            return m21543c(graphQLStory.L());
        }
        return (GraphQLStoryAttachment) ((GraphQLStoryAttachment) graphQLStory.M().get(0)).x().get(0);
    }

    @VisibleForTesting
    private List<GraphQLStoryAttachment> m21544d(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return null;
        }
        if (StoryAttachmentHelper.h(graphQLStory)) {
            return StoryAttachmentHelper.i(graphQLStory);
        }
        return m21544d(graphQLStory.L());
    }
}

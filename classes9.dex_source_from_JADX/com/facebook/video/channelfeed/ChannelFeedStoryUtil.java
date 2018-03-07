package com.facebook.video.channelfeed;

import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: surge_confirmation_id */
public class ChannelFeedStoryUtil {
    private static volatile ChannelFeedStoryUtil f2510b;
    private final GraphQLStoryUtil f2511a;

    /* compiled from: surge_confirmation_id */
    class C02281 implements Function<GraphQLStory, Boolean> {
        final /* synthetic */ ChannelFeedStoryUtil f2509a;

        C02281(ChannelFeedStoryUtil channelFeedStoryUtil) {
            this.f2509a = channelFeedStoryUtil;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLStory graphQLStory = (GraphQLStory) obj;
            Preconditions.checkNotNull(graphQLStory);
            GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
            boolean z = (o == null || o.r() == null || o.r().b() == null || o.r().j() == null || o.r().j().g() != 82650203) ? false : true;
            return Boolean.valueOf(z);
        }
    }

    public static com.facebook.video.channelfeed.ChannelFeedStoryUtil m2436a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2510b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.channelfeed.ChannelFeedStoryUtil.class;
        monitor-enter(r1);
        r0 = f2510b;	 Catch:{ all -> 0x003a }
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
        r0 = m2437b(r0);	 Catch:{ all -> 0x0035 }
        f2510b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2510b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.channelfeed.ChannelFeedStoryUtil.a(com.facebook.inject.InjectorLike):com.facebook.video.channelfeed.ChannelFeedStoryUtil");
    }

    private static ChannelFeedStoryUtil m2437b(InjectorLike injectorLike) {
        return new ChannelFeedStoryUtil(GraphQLStoryUtil.a(injectorLike));
    }

    @Inject
    public ChannelFeedStoryUtil(GraphQLStoryUtil graphQLStoryUtil) {
        this.f2511a = graphQLStoryUtil;
    }

    @Nullable
    private GraphQLStory m2438d(GraphQLStory graphQLStory) {
        Preconditions.checkNotNull(graphQLStory);
        C02281 c02281 = new C02281(this);
        Preconditions.checkNotNull(graphQLStory);
        Preconditions.checkNotNull(c02281);
        GraphQLStory graphQLStory2 = graphQLStory;
        while (graphQLStory2 != null) {
            if (Boolean.TRUE.equals(c02281.apply(graphQLStory2))) {
                break;
            }
            graphQLStory2 = graphQLStory2.L();
        }
        graphQLStory2 = null;
        return graphQLStory2;
    }

    @Nullable
    public final String m2439a(GraphQLStory graphQLStory) {
        GraphQLStory d = m2438d(graphQLStory);
        return d != null ? StoryAttachmentHelper.o(d).r().b() : null;
    }

    public final boolean m2440b(GraphQLStory graphQLStory) {
        GraphQLStory d = m2438d(graphQLStory);
        if (d == null) {
            return false;
        }
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(d);
        if (o == null || GraphQLMediaConversionHelper.b(o.r()).t() != GraphQLVideoBroadcastStatus.LIVE) {
            return false;
        }
        return true;
    }

    public final boolean m2441c(GraphQLStory graphQLStory) {
        GraphQLStory d = m2438d(graphQLStory);
        if (d == null) {
            return false;
        }
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(d);
        if (o != null) {
            return GraphQLMediaConversionHelper.b(o.r()).ai();
        }
        return false;
    }
}

package com.facebook.attachments.photos;

import android.graphics.PointF;
import android.graphics.RectF;
import com.facebook.cache.PostpostTaggingMemoryCache;
import com.facebook.common.time.SystemClock;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLFaceBox;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLPhotoTagsEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.TaggingHelper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hide_user_id */
public class PostpostTaggingUtil {
    private static volatile PostpostTaggingUtil f21032e;
    private Lazy<TaggingHelper> f21033a;
    private Lazy<PostpostTaggingMemoryCache> f21034b;
    private Lazy<SystemClock> f21035c;
    private Lazy<FbLocationStatusUtil> f21036d;

    public static com.facebook.attachments.photos.PostpostTaggingUtil m28760a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21032e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.attachments.photos.PostpostTaggingUtil.class;
        monitor-enter(r1);
        r0 = f21032e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m28762b(r0);	 Catch:{ all -> 0x0035 }
        f21032e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21032e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.attachments.photos.PostpostTaggingUtil.a(com.facebook.inject.InjectorLike):com.facebook.attachments.photos.PostpostTaggingUtil");
    }

    private static PostpostTaggingUtil m28762b(InjectorLike injectorLike) {
        return new PostpostTaggingUtil(IdBasedSingletonScopeProvider.m1810b(injectorLike, 431), IdBasedSingletonScopeProvider.m1810b(injectorLike, 609), IdBasedLazy.m1808a(injectorLike, 9269), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2483));
    }

    @Inject
    public PostpostTaggingUtil(Lazy<PostpostTaggingMemoryCache> lazy, Lazy<SystemClock> lazy2, Lazy<TaggingHelper> lazy3, Lazy<FbLocationStatusUtil> lazy4) {
        this.f21034b = lazy;
        this.f21035c = lazy2;
        this.f21033a = lazy3;
        this.f21036d = lazy4;
    }

    public final int m28766a(FeedProps<GraphQLStoryAttachment> feedProps, @Nullable GraphQLMedia graphQLMedia) {
        if (m28765e(feedProps, graphQLMedia)) {
            if (m28763c(feedProps, graphQLMedia)) {
                return 1;
            }
            if (m28764d(feedProps, graphQLMedia)) {
                return 2;
            }
        }
        return 0;
    }

    public final boolean m28770b(FeedProps<GraphQLStoryAttachment> feedProps, @Nullable GraphQLMedia graphQLMedia) {
        return m28765e(feedProps, graphQLMedia) && m28763c(feedProps, graphQLMedia);
    }

    private boolean m28763c(FeedProps<GraphQLStoryAttachment> feedProps, @Nullable GraphQLMedia graphQLMedia) {
        return m28761a(AttachmentProps.m28714c(feedProps), 7200) && m28767a(graphQLMedia) > 0;
    }

    private boolean m28764d(FeedProps<GraphQLStoryAttachment> feedProps, @Nullable GraphQLMedia graphQLMedia) {
        GraphQLStory c = AttachmentProps.m28714c(feedProps);
        return m28761a(c, 7200) && c != null && c.m22339Y() == null && graphQLMedia.m24428G() == null && ((FbLocationStatusUtil) this.f21036d.get()).m8259b().f15655a == State.OKAY;
    }

    private boolean m28765e(FeedProps<GraphQLStoryAttachment> feedProps, @Nullable GraphQLMedia graphQLMedia) {
        return (graphQLMedia == null || !graphQLMedia.ar() || m28768a(AttachmentProps.m28714c(feedProps))) ? false : true;
    }

    @VisibleForTesting
    private boolean m28761a(GraphQLStory graphQLStory, long j) {
        if (graphQLStory == null) {
            return false;
        }
        return (((SystemClock) this.f21035c.get()).mo211a() / 1000) - graphQLStory.m22336V() < j;
    }

    public final boolean m28768a(GraphQLStory graphQLStory) {
        if (graphQLStory == null || graphQLStory.m22350c() == null) {
            return false;
        }
        return ((PostpostTaggingMemoryCache) this.f21034b.get()).f22041a.m4432a(graphQLStory.m22350c()) != null;
    }

    public final void m28769b(GraphQLStory graphQLStory) {
        if (graphQLStory != null && graphQLStory.m22350c() != null) {
            PostpostTaggingMemoryCache postpostTaggingMemoryCache = (PostpostTaggingMemoryCache) this.f21034b.get();
            postpostTaggingMemoryCache.f22041a.m4433a(graphQLStory.m22350c(), Long.valueOf(graphQLStory.m22336V()));
        }
    }

    public final int m28767a(GraphQLMedia graphQLMedia) {
        if (graphQLMedia == null || graphQLMedia.m24429H() == null || graphQLMedia.m24429H().m27520a() == null || graphQLMedia.m24429H().m27520a().isEmpty()) {
            return 0;
        }
        ImmutableList of;
        int i;
        ImmutableList a = graphQLMedia.m24429H().m27520a();
        if (graphQLMedia.bk() == null || graphQLMedia.bk().m27599a() == null) {
            of = ImmutableList.of();
        } else {
            of = graphQLMedia.bk().m27599a();
        }
        List<FaceBox> a2 = Lists.m1297a(a.size());
        int size = a.size();
        for (i = 0; i < size; i++) {
            GraphQLFaceBox graphQLFaceBox = (GraphQLFaceBox) a.get(i);
            if (graphQLFaceBox.m27524j() != null) {
                a2.add(new FaceBox(new RectF((float) (graphQLFaceBox.m27524j().mo3123a() - (graphQLFaceBox.m27525k().mo3123a() / 2.0d)), (float) (graphQLFaceBox.m27524j().mo3124b() - (graphQLFaceBox.m27525k().mo3124b() / 2.0d)), (float) (graphQLFaceBox.m27524j().mo3123a() + (graphQLFaceBox.m27525k().mo3123a() / 2.0d)), (float) (graphQLFaceBox.m27524j().mo3124b() + (graphQLFaceBox.m27525k().mo3124b() / 2.0d)))));
            }
        }
        List<PointF> a3 = Lists.m1297a(of.size());
        size = of.size();
        for (i = 0; i < size; i++) {
            GraphQLPhotoTagsEdge graphQLPhotoTagsEdge = (GraphQLPhotoTagsEdge) of.get(i);
            if (graphQLPhotoTagsEdge.k().j() != null) {
                a3.add(new PointF((float) graphQLPhotoTagsEdge.k().j().mo3123a(), (float) graphQLPhotoTagsEdge.k().j().mo3124b()));
            }
        }
        int size2 = a2.size();
        int i2 = size2;
        for (PointF pointF : a3) {
            for (FaceBox faceBox : a2) {
                if (((TaggingHelper) this.f21033a.get()).a(pointF, faceBox.f(), faceBox.d()) < 4.0d) {
                    i2--;
                    break;
                }
            }
        }
        return i2 < 0 ? 0 : i2;
    }
}

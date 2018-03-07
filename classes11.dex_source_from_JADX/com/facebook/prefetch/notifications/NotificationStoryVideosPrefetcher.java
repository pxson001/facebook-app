package com.facebook.prefetch.notifications;

import android.net.Uri;
import com.facebook.exoplayer.ipc.VideoPrefetchRequest;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.exoserviceclient.ExoServiceClient;
import com.facebook.video.exoserviceclient.ExoServiceClient.PrefetchOrigin;
import com.facebook.video.exoserviceclient.ExoServiceClientMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SurfaceView should have explicit width and height set */
public class NotificationStoryVideosPrefetcher {
    private static volatile NotificationStoryVideosPrefetcher f10850c;
    private final ExoServiceClient f10851a;
    private final VideoLivePlaybackConfig f10852b;

    public static com.facebook.prefetch.notifications.NotificationStoryVideosPrefetcher m11310a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10850c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.prefetch.notifications.NotificationStoryVideosPrefetcher.class;
        monitor-enter(r1);
        r0 = f10850c;	 Catch:{ all -> 0x003a }
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
        r0 = m11313b(r0);	 Catch:{ all -> 0x0035 }
        f10850c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10850c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.prefetch.notifications.NotificationStoryVideosPrefetcher.a(com.facebook.inject.InjectorLike):com.facebook.prefetch.notifications.NotificationStoryVideosPrefetcher");
    }

    private static NotificationStoryVideosPrefetcher m11313b(InjectorLike injectorLike) {
        return new NotificationStoryVideosPrefetcher(ExoServiceClientMethodAutoProvider.a(injectorLike), VideoLivePlaybackConfig.a(injectorLike));
    }

    @Inject
    public NotificationStoryVideosPrefetcher(ExoServiceClient exoServiceClient, VideoLivePlaybackConfig videoLivePlaybackConfig) {
        this.f10851a = exoServiceClient;
        this.f10852b = videoLivePlaybackConfig;
    }

    public final void m11314a(GraphQLStory graphQLStory) {
        List<VideoPrefetchRequest> arrayList = new ArrayList();
        m11311a(graphQLStory, (List) arrayList, PrefetchOrigin.NOTIFICATION);
        if (!arrayList.isEmpty()) {
            for (VideoPrefetchRequest b : arrayList) {
                this.f10851a.b(b);
            }
        }
    }

    private void m11311a(GraphQLStory graphQLStory, List<VideoPrefetchRequest> list, PrefetchOrigin prefetchOrigin) {
        if (graphQLStory.L() != null) {
            m11311a(graphQLStory.L(), (List) list, prefetchOrigin);
        }
        ImmutableList j = StoryHierarchyHelper.a(graphQLStory).j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            m11311a((GraphQLStory) j.get(i), (List) list, prefetchOrigin);
        }
        for (GraphQLStoryAttachment a : graphQLStory.x()) {
            m11312a(a, (List) list, prefetchOrigin);
        }
    }

    private void m11312a(GraphQLStoryAttachment graphQLStoryAttachment, List<VideoPrefetchRequest> list, PrefetchOrigin prefetchOrigin) {
        int i;
        if (!(graphQLStoryAttachment.x() == null || graphQLStoryAttachment.x().isEmpty())) {
            ImmutableList x = graphQLStoryAttachment.x();
            int size = x.size();
            for (int i2 = 0; i2 < size; i2++) {
                m11312a((GraphQLStoryAttachment) x.get(i2), (List) list, prefetchOrigin);
            }
        }
        GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle = (graphQLStoryAttachment.w() == null || graphQLStoryAttachment.w().isEmpty()) ? GraphQLStoryAttachmentStyle.VIDEO_AUTOPLAY : (GraphQLStoryAttachmentStyle) graphQLStoryAttachment.w().get(0);
        if (graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.VIDEO_AUTOPLAY || graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.VIDEO_DIRECT_RESPONSE_AUTOPLAY || graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.VIDEO_CINEMAGRAPH || graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.ALBUM) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            GraphQLMedia r = graphQLStoryAttachment.r();
            if (r != null && r.j() != null && r.j().g() == 82650203) {
                GraphQLVideo b = GraphQLMediaConversionHelper.b(r);
                if (b != null && b.ae()) {
                    String aB = b.aB();
                    if (aB == null || !this.f10852b.d) {
                        String aJ = b.aJ();
                        if (this.f10852b.q && this.f10852b.f && aJ != null) {
                            Uri parse = Uri.parse(aJ);
                            if (parse.getPath().endsWith(".mpd")) {
                                list.add(new VideoPrefetchRequest(parse, b.J(), null, 0, prefetchOrigin.toString()));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    list.add(new VideoPrefetchRequest(Uri.parse(aB), b.J(), null, 0, prefetchOrigin.toString()));
                }
            }
        }
    }
}

package com.facebook.feedplugins.attachments.video;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ufi/reactions/v2/84x84/like */
public class VideoSizer {
    private static volatile VideoSizer f110f;
    public final Display f111a;
    public final Context f112b;
    public final BasePaddingStyleResolver f113c;
    private final GraphQLStoryUtil f114d;
    public final QeAccessor f115e;

    public static com.facebook.feedplugins.attachments.video.VideoSizer m108a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f110f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.attachments.video.VideoSizer.class;
        monitor-enter(r1);
        r0 = f110f;	 Catch:{ all -> 0x003a }
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
        r0 = m109b(r0);	 Catch:{ all -> 0x0035 }
        f110f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f110f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.attachments.video.VideoSizer.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.attachments.video.VideoSizer");
    }

    private static VideoSizer m109b(InjectorLike injectorLike) {
        return new VideoSizer(WindowManagerMethodAutoProvider.b(injectorLike), (Context) injectorLike.getInstance(Context.class), (BasePaddingStyleResolver) DefaultPaddingStyleResolver.a(injectorLike), GraphQLStoryUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public VideoSizer(WindowManager windowManager, Context context, BasePaddingStyleResolver basePaddingStyleResolver, GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor) {
        this.f111a = windowManager.getDefaultDisplay();
        this.f112b = context;
        this.f113c = basePaddingStyleResolver;
        this.f115e = qeAccessor;
        this.f114d = graphQLStoryUtil;
    }

    public final VideoSize m111a(FeedProps<GraphQLStoryAttachment> feedProps, float f, Point point) {
        return m107a((FeedProps) feedProps, f, true, point);
    }

    private VideoSize m107a(FeedProps<GraphQLStoryAttachment> feedProps, float f, boolean z, Point point) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        int i = point.x;
        int i2 = point.y;
        boolean a = VideoAttachmentDelegate.a(feedProps);
        if (z && this.f115e.a(ExperimentsForNewsFeedAbTestModule.ai, false)) {
            int m = this.f114d.m(AttachmentProps.e(feedProps));
            if (m > 0) {
                i -= SizeUtil.a(this.f112b, PaddingStyle.c.s.d.a(m) * 2.0f);
            }
        }
        return new VideoSize(i, m105a(graphQLStoryAttachment.r(), i, f, a), i, m104a(graphQLStoryAttachment.r(), i), i2);
    }

    public final VideoSize m110a(FeedProps<GraphQLStoryAttachment> feedProps, float f) {
        return m107a((FeedProps) feedProps, f, false, m106a((GraphQLStoryAttachment) feedProps.a));
    }

    public final VideoSize m113b(FeedProps<GraphQLStoryAttachment> feedProps, float f) {
        return m107a((FeedProps) feedProps, f, true, m106a((GraphQLStoryAttachment) feedProps.a));
    }

    public final double m114c(FeedProps<GraphQLStoryAttachment> feedProps, float f) {
        VideoSize b = m113b(feedProps, f);
        if (b.d != 0) {
            return ((double) b.c) / ((double) b.d);
        }
        return (double) f;
    }

    public final VideoSize m112a(GraphQLStoryAttachment graphQLStoryAttachment, float f) {
        Point point = new Point();
        this.f111a.getSize(point);
        return new VideoSize(point.x, m105a(graphQLStoryAttachment.r(), point.x, f, false), point.x, m104a(graphQLStoryAttachment.r(), point.x), point.y);
    }

    private int m105a(GraphQLMedia graphQLMedia, int i, float f, boolean z) {
        if (f != 0.0f) {
            return (int) (((float) i) / f);
        }
        double a = z ? (double) this.f115e.a(ExperimentsForVideoAbTestModule.k, 1.0f) : (double) this.f115e.a(ExperimentsForVideoAbTestModule.j, 1.0f);
        if (a == 0.0d) {
            a = 1.0d;
        }
        return Math.min(m104a(graphQLMedia, i), (int) (a * ((double) i)));
    }

    private static int m104a(GraphQLMedia graphQLMedia, int i) {
        return (int) ((((float) graphQLMedia.R()) / ((float) graphQLMedia.bo())) * ((float) i));
    }

    private Point m106a(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (CallToActionUtil.k(graphQLStoryAttachment)) {
            int a = SizeUtil.a(this.f112b, this.f113c.a(PaddingStyle.a).d.a(0) * 2.0f);
            Point point = new Point();
            point.set(this.f111a.getWidth() - a, this.f111a.getHeight() - a);
            return point;
        }
        Point point2 = new Point();
        this.f111a.getSize(point2);
        return point2;
    }
}

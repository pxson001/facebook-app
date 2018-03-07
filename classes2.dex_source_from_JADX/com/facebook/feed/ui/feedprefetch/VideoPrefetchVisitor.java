package com.facebook.feed.ui.feedprefetch;

import android.net.Uri;
import android.os.Handler;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.exoplayer.ipc.VideoPrefetchRequest;
import com.facebook.feed.feature.ExperimentsForFeedFeatureModule;
import com.facebook.feed.ui.feedprefetch.FeedPrefetchLoader.GraphQLStoryVisitor;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.abtest.VideoPrefetchExperimentHelper;
import com.facebook.video.exoserviceclient.ExoServiceClient;
import com.facebook.video.exoserviceclient.ExoServiceClient.PrefetchOrigin;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.server.prefetcher.DashVideoPrefetchParser;
import com.facebook.video.server.prefetcher.VideoPrefetchList;
import com.facebook.video.server.prefetcher.VideoPrefetchLocation;
import com.facebook.video.server.prefetcher.VideoPrefetchModel;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: is_messenger_bot */
public class VideoPrefetchVisitor implements GraphQLStoryVisitor {
    private static final String f19014a = VideoPrefetchVisitor.class.getSimpleName();
    private final VideoPrefetchLocation f19015b;
    private final CallerContext f19016c;
    public final Provider<VideoPrefetchModel> f19017d;
    private final DashVideoPrefetchParser f19018e;
    private final Handler f19019f;
    private final AbstractFbErrorReporter f19020g;
    private final VideoAutoPlaySettingsChecker f19021h;
    private final VideoPrefetchExperimentHelper f19022i;
    public final QeAccessor f19023j;
    @Nullable
    private VideoPrefetchList f19024k;
    @Nullable
    public VideoPrefetchModel f19025l;
    private final ExoServiceClient f19026m;
    private final VideoLivePlaybackConfig f19027n;

    @Inject
    public VideoPrefetchVisitor(@Assisted VideoPrefetchLocation videoPrefetchLocation, @Assisted CallerContext callerContext, Provider<VideoPrefetchModel> provider, DashVideoPrefetchParser dashVideoPrefetchParser, Handler handler, FbErrorReporter fbErrorReporter, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoPrefetchExperimentHelper videoPrefetchExperimentHelper, QeAccessor qeAccessor, ExoServiceClient exoServiceClient, VideoLivePlaybackConfig videoLivePlaybackConfig) {
        this.f19015b = videoPrefetchLocation;
        this.f19016c = callerContext;
        this.f19017d = provider;
        this.f19018e = dashVideoPrefetchParser;
        this.f19019f = handler;
        this.f19020g = fbErrorReporter;
        this.f19021h = videoAutoPlaySettingsChecker;
        this.f19022i = videoPrefetchExperimentHelper;
        this.f19023j = qeAccessor;
        this.f19026m = exoServiceClient;
        this.f19027n = videoLivePlaybackConfig;
    }

    public final void mo2180a(GraphQLStory graphQLStory) {
        TracerDetour.a("VideoPrefetchVisitor.visitStory", -1827213949);
        try {
            m26748b(graphQLStory);
        } finally {
            TracerDetour.b(1173627496);
        }
    }

    private void m26748b(GraphQLStory graphQLStory) {
        if (graphQLStory.m22326L() != null) {
            m26748b(graphQLStory.m22326L());
        }
        ImmutableList j = StoryHierarchyHelper.m27434a(graphQLStory).m22608j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            m26748b((GraphQLStory) j.get(i));
        }
        for (GraphQLStoryAttachment b : graphQLStory.m22367x()) {
            m26749b(b);
        }
    }

    private void m26749b(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (!(graphQLStoryAttachment.m23985x() == null || graphQLStoryAttachment.m23985x().isEmpty())) {
            ImmutableList x = graphQLStoryAttachment.m23985x();
            int size = x.size();
            for (int i = 0; i < size; i++) {
                m26749b((GraphQLStoryAttachment) x.get(i));
            }
        }
        m26750c(graphQLStoryAttachment);
    }

    private void m26750c(GraphQLStoryAttachment graphQLStoryAttachment) {
        try {
            final GraphQLStoryAttachment graphQLStoryAttachment2 = (GraphQLStoryAttachment) graphQLStoryAttachment.clone();
            HandlerDetour.a(this.f19019f, new Runnable(this) {
                final /* synthetic */ VideoPrefetchVisitor f21628b;

                public void run() {
                    this.f21628b.m26752a(graphQLStoryAttachment2);
                }
            }, -1838681059);
        } catch (Throwable e) {
            this.f19020g.m2351b("VideoPrepare", "Not cloneable attachment", e);
        }
    }

    private void m26746a(Uri uri, String str) {
        if (this.f19026m != null) {
            this.f19026m.m14064b(new VideoPrefetchRequest(uri, str, null, 0, PrefetchOrigin.FEED.toString()));
        }
    }

    private void m26747b(Uri uri, String str) {
        if (this.f19026m != null) {
            this.f19026m.m14064b(new VideoPrefetchRequest(uri, str, null, 0, PrefetchOrigin.FEED.toString()));
        }
    }

    public final Void m26752a(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLMedia r = graphQLStoryAttachment.m23979r();
        if (!(r == null || r.m24453j() == null || r.m24453j().m22301g() != 82650203)) {
            GraphQLVideo b = GraphQLMediaConversionHelper.b(r);
            if (b != null) {
                int i;
                GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle = (graphQLStoryAttachment.m23984w() == null || graphQLStoryAttachment.m23984w().isEmpty()) ? GraphQLStoryAttachmentStyle.VIDEO_AUTOPLAY : (GraphQLStoryAttachmentStyle) graphQLStoryAttachment.m23984w().get(0);
                boolean z = false;
                if (graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.VIDEO_AUTOPLAY || graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.VIDEO_DIRECT_RESPONSE_AUTOPLAY || graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.VIDEO_CINEMAGRAPH || graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.ALBUM || graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.ANIMATED_IMAGE_AUTOPLAY) {
                    z = true;
                } else if (graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.ANIMATED_IMAGE_VIDEO_AUTOPLAY) {
                    z = this.f19023j.mo596a(ExperimentsForFeedFeatureModule.a, false);
                }
                if (z && this.f19021h.m26871a()) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0 || this.f19022i.m16709b()) {
                    Uri parse;
                    String str;
                    if (b.ae()) {
                        String aB = b.aB();
                        if (aB == null || !this.f19027n.f9126d) {
                            aB = b.aJ();
                            if (this.f19027n.f9139q && this.f19027n.f9128f && aB != null) {
                                parse = Uri.parse(aB);
                                if (parse.getPath().endsWith(".mpd")) {
                                    str = this.f19016c.f5181b;
                                    m26746a(parse, b.m24060J());
                                }
                            }
                        } else {
                            m26747b(Uri.parse(aB), b.m24060J());
                        }
                    } else {
                        parse = UriUtil.m18787a(b.aE());
                        if (parse != null) {
                            VideoResourceMetadata videoResourceMetadata = new VideoResourceMetadata(parse, b.m24060J());
                            videoResourceMetadata.e = (long) b.m24090s();
                            videoResourceMetadata.d = (long) b.m24086o();
                            videoResourceMetadata.f = (long) b.aD();
                            videoResourceMetadata.h = b.ai();
                            CharSequence aH = b.aH();
                            if (!StringUtil.m3589a(aH)) {
                                this.f19018e.m26863a((String) aH, m26751e(), videoResourceMetadata);
                                str = this.f19016c.f5181b;
                                r.m24452b();
                            }
                            if (StringUtil.m3589a(aH) || !this.f19018e.f19128c.f6881h) {
                                m26751e().mo2178b(videoResourceMetadata);
                                str = this.f19016c.f5181b;
                                r.m24452b();
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public final void m26753a() {
        m26751e().mo2174a(true);
    }

    public final void m26755b() {
        m26751e().mo2174a(false);
    }

    public final boolean m26756c() {
        return m26751e().mo2176a();
    }

    private VideoPrefetchList m26751e() {
        if (this.f19024k == null) {
            if (this.f19025l == null) {
                this.f19025l = (VideoPrefetchModel) this.f19017d.get();
            }
            this.f19024k = this.f19025l.m14816a(this.f19015b);
        }
        return this.f19024k;
    }

    public final void m26757d() {
        m26751e().mo2177b();
    }
}

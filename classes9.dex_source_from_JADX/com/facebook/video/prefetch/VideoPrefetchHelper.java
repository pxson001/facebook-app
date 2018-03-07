package com.facebook.video.prefetch;

import android.net.Uri;
import com.facebook.debug.log.BLog;
import com.facebook.exoplayer.ipc.VideoPrefetchRequest;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.abtest.VideoPrefetchExperimentHelper;
import com.facebook.video.exoserviceclient.ExoServiceClient;
import com.facebook.video.exoserviceclient.ExoServiceClient.PrefetchOrigin;
import com.facebook.video.exoserviceclient.ExoServiceClientMethodAutoProvider;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: story.php */
public class VideoPrefetchHelper {
    private static final String f2744a = VideoPrefetchHelper.class.getSimpleName();
    public final ExoServiceClient f2745b;
    private final VideoLivePlaybackConfig f2746c;
    private final VideoAutoPlaySettingsChecker f2747d;
    private final VideoPrefetchExperimentHelper f2748e;

    public static VideoPrefetchHelper m2638b(InjectorLike injectorLike) {
        return new VideoPrefetchHelper(ExoServiceClientMethodAutoProvider.a(injectorLike), VideoLivePlaybackConfig.a(injectorLike), VideoAutoPlaySettingsChecker.a(injectorLike), VideoPrefetchExperimentHelper.a(injectorLike));
    }

    @Inject
    public VideoPrefetchHelper(ExoServiceClient exoServiceClient, VideoLivePlaybackConfig videoLivePlaybackConfig, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoPrefetchExperimentHelper videoPrefetchExperimentHelper) {
        this.f2745b = exoServiceClient;
        this.f2746c = videoLivePlaybackConfig;
        this.f2747d = videoAutoPlaySettingsChecker;
        this.f2748e = videoPrefetchExperimentHelper;
    }

    public static VideoPrefetchHelper m2636a(InjectorLike injectorLike) {
        return m2638b(injectorLike);
    }

    public final boolean m2639a(@Nullable GraphQLStoryAttachment graphQLStoryAttachment, PrefetchOrigin prefetchOrigin) {
        return m2637a(graphQLStoryAttachment, prefetchOrigin, true);
    }

    public final boolean m2640b(@Nullable GraphQLStoryAttachment graphQLStoryAttachment, PrefetchOrigin prefetchOrigin) {
        return m2637a(graphQLStoryAttachment, prefetchOrigin, false);
    }

    private boolean m2637a(@Nullable GraphQLStoryAttachment graphQLStoryAttachment, PrefetchOrigin prefetchOrigin, boolean z) {
        if (graphQLStoryAttachment == null) {
            return false;
        }
        GraphQLVideo b = GraphQLMediaConversionHelper.b(graphQLStoryAttachment.r());
        if (b == null || !b.ae()) {
            return false;
        }
        Object obj;
        GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle = (graphQLStoryAttachment.w() == null || graphQLStoryAttachment.w().isEmpty()) ? GraphQLStoryAttachmentStyle.VIDEO_AUTOPLAY : (GraphQLStoryAttachmentStyle) graphQLStoryAttachment.w().get(0);
        if (graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.VIDEO_AUTOPLAY || graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.VIDEO_DIRECT_RESPONSE_AUTOPLAY || graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.VIDEO_CINEMAGRAPH || graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.ALBUM) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null || !this.f2747d.a()) {
            boolean z2 = false;
        } else {
            int i = 1;
        }
        if (i == 0 && !this.f2748e.b()) {
            return false;
        }
        Uri parse;
        String aJ = b.aJ();
        if (this.f2746c.d && b.aB() != null) {
            parse = Uri.parse(b.aB());
            int i2 = 1;
        } else if (this.f2746c.q && this.f2746c.f && aJ != null && Uri.parse(aJ).getPath().endsWith(".mpd")) {
            parse = Uri.parse(aJ);
            r6 = false;
        } else {
            r6 = false;
            parse = null;
        }
        if (parse == null) {
            return false;
        }
        VideoPrefetchRequest videoPrefetchRequest = new VideoPrefetchRequest(parse, b.J(), null, 0, prefetchOrigin.toString());
        if (z && r6 != 0) {
            return this.f2745b.a(videoPrefetchRequest);
        }
        if (!z) {
            return this.f2745b.b(videoPrefetchRequest);
        }
        BLog.a(f2744a, "Preconnect isn't supported for video: %s", new Object[]{parse});
        return false;
    }
}

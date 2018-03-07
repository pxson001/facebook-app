package com.facebook.feedplugins.attachments.video;

import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.Assisted;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.engine.PlayPosition;
import javax.inject.Inject;

/* compiled from: phone_number */
public class LegacyFullscreenTransitionListener implements FullscreenTransitionListener {
    private final VideoAutoplayTransitionManager f5002a;
    private final FrameRateBlameMarkers f5003b;
    private final HasInvalidate f5004c;
    private final FeedProps<GraphQLStoryAttachment> f5005d;
    private final CallToActionUtil f5006e;

    @Inject
    public LegacyFullscreenTransitionListener(@Assisted FeedProps<GraphQLStoryAttachment> feedProps, @Assisted VideoAutoplayTransitionManager videoAutoplayTransitionManager, @Assisted HasInvalidate hasInvalidate, FrameRateBlameMarkers frameRateBlameMarkers, CallToActionUtil callToActionUtil) {
        this.f5002a = videoAutoplayTransitionManager;
        this.f5003b = frameRateBlameMarkers;
        this.f5004c = hasInvalidate;
        this.f5005d = feedProps;
        this.f5006e = callToActionUtil;
    }

    public final void mo438a(ExitFullScreenResult exitFullScreenResult) {
        this.f5002a.mo429a();
        this.f5002a.mo435d().m5314a(exitFullScreenResult.b, exitFullScreenResult.a);
        if (this.f5002a.mo434c() != null) {
            Object obj;
            this.f5002a.mo436e().mo421a(exitFullScreenResult.c);
            if (exitFullScreenResult.b || exitFullScreenResult.a || exitFullScreenResult.c <= 0) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                this.f5002a.mo432a(exitFullScreenResult.b);
                this.f5002a.mo430a(this.f5003b, exitFullScreenResult.f, new PlayPosition(exitFullScreenResult.c, exitFullScreenResult.d));
            } else if (exitFullScreenResult.b && this.f5006e.c(this.f5002a.mo437f())) {
                this.f5002a.mo436e().f4907a = true;
                this.f5004c.a(new FeedProps[]{this.f5005d});
            }
            if (exitFullScreenResult.b) {
                this.f5002a.mo433b();
            }
            this.f5002a.mo431a(exitFullScreenResult);
        }
    }
}

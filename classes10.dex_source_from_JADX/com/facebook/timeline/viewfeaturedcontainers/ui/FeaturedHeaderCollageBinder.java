package com.facebook.timeline.viewfeaturedcontainers.ui;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.header.favphotos.MediaCollageHelper;
import com.facebook.timeline.header.favphotos.TimelineHeaderFeaturedPhotosMosaicView;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.CollageLayoutFields;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainerEdgeModel;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainerModel;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainerModel.ContainerCoverMediaModel;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainerModel.StoriesModel;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayerParams;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: extra_events_discovery_filter_location */
public class FeaturedHeaderCollageBinder {
    public static final CallerContext f12888a = CallerContext.a(FeaturedHeaderCollageBinder.class, "timeline");
    public final MediaCollageHelper f12889b;
    public final Lazy<IFeedIntentBuilder> f12890c;
    public final Provider<SecureContextHelper> f12891d;
    public OnClickListener f12892e;

    /* compiled from: extra_events_discovery_filter_location */
    public class C18021 implements OnClickListener {
        final /* synthetic */ FeaturedHeaderCollageBinder f12887a;

        public C18021(FeaturedHeaderCollageBinder featuredHeaderCollageBinder) {
            this.f12887a = featuredHeaderCollageBinder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1008854234);
            FeaturedHeaderCollageBinder featuredHeaderCollageBinder = this.f12887a;
            String str = (String) view.getTag();
            if (str != null) {
                Builder builder = new Builder();
                builder.K = str;
                ((SecureContextHelper) featuredHeaderCollageBinder.f12891d.get()).a(((IFeedIntentBuilder) featuredHeaderCollageBinder.f12890c.get()).a(builder.a()), view.getContext());
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1604021841, a);
        }
    }

    public static FeaturedHeaderCollageBinder m12887b(InjectorLike injectorLike) {
        return new FeaturedHeaderCollageBinder(MediaCollageHelper.m11810b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2347), IdBasedSingletonScopeProvider.a(injectorLike, 968));
    }

    @Inject
    public FeaturedHeaderCollageBinder(MediaCollageHelper mediaCollageHelper, Lazy<IFeedIntentBuilder> lazy, Provider<SecureContextHelper> provider) {
        this.f12889b = mediaCollageHelper;
        this.f12890c = lazy;
        this.f12891d = provider;
    }

    public final void m12889a(TimelineHeaderFeaturedPhotosMosaicView timelineHeaderFeaturedPhotosMosaicView, FeaturedContainersHeaderData featuredContainersHeaderData) {
        timelineHeaderFeaturedPhotosMosaicView.removeAllViews();
        for (int i = 0; i < featuredContainersHeaderData.f12836b.size(); i++) {
            FeaturedContainerEdgeModel featuredContainerEdgeModel = (FeaturedContainerEdgeModel) featuredContainersHeaderData.f12836b.get(i);
            if (!(featuredContainerEdgeModel == null || featuredContainerEdgeModel.m12806b() == null || featuredContainerEdgeModel.m12806b().m12846b() == null)) {
                View a;
                FeaturedContainerModel b = featuredContainerEdgeModel.m12806b();
                CollageLayoutFields a2 = featuredContainerEdgeModel.m12805a();
                switch (b.m12846b().m12818b().g()) {
                    case 77090322:
                        a = this.f12889b.m11812a(timelineHeaderFeaturedPhotosMosaicView.getContext(), f12888a, b.m12846b(), null, a2);
                        break;
                    case 82650203:
                        a = m12888b(timelineHeaderFeaturedPhotosMosaicView, b, a2);
                        ((FeaturedVideoView) a).a(EventTriggerType.BY_PLAYER);
                        break;
                    default:
                        break;
                }
                if (!(b.m12847c() == null || b.m12847c().isEmpty())) {
                    a.setTag(((StoriesModel) b.m12847c().get(0)).m12834b());
                    if (this.f12892e == null) {
                        this.f12892e = new C18021(this);
                    }
                    a.setOnClickListener(this.f12892e);
                }
                timelineHeaderFeaturedPhotosMosaicView.addView(a);
            }
        }
    }

    private FeaturedVideoView m12888b(TimelineHeaderFeaturedPhotosMosaicView timelineHeaderFeaturedPhotosMosaicView, FeaturedContainerModel featuredContainerModel, CollageLayoutFields collageLayoutFields) {
        FeaturedVideoView featuredVideoView = new FeaturedVideoView(timelineHeaderFeaturedPhotosMosaicView.getContext());
        featuredVideoView.setLayoutParams(MediaCollageHelper.m11809a(collageLayoutFields));
        ContainerCoverMediaModel b = featuredContainerModel.m12846b();
        VideoDataSourceBuilder videoDataSourceBuilder = new VideoDataSourceBuilder();
        videoDataSourceBuilder.a = Uri.parse(b.m12823k());
        videoDataSourceBuilder = videoDataSourceBuilder;
        videoDataSourceBuilder.f = StreamSourceType.FROM_STREAM;
        VideoPlayerParamsBuilder a = new VideoPlayerParamsBuilder().a(videoDataSourceBuilder.i());
        a.g = true;
        VideoPlayerParams m = a.m();
        double l = (double) (b.m12824l() / b.m12822j());
        RichVideoPlayerParams.Builder builder = new RichVideoPlayerParams.Builder();
        builder.a = m;
        featuredVideoView.a(builder.a("VideoAspectRatioKey", Double.valueOf(l)).b());
        return featuredVideoView;
    }
}

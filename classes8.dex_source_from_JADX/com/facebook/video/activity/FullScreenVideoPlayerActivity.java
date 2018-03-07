package com.facebook.video.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.common.util.UriUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.fullscreenvideoplayer.FullScreenVideoInflater;
import com.facebook.feed.video.FeedFullScreenParams;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.GraphQLVideo.Builder;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albums.protocols.VideoConversionHelper;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalyticsRequiredInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.events.VideoFullScreenEventBus;
import com.facebook.video.events.VideoFullScreenEvents.ExitFullScreenEvent;
import com.facebook.video.player.FullScreenVideoListener;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: mCardHolderName */
public class FullScreenVideoPlayerActivity extends FbFragmentActivity {
    private final FullScreenVideoListener f9562p = new C09981(this);
    private final C09992 f9563q = new C09992(this);
    private ImmersiveVideoPlayer f9564r;
    private FeedFullScreenParams f9565s;
    private ComposerPublishServiceHelper f9566t;
    private VideoFullScreenEventBus f9567u;
    private FullScreenVideoInflater f9568v;
    private boolean f9569w = false;

    /* compiled from: mCardHolderName */
    class C09981 implements FullScreenVideoListener {
        final /* synthetic */ FullScreenVideoPlayerActivity f9560a;

        C09981(FullScreenVideoPlayerActivity fullScreenVideoPlayerActivity) {
            this.f9560a = fullScreenVideoPlayerActivity;
        }

        public final void m11242a(EventTriggerType eventTriggerType) {
        }

        public final void m11243a(EventTriggerType eventTriggerType, ExitFullScreenResult exitFullScreenResult) {
            if (exitFullScreenResult.b) {
                this.f9560a.finish();
            }
        }
    }

    /* compiled from: mCardHolderName */
    public class C09992 implements TypedHandler {
        final /* synthetic */ FullScreenVideoPlayerActivity f9561a;

        C09992(FullScreenVideoPlayerActivity fullScreenVideoPlayerActivity) {
            this.f9561a = fullScreenVideoPlayerActivity;
        }

        public final void m11244a() {
            this.f9561a.finish();
        }
    }

    private static <T extends Context> void m11249a(Class<T> cls, T t) {
        m11250a((Object) t, (Context) t);
    }

    public static void m11250a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FullScreenVideoPlayerActivity) obj).m11248a(ComposerPublishServiceHelper.b(fbInjector), VideoFullScreenEventBus.a(fbInjector), FullScreenVideoInflater.a(fbInjector));
    }

    public static Intent m11245a(Context context, PlayerOrigin playerOrigin) {
        Intent intent = new Intent(context, FullScreenVideoPlayerActivity.class);
        intent.putExtra("video_player_origin", playerOrigin.asString());
        return intent;
    }

    @Inject
    private void m11248a(ComposerPublishServiceHelper composerPublishServiceHelper, VideoFullScreenEventBus videoFullScreenEventBus, FullScreenVideoInflater fullScreenVideoInflater) {
        this.f9566t = composerPublishServiceHelper;
        this.f9567u = videoFullScreenEventBus;
        this.f9568v = fullScreenVideoInflater;
    }

    public final void m11251a(Bundle bundle) {
        super.a(bundle);
        Class cls = FullScreenVideoPlayerActivity.class;
        m11250a((Object) this, (Context) this);
    }

    public final void m11252b(Bundle bundle) {
        GraphQLVideo a;
        boolean z = (getIntent().getExtras() == null || getIntent().getExtras().isEmpty() || getIntent().getExtras().get("video_graphql_object") == null) ? false : true;
        Preconditions.checkState(z, "Extras of the intent was expected to hold the video object");
        super.b(bundle);
        if (this.f9567u != null) {
            this.f9567u.a(ExitFullScreenEvent.class, this.f9563q);
        }
        Object a2 = FlatBufferModelHelper.a(getIntent().getExtras(), "video_graphql_object");
        if (a2 instanceof FullScreenVideoPlayerBundleItem) {
            a = m11246a((FullScreenVideoPlayerBundleItem) a2);
        } else if (a2 instanceof VideoDetailFragmentModel) {
            a = VideoConversionHelper.a((VideoDetailFragmentModel) a2);
        } else {
            a = (GraphQLVideo) a2;
        }
        this.f9564r = this.f9568v.a(this);
        this.f9564r.setAllowLooping(getIntent().getExtras().getBoolean("video_player_allow_looping", false));
        GraphQLImage bn = a.bn();
        if (bn == null) {
            bn = a.K();
        }
        FeedProps feedProps = null;
        if (!(a == null || a.z() == null)) {
            GraphQLStory z2 = a.z();
            feedProps = FeedProps.c(z2).a(StoryAttachmentHelper.o(z2));
        }
        m11247a(UriUtil.a(a.aE()), bn, a.J(), a, feedProps);
    }

    private static GraphQLVideo m11246a(FullScreenVideoPlayerBundleItem fullScreenVideoPlayerBundleItem) {
        Builder builder = new Builder();
        builder.aI = fullScreenVideoPlayerBundleItem.f9570a.toString();
        builder = builder;
        builder.aH = fullScreenVideoPlayerBundleItem.f9571b;
        builder = builder;
        builder.by = fullScreenVideoPlayerBundleItem.f9572c;
        builder = builder;
        builder.H = fullScreenVideoPlayerBundleItem.f9573d;
        builder = builder;
        builder.u = fullScreenVideoPlayerBundleItem.f9574e;
        return builder.a();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1756:
                    if (!intent.getBooleanExtra("is_uploading_media", false)) {
                        this.f9566t.c(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 997733950);
        super.onStart();
        this.f9564r.c();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -305090190, a);
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -124106745);
        super.onResume();
        this.f9564r.d();
        if (!this.f9569w) {
            this.f9564r.a(this.f9565s);
            this.f9569w = true;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -794315606, a);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1623256411);
        super.onPause();
        this.f9564r.e();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 830771053, a);
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1322030077);
        super.onStop();
        this.f9564r.f();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 156427730, a);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 360475612);
        super.onDestroy();
        if (this.f9567u != null) {
            this.f9567u.b(ExitFullScreenEvent.class, this.f9563q);
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -818884525, a);
    }

    private void m11247a(Uri uri, GraphQLImage graphQLImage, String str, GraphQLVideo graphQLVideo, FeedProps<GraphQLStoryAttachment> feedProps) {
        ImageRequest a;
        PlayerOrigin asPlayerOrigin = PlayerOrigin.asPlayerOrigin((String) getIntent().getExtras().get("video_player_origin"));
        if (graphQLImage != null) {
            a = ImageRequest.a(ImageUtil.a(graphQLImage));
        } else {
            a = ImageRequest.a(uri);
        }
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        VideoAnalyticsRequiredInfo a2 = new VideoAnalyticsRequiredInfo.Builder(str).a();
        VideoFeedStoryInfo.Builder builder = new VideoFeedStoryInfo.Builder(arrayNode);
        builder.b = EventTriggerType.BY_USER;
        VideoFeedStoryInfo.Builder builder2 = builder;
        builder2.d = false;
        this.f9565s = new FeedFullScreenParams(a2, builder2.a(), a, graphQLVideo, feedProps);
        this.f9565s.a(asPlayerOrigin);
        this.f9564r.a(this.f9562p);
    }
}

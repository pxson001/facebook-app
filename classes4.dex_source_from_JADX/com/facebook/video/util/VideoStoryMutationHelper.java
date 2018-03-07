package com.facebook.video.util;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLMedia.Builder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory$Builder;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: place_feed_nearby_cancel */
public class VideoStoryMutationHelper {
    private final Clock f4670a;
    private final FeedEventBus f4671b;
    private final Resources f4672c;

    public static VideoStoryMutationHelper m5148b(InjectorLike injectorLike) {
        return new VideoStoryMutationHelper((Clock) SystemClockMethodAutoProvider.a(injectorLike), FeedEventBus.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public VideoStoryMutationHelper(Clock clock, FeedEventBus feedEventBus, Resources resources) {
        this.f4670a = clock;
        this.f4671b = feedEventBus;
        this.f4672c = resources;
    }

    public final GraphQLStory m5150a(GraphQLStory graphQLStory, @Nullable GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus) {
        return m5147a(graphQLStory, graphQLVideoBroadcastStatus, null);
    }

    public final GraphQLStory m5149a(GraphQLStory graphQLStory, @Nullable VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
        return m5147a(graphQLStory, videoBroadcastFragmentModel == null ? null : videoBroadcastFragmentModel.d(), videoBroadcastFragmentModel);
    }

    private GraphQLStory m5147a(GraphQLStory graphQLStory, @Nullable GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus, @Nullable VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        if (o == null || o.r() == null) {
            return graphQLStory;
        }
        boolean z;
        if (graphQLVideoBroadcastStatus == null) {
            graphQLVideoBroadcastStatus = GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        Builder a = Builder.a(o.r());
        if (graphQLVideoBroadcastStatus != GraphQLVideoBroadcastStatus.VOD_READY) {
            z = true;
        } else {
            z = false;
        }
        a.ak = z;
        Builder builder = a;
        builder.l = graphQLVideoBroadcastStatus;
        builder = builder;
        if (videoBroadcastFragmentModel != null) {
            builder.aM = videoBroadcastFragmentModel.j();
            a = builder;
            a.g = videoBroadcastFragmentModel.b();
            a = a;
            a.I = videoBroadcastFragmentModel.fk_();
            a = a;
            a.k = videoBroadcastFragmentModel.c();
            a = a;
            a.J = videoBroadcastFragmentModel.g();
            a = a;
            a.aR = Strings.nullToEmpty(videoBroadcastFragmentModel.m());
            a = a;
            a.aN = Strings.nullToEmpty(videoBroadcastFragmentModel.k());
            a = a;
            a.aJ = Strings.nullToEmpty(videoBroadcastFragmentModel.fl_());
            a = a;
            a.aK = Strings.nullToEmpty(videoBroadcastFragmentModel.fm_());
            a.aO = Strings.nullToEmpty(videoBroadcastFragmentModel.l());
        }
        GraphQLMedia a2 = builder.a();
        GraphQLStoryAttachment.Builder a3 = GraphQLStoryAttachment.Builder.a(o);
        a3.l = a2;
        GraphQLStoryAttachment a4 = a3.a();
        GraphQLTextWithEntities.Builder builder2 = new GraphQLTextWithEntities.Builder();
        builder2.i = this.f4672c.getString(2131232832, new Object[]{StoryActorHelper.b(graphQLStory).aa()});
        GraphQLTextWithEntities a5 = builder2.a();
        GraphQLStory$Builder a6 = GraphQLStory$Builder.m3407a(graphQLStory);
        a6.f3180F = this.f4670a.a();
        a6 = a6;
        a6.f3210m = ImmutableList.of(a4);
        GraphQLStory$Builder graphQLStory$Builder = a6;
        graphQLStory$Builder.ay = a5;
        graphQLStory = graphQLStory$Builder.m3419a();
        o.r().b();
        this.f4671b.a(new FeedUnitMutatedEvent(graphQLStory));
        return graphQLStory;
    }
}

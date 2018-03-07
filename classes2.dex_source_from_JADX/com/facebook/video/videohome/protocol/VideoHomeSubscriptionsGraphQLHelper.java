package com.facebook.video.videohome.protocol;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.LiveVideoBroadcastStatusUpdateSubscribeInputData;
import com.facebook.graphql.calls.VideoHomeBadgeUpdateSubscribeInputData;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionConnectorException;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptions.LiveVideoBroadcastStatusUpdateSubscriptionString;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsModels.LiveVideoBroadcastStatusUpdateSubscriptionModel;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: goodwill_lcau_survey_new_trigger */
public class VideoHomeSubscriptionsGraphQLHelper {
    private static final String f22159a = VideoHomeSubscriptionsGraphQLHelper.class.getSimpleName();
    public final GraphQLSubscriptionConnector f22160b;
    private final VideoLivePlaybackConfig f22161c;

    @Inject
    public VideoHomeSubscriptionsGraphQLHelper(GraphQLSubscriptionConnector graphQLSubscriptionConnector, VideoLivePlaybackConfig videoLivePlaybackConfig) {
        this.f22160b = graphQLSubscriptionConnector;
        this.f22161c = videoLivePlaybackConfig;
    }

    private static VideoHomeSubscriptions$VideoHomeBadgeSubString m30039a(String str) {
        GraphQlCallInput videoHomeBadgeUpdateSubscribeInputData = new VideoHomeBadgeUpdateSubscribeInputData();
        videoHomeBadgeUpdateSubscribeInputData.m11397a("user_id", str);
        videoHomeBadgeUpdateSubscribeInputData = videoHomeBadgeUpdateSubscribeInputData;
        GraphQlQueryString videoHomeSubscriptions$VideoHomeBadgeSubString = new VideoHomeSubscriptions$VideoHomeBadgeSubString();
        videoHomeSubscriptions$VideoHomeBadgeSubString.m11310a("input", videoHomeBadgeUpdateSubscribeInputData);
        return videoHomeSubscriptions$VideoHomeBadgeSubString;
    }

    @Nullable
    public final GraphQLSubscriptionHandle<VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel> m30041a(String str, FutureCallback<VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel> futureCallback) {
        GraphQLSubscriptionHandle<VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel> graphQLSubscriptionHandle = null;
        try {
            graphQLSubscriptionHandle = this.f22160b.m9386a(m30039a(str), futureCallback);
        } catch (GraphQLSubscriptionConnectorException e) {
            BLog.b(f22159a, "Video Home badge update subscription failed. %s", e);
        }
        return graphQLSubscriptionHandle;
    }

    private LiveVideoBroadcastStatusUpdateSubscriptionString m30040b(String str) {
        GraphQlCallInput a = new LiveVideoBroadcastStatusUpdateSubscribeInputData().a(str);
        GraphQlQueryString liveVideoBroadcastStatusUpdateSubscriptionString = new LiveVideoBroadcastStatusUpdateSubscriptionString();
        liveVideoBroadcastStatusUpdateSubscriptionString.m11310a("input", a);
        if (this.f22161c.f9121Y) {
            liveVideoBroadcastStatusUpdateSubscriptionString.m11315a("scrubbing", "MPEG_DASH");
        }
        return liveVideoBroadcastStatusUpdateSubscriptionString;
    }

    @Nullable
    public final GraphQLSubscriptionHandle<LiveVideoBroadcastStatusUpdateSubscriptionModel> m30042b(String str, FutureCallback<LiveVideoBroadcastStatusUpdateSubscriptionModel> futureCallback) {
        GraphQLSubscriptionHandle<LiveVideoBroadcastStatusUpdateSubscriptionModel> graphQLSubscriptionHandle = null;
        try {
            graphQLSubscriptionHandle = this.f22160b.m9386a(m30040b(str), futureCallback);
        } catch (GraphQLSubscriptionConnectorException e) {
            BLog.b(f22159a, "Live video broadcast status update subscription failed. %s", e);
        }
        return graphQLSubscriptionHandle;
    }

    public final void m30043b(GraphQLSubscriptionHandle<LiveVideoBroadcastStatusUpdateSubscriptionModel> graphQLSubscriptionHandle) {
        Set hashSet = new HashSet();
        hashSet.add(graphQLSubscriptionHandle);
        this.f22160b.m9388a(hashSet);
    }
}

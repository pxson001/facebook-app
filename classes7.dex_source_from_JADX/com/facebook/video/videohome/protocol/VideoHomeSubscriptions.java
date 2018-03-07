package com.facebook.video.videohome.protocol;

import com.facebook.graphql.query.TypedGraphQLSubscriptionString;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsModels.LiveVideoBroadcastStatusUpdateSubscriptionModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: dictionary */
public final class VideoHomeSubscriptions {

    /* compiled from: dictionary */
    public class LiveVideoBroadcastStatusUpdateSubscriptionString extends TypedGraphQLSubscriptionString<LiveVideoBroadcastStatusUpdateSubscriptionModel> {
        public LiveVideoBroadcastStatusUpdateSubscriptionString() {
            super(LiveVideoBroadcastStatusUpdateSubscriptionModel.class, false, "LiveVideoBroadcastStatusUpdateSubscription", "c1fef5fb1ffaf5bd593ec0326ae47d41", "live_video_broadcast_status_update_subscribe", "0", "10154668614021729", RegularImmutableSet.a);
        }

        public final String m19752a(String str) {
            switch (str.hashCode()) {
                case -631654088:
                    return "1";
                case -561505403:
                    return "4";
                case 100358090:
                    return "0";
                case 159461928:
                    return "2";
                case 580042479:
                    return "3";
                case 651215103:
                    return "5";
                default:
                    return str;
            }
        }
    }
}

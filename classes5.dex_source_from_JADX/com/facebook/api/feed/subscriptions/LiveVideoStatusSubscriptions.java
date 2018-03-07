package com.facebook.api.feed.subscriptions;

import com.facebook.api.feed.subscriptions.LiveVideoStatusSubscriptionsModels.LiveVideoStatusUpdateSubscriptionModel;
import com.facebook.graphql.query.TypedGraphQLSubscriptionString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: artist_names */
public final class LiveVideoStatusSubscriptions {

    /* compiled from: artist_names */
    public class LiveVideoStatusUpdateSubscriptionString extends TypedGraphQLSubscriptionString<LiveVideoStatusUpdateSubscriptionModel> {
        public LiveVideoStatusUpdateSubscriptionString() {
            super(LiveVideoStatusUpdateSubscriptionModel.class, false, "LiveVideoStatusUpdateSubscription", "1c170c2fc6a912458d10db6b6c02f5ec", "live_video_broadcast_status_update_subscribe", "0", "10154614223416729", RegularImmutableSet.a);
        }

        public final String m14678a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

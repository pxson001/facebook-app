package com.facebook.facecastdisplay.protocol;

import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.FetchLiveReactionsQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.FetchLiveVODReactionsQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.LiveReactionSubscriptionModel;
import com.facebook.facecastdisplay.protocol.FetchLiveReactionsQueryModels.LiveReactionsAddStreamingReactionMutationFragmentModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.query.TypedGraphQLSubscriptionString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: store_conversion_notification_shown */
public final class FetchLiveReactionsQuery {

    /* compiled from: store_conversion_notification_shown */
    public class FetchLiveReactionsQueryString extends TypedGraphQlQueryString<FetchLiveReactionsQueryModel> {
        public FetchLiveReactionsQueryString() {
            super(FetchLiveReactionsQueryModel.class, false, "FetchLiveReactionsQuery", "aeb204b5f0bbd266771ae5263f904f33", "video", "10154479939086729", RegularImmutableSet.a);
        }

        public final String m3314a(String str) {
            switch (str.hashCode()) {
                case -441951636:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: store_conversion_notification_shown */
    public class FetchLiveVODReactionsQueryString extends TypedGraphQlQueryString<FetchLiveVODReactionsQueryModel> {
        public FetchLiveVODReactionsQueryString() {
            super(FetchLiveVODReactionsQueryModel.class, false, "FetchLiveVODReactionsQuery", "79bfa8c67845b7934a00b28f3d2fd96c", "video", "10154564785046729", RegularImmutableSet.a);
        }

        public final String m3315a(String str) {
            switch (str.hashCode()) {
                case -1992012396:
                    return "2";
                case -441951636:
                    return "0";
                case 525895283:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: store_conversion_notification_shown */
    public class LiveReactionSubscriptionString extends TypedGraphQLSubscriptionString<LiveReactionSubscriptionModel> {
        public LiveReactionSubscriptionString() {
            super(LiveReactionSubscriptionModel.class, false, "LiveReactionSubscription", "1c9f6d89ba2754ee951a0dfda1211337", "feedback_add_streaming_reaction_subscribe", "0", "10154481464086729", RegularImmutableSet.a);
        }

        public final String m3316a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: store_conversion_notification_shown */
    public class LiveReactionsAddStreamingReactionMutationString extends TypedGraphQLMutationString<LiveReactionsAddStreamingReactionMutationFragmentModel> {
        public LiveReactionsAddStreamingReactionMutationString() {
            super(LiveReactionsAddStreamingReactionMutationFragmentModel.class, false, "LiveReactionsAddStreamingReactionMutation", "f48449e35f90a00a715ae1b03a9043f9", "feedback_add_streaming_reaction", "0", "10154661257966729", RegularImmutableSet.a);
        }

        public final String m3317a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final FetchLiveReactionsQueryString m3318a() {
        return new FetchLiveReactionsQueryString();
    }

    public static final LiveReactionSubscriptionString m3319d() {
        return new LiveReactionSubscriptionString();
    }
}

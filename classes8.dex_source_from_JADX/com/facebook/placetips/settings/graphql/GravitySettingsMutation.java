package com.facebook.placetips.settings.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.placetips.settings.graphql.GravitySettingsMutationModels.GravityBlacklistFeedbackMutationModel;
import com.facebook.placetips.settings.graphql.GravitySettingsMutationModels.GravityNegativeFeedbackMutationModel;
import com.facebook.placetips.settings.graphql.GravitySettingsMutationModels.GravitySettingsMutationModel;
import com.facebook.placetips.settings.graphql.GravitySettingsMutationModels.GravityUnblacklistFeedbackMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: run_query */
public final class GravitySettingsMutation {

    /* compiled from: run_query */
    public class GravityBlacklistFeedbackMutationString extends TypedGraphQLMutationString<GravityBlacklistFeedbackMutationModel> {
        public GravityBlacklistFeedbackMutationString() {
            super(GravityBlacklistFeedbackMutationModel.class, false, "GravityBlacklistFeedbackMutation", "79b4f785aa442d7ad53d287eab9340b0", "viewer_blacklist_page_from_gravity", "0", "10154204804951729", RegularImmutableSet.a);
        }

        public final String m3892a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: run_query */
    public class GravityNegativeFeedbackMutationString extends TypedGraphQLMutationString<GravityNegativeFeedbackMutationModel> {
        public GravityNegativeFeedbackMutationString() {
            super(GravityNegativeFeedbackMutationModel.class, false, "GravityNegativeFeedbackMutation", "6975c68de5c68db991686dab72ec62e7", "gravity_negative_feedback", "0", "10154204805001729", RegularImmutableSet.a);
        }

        public final String m3893a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: run_query */
    public class GravitySettingsMutationString extends TypedGraphQLMutationString<GravitySettingsMutationModel> {
        public GravitySettingsMutationString() {
            super(GravitySettingsMutationModel.class, false, "GravitySettingsMutation", "1c881cfe901e7303f10c4ef9aa5acee6", "gravity_settings_for_user_update", "0", "10154343226781729", RegularImmutableSet.a);
        }

        public final String m3894a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: run_query */
    public class GravityUnblacklistFeedbackMutationString extends TypedGraphQLMutationString<GravityUnblacklistFeedbackMutationModel> {
        public GravityUnblacklistFeedbackMutationString() {
            super(GravityUnblacklistFeedbackMutationModel.class, false, "GravityUnblacklistFeedbackMutation", "51cec9be589da4bcb496e106edc02876", "viewer_unblacklist_page_from_gravity", "0", "10154204804956729", RegularImmutableSet.a);
        }

        public final String m3895a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

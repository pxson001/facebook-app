package com.facebook.goodwill.feed.protocol;

import com.facebook.goodwill.feed.protocol.FetchThrowbackSettingsGraphQLModels.ThrowbackSettingsSubscriptionMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: fetchMoreAlbumsList_%s */
public final class FetchThrowbackSettingsGraphQL {

    /* compiled from: fetchMoreAlbumsList_%s */
    public class ThrowbackSettingsSubscriptionMutationString extends TypedGraphQLMutationString<ThrowbackSettingsSubscriptionMutationModel> {
        public ThrowbackSettingsSubscriptionMutationString() {
            super(ThrowbackSettingsSubscriptionMutationModel.class, false, "ThrowbackSettingsSubscriptionMutation", "9cadaf0ba3f6960bcb83f0defb33c6d6", "throwback_settings_edit", "0", "10154204803431729", RegularImmutableSet.a);
        }

        public final String m15240a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

package com.facebook.zero.onboarding.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.zero.onboarding.graphql.AssistedOnboardingModels.AssistedRegSendInviteWithSourceModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: minutiae_story_attachment_null */
public final class AssistedOnboarding {

    /* compiled from: minutiae_story_attachment_null */
    public class AssistedRegSendInviteWithSourceString extends TypedGraphQLMutationString<AssistedRegSendInviteWithSourceModel> {
        public AssistedRegSendInviteWithSourceString() {
            super(AssistedRegSendInviteWithSourceModel.class, false, "AssistedRegSendInviteWithSource", "d609fa2315a657d0b36a1317f7ff6583", "assisted_reg_send_invite_with_source", "0", "10154204805701729", RegularImmutableSet.a);
        }

        public final String m6615a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final AssistedRegSendInviteWithSourceString m6616a() {
        return new AssistedRegSendInviteWithSourceString();
    }
}

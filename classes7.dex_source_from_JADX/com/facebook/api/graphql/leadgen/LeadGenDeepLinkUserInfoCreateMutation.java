package com.facebook.api.graphql.leadgen;

import com.facebook.api.graphql.leadgen.LeadGenDeepLinkUserInfoCreateMutationModels.LeadGenDeepLinkUserInfoCoreMutationFieldsModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: video_home_badge_update_reason */
public final class LeadGenDeepLinkUserInfoCreateMutation {

    /* compiled from: video_home_badge_update_reason */
    public class LeadGenDeepLinkUserInfoCreateMutationString extends TypedGraphQLMutationString<LeadGenDeepLinkUserInfoCoreMutationFieldsModel> {
        public LeadGenDeepLinkUserInfoCreateMutationString() {
            super(LeadGenDeepLinkUserInfoCoreMutationFieldsModel.class, false, "LeadGenDeepLinkUserInfoCreateMutation", "807b170c6fb3a32c6f885279bfce4837", "lead_gen_deep_link_user_info_create", "0", "10154211701796729", RegularImmutableSet.a);
        }

        public final String m592a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

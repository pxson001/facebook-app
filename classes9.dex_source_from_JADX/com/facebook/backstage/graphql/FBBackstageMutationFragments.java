package com.facebook.backstage.graphql;

import com.facebook.backstage.graphql.FBBackstageMutationFragmentsModels.FBBackstageClearBadgeMutationModel;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsModels.FBBackstagePostsDeleteMutationFragmentModel;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsModels.FBBackstageSeenStateMutationFragmentModel;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsModels.FBBackstageUpdateAudienceModeMutationModel;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsModels.UpdateWhiteListMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: requesteeId */
public final class FBBackstageMutationFragments {

    /* compiled from: requesteeId */
    public class FBBackstageClearBadgeMutationString extends TypedGraphQLMutationString<FBBackstageClearBadgeMutationModel> {
        public FBBackstageClearBadgeMutationString() {
            super(FBBackstageClearBadgeMutationModel.class, false, "FBBackstageClearBadgeMutation", "34f119f83461c10fcfedcf542701a4ad", "backstage_space_update_seen_time", "0", "10154204802631729", RegularImmutableSet.a);
        }

        public final String m4989a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: requesteeId */
    public class FBBackstagePostsDeleteMutationString extends TypedGraphQLMutationString<FBBackstagePostsDeleteMutationFragmentModel> {
        public FBBackstagePostsDeleteMutationString() {
            super(FBBackstagePostsDeleteMutationFragmentModel.class, false, "FBBackstagePostsDeleteMutation", "d5dc583103fffabefa7d169924de42e3", "backstage_posts_delete", "0", "10154392594361729", RegularImmutableSet.a);
        }

        public final String m4990a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: requesteeId */
    public class FBBackstageSeenMutationString extends TypedGraphQLMutationString<FBBackstageSeenStateMutationFragmentModel> {
        public FBBackstageSeenMutationString() {
            super(FBBackstageSeenStateMutationFragmentModel.class, false, "FBBackstageSeenMutation", "2574176629b9c6005a82eec03f6310bd", "backstage_post_update_seen_state", "0", "10154204802676729", RegularImmutableSet.a);
        }

        public final String m4991a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: requesteeId */
    public class FBBackstageUpdateAudienceModeMutationString extends TypedGraphQLMutationString<FBBackstageUpdateAudienceModeMutationModel> {
        public FBBackstageUpdateAudienceModeMutationString() {
            super(FBBackstageUpdateAudienceModeMutationModel.class, false, "FBBackstageUpdateAudienceModeMutation", "689d39f7eab4fcc9c9995b73017efd69", "backstage_user_update_audience_mode", "0", "10154376528161729", RegularImmutableSet.a);
        }

        public final String m4992a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: requesteeId */
    public class UpdateWhiteListMutationString extends TypedGraphQLMutationString<UpdateWhiteListMutationModel> {
        public UpdateWhiteListMutationString() {
            super(UpdateWhiteListMutationModel.class, false, "UpdateWhiteListMutation", "84534e8168641ae1992fb55fcffd03cb", "backstage_user_update_whitelisted_friends", "0", "10154374462881729", RegularImmutableSet.a);
        }

        public final String m4993a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

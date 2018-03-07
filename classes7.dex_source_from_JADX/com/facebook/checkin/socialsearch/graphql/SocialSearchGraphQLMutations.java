package com.facebook.checkin.socialsearch.graphql;

import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLMutationsModels.AddPlaceListItemToCommentMutationModel;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLMutationsModels.DeletePlaceRecommendationFromCommentMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: undefined */
public final class SocialSearchGraphQLMutations {

    /* compiled from: undefined */
    public class AddPlaceListItemToCommentMutationString extends TypedGraphQLMutationString<AddPlaceListItemToCommentMutationModel> {
        public AddPlaceListItemToCommentMutationString() {
            super(AddPlaceListItemToCommentMutationModel.class, false, "AddPlaceListItemToCommentMutation", "a238ba6b2e5670eccb3a104fa9673c2e", "comment_add_place", "0", "10154661551181729", RegularImmutableSet.a);
        }

        public final String m1163a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: undefined */
    public class DeletePlaceRecommendationFromCommentMutationString extends TypedGraphQLMutationString<DeletePlaceRecommendationFromCommentMutationModel> {
        public DeletePlaceRecommendationFromCommentMutationString() {
            super(DeletePlaceRecommendationFromCommentMutationModel.class, false, "DeletePlaceRecommendationFromCommentMutation", "1090181660ea64f47fa08f8f53cf99a3", "comment_place_recommendation_delete", "0", "10154661551191729", RegularImmutableSet.a);
        }

        public final String m1164a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

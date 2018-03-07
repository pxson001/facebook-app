package com.facebook.timeline.editfeaturedcontainers.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.timeline.editfeaturedcontainers.protocol.AddFeaturedContainerMutationModels.AddFeaturedContainerMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: goodwill_throwback_feed */
public final class AddFeaturedContainerMutation {

    /* compiled from: goodwill_throwback_feed */
    public class AddFeaturedContainerMutationString extends TypedGraphQLMutationString<AddFeaturedContainerMutationModel> {
        public AddFeaturedContainerMutationString() {
            super(AddFeaturedContainerMutationModel.class, false, "AddFeaturedContainerMutation", "8712791dde10a9837089f3451ad7c3ce", "profile_intro_card_add_featured_container", "0", "10154580748286729", RegularImmutableSet.a);
        }

        public final String m10791a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

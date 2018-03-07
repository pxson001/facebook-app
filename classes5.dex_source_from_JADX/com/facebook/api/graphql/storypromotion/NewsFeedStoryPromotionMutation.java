package com.facebook.api.graphql.storypromotion;

import com.facebook.api.graphql.storypromotion.NewsFeedStoryPromotionMutationModels.AYMTLogEventMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: target_entity */
public final class NewsFeedStoryPromotionMutation {

    /* compiled from: target_entity */
    public class AYMTLogEventMutationString extends TypedGraphQLMutationString<AYMTLogEventMutationModel> {
        public AYMTLogEventMutationString() {
            super(AYMTLogEventMutationModel.class, false, "AYMTLogEventMutation", "4c8c99513f0d414b47692e02d94f8614", "aymt_log_event", "0", "10154577510491729", RegularImmutableSet.a);
        }

        public final String m2973a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

package com.facebook.checkin.socialsearch.graphql;

import com.facebook.checkin.socialsearch.graphql.PlaceListMutationsModels.ConvertToPlaceListStoryMutationCallModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: unity_type */
public final class PlaceListMutations {

    /* compiled from: unity_type */
    public class ConvertToPlaceListStoryMutationCallString extends TypedGraphQLMutationString<ConvertToPlaceListStoryMutationCallModel> {
        public ConvertToPlaceListStoryMutationCallString() {
            super(ConvertToPlaceListStoryMutationCallModel.class, false, "ConvertToPlaceListStoryMutationCall", "ebc9239c8710f5fd6673e0f70e3d970f", "placelist_story_convert", "0", "10154386483566729", RegularImmutableSet.a);
        }

        public final String m1071a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

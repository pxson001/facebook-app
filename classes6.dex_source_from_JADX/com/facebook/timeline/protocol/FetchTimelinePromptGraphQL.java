package com.facebook.timeline.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.protocol.FetchTimelinePromptGraphQLModels.TimelinePromptModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: deletePhotoAlbumParams */
public final class FetchTimelinePromptGraphQL {

    /* compiled from: deletePhotoAlbumParams */
    public class TimelineFirstUnitsViewingSelfPromptString extends TypedGraphQlQueryString<TimelinePromptModel> {
        public TimelineFirstUnitsViewingSelfPromptString() {
            super(TimelinePromptModel.class, false, "TimelineFirstUnitsViewingSelfPrompt", "8a4aef010da7159def267fe5009d25c7", "user", "10154405445856729", RegularImmutableSet.a);
        }

        public final String m26128a(String str) {
            switch (str.hashCode()) {
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

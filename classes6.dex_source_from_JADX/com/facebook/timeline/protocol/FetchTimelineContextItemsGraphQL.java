package com.facebook.timeline.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.protocol.FetchTimelineContextItemsGraphQLModels.TimelineContextItemsQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: deltaAdminRemovedFromGroupThread */
public final class FetchTimelineContextItemsGraphQL {

    /* compiled from: deltaAdminRemovedFromGroupThread */
    public class TimelineContextItemsQueryString extends TypedGraphQlQueryString<TimelineContextItemsQueryModel> {
        public TimelineContextItemsQueryString() {
            super(TimelineContextItemsQueryModel.class, false, "TimelineContextItemsQuery", "daa77ca52d9fe4b2127efc171851dca8", "user", "10154595788861729", RegularImmutableSet.a);
        }

        public final String m25656a(String str) {
            switch (str.hashCode()) {
                case -1685391298:
                    return "2";
                case -1102636175:
                    return "0";
                case -154818044:
                    return "3";
                case 689802720:
                    return "4";
                case 1511637484:
                    return "1";
                default:
                    return str;
            }
        }
    }
}

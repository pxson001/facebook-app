package com.facebook.composer.privacy.common.graphql;

import com.facebook.composer.privacy.common.graphql.FetchEventDetailsGraphQLModels.EventDetailsModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: tapped_photos_by_page */
public final class FetchEventDetailsGraphQL {

    /* compiled from: tapped_photos_by_page */
    public class EventDetailsQueryString extends TypedGraphQlQueryString<EventDetailsModel> {
        public EventDetailsQueryString() {
            super(EventDetailsModel.class, false, "EventDetailsQuery", "22c7a550ac2f31f9f12a038cd44c434a", "event", "10154651461351729", RegularImmutableSet.a);
        }

        public final String m1995a(String str) {
            switch (str.hashCode()) {
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

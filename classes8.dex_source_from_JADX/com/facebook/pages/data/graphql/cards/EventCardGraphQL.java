package com.facebook.pages.data.graphql.cards;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLModels.EventCardQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: context_items_source_id */
public final class EventCardGraphQL {

    /* compiled from: context_items_source_id */
    public class EventCardQueryString extends TypedGraphQlQueryString<EventCardQueryModel> {
        public EventCardQueryString() {
            super(EventCardQueryModel.class, false, "EventCardQuery", "c5c55936676a93efb3ca87c98618c2f0", "page", "10154429039286729", RegularImmutableSet.a);
        }

        public final String m20360a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "2";
                case -803548981:
                    return "0";
                case 455773445:
                    return "1";
                default:
                    return str;
            }
        }
    }
}

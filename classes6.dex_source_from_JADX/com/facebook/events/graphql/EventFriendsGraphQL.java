package com.facebook.events.graphql;

import com.facebook.events.graphql.EventFriendsGraphQLModels.EventFriendsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: nux_flow_close */
public final class EventFriendsGraphQL {

    /* compiled from: nux_flow_close */
    public class EventFriendsQueryString extends TypedGraphQlQueryString<EventFriendsQueryModel> {
        public EventFriendsQueryString() {
            super(EventFriendsQueryModel.class, false, "EventFriendsQuery", "162082afd6964b17f8f3135150aad612", "event", "10154429038126729", RegularImmutableSet.a);
        }

        public final String m12700a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

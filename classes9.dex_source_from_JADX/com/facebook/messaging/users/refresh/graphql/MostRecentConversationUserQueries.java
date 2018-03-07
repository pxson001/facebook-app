package com.facebook.messaging.users.refresh.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.users.refresh.graphql.MostRecentConversationUserQueriesModels.UsersAfterTimeQueryModel;
import com.google.common.collect.ImmutableSet;

/* compiled from: chat_head_duration_overall */
public final class MostRecentConversationUserQueries {

    /* compiled from: chat_head_duration_overall */
    public class UsersAfterTimeQueryString extends TypedGraphQlQueryString<UsersAfterTimeQueryModel> {
        public UsersAfterTimeQueryString() {
            super(UsersAfterTimeQueryModel.class, false, "UsersAfterTimeQuery", "92de38a15085dd65f35611324a446172", "viewer", "10154352441481729", ImmutableSet.of("user_id"));
        }

        public final String m18281a(String str) {
            switch (str.hashCode()) {
                case -1916788491:
                    return "0";
                case 94851343:
                    return "1";
                default:
                    return str;
            }
        }
    }
}

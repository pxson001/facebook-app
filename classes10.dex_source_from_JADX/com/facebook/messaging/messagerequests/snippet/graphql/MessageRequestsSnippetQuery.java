package com.facebook.messaging.messagerequests.snippet.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.messagerequests.snippet.graphql.MessageRequestsSnippetQueryModels.MessageRequestsSnippetModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: saved2/ */
public final class MessageRequestsSnippetQuery {

    /* compiled from: saved2/ */
    public class MessageRequestsSnippetString extends TypedGraphQlQueryString<MessageRequestsSnippetModel> {
        public MessageRequestsSnippetString() {
            super(MessageRequestsSnippetModel.class, false, "MessageRequestsSnippet", "17855773977996e9ddde84b2f035837b", "viewer", "10154609124871729", RegularImmutableSet.a);
        }

        public final String m3183a(String str) {
            switch (str.hashCode()) {
                case -1844444419:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

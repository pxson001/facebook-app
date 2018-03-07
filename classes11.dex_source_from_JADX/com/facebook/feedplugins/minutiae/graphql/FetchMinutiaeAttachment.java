package com.facebook.feedplugins.minutiae.graphql;

import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: contact_message */
public final class FetchMinutiaeAttachment {

    /* compiled from: contact_message */
    public class FetchAttachmentString extends TypedGraphQlQueryString<GraphQLNode> {
        public FetchAttachmentString() {
            super(GraphQLNode.class, false, "FetchAttachment", "661a3d7980ad655a49c4e9d6a25048b6", "node", "10154478301451729", RegularImmutableSet.a);
        }

        public final String m9073a(String str) {
            switch (str.hashCode()) {
                case -1489595877:
                    return "0";
                case -1101600581:
                    return "1";
                default:
                    return str;
            }
        }
    }
}

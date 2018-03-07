package com.facebook.groups.feed.protocol;

import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: reaction_ */
public final class FetchFeedbackForStories {

    /* compiled from: reaction_ */
    public class FetchBaseFeedbackForStoriesString extends TypedGraphQlQueryString<Map<String, GraphQLNode>> {
        public FetchBaseFeedbackForStoriesString() {
            super(GraphQLNode.class, true, "FetchBaseFeedbackForStories", "511c6ca505a4a602bfbb82a11a58c256", "nodes", "10154633956101729", RegularImmutableSet.a);
        }

        public final String m6241a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case -1012194872:
                    return "4";
                case -817257615:
                    return "2";
                case 1710767214:
                    return "0";
                case 1963391292:
                    return "3";
                default:
                    return str;
            }
        }
    }
}

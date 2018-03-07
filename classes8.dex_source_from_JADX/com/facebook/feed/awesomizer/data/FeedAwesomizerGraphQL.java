package com.facebook.feed.awesomizer.data;

import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardQueryModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverTopicQueryModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerSeefirstCardQueryModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerUnfollowingQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: has_made_first_issuer_mistake */
public final class FeedAwesomizerGraphQL {

    /* compiled from: has_made_first_issuer_mistake */
    public class FeedAwesomizerDiscoverCardQueryString extends TypedGraphQlQueryString<FeedAwesomizerDiscoverCardQueryModel> {
        public FeedAwesomizerDiscoverCardQueryString() {
            super(FeedAwesomizerDiscoverCardQueryModel.class, false, "FeedAwesomizerDiscoverCardQuery", "4959677a1eef53d1bcedf9757dc006e6", "feed_topic_list", "10154429038341729", RegularImmutableSet.a);
        }

        public final String m13506a(String str) {
            switch (str.hashCode()) {
                case -1920592040:
                    return "4";
                case -1284978202:
                    return "2";
                case -306509:
                    return "3";
                case 692733304:
                    return "5";
                case 715769505:
                    return "1";
                case 1034555848:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: has_made_first_issuer_mistake */
    public class FeedAwesomizerDiscoverTopicQueryString extends TypedGraphQlQueryString<FeedAwesomizerDiscoverTopicQueryModel> {
        public FeedAwesomizerDiscoverTopicQueryString() {
            super(FeedAwesomizerDiscoverTopicQueryModel.class, false, "FeedAwesomizerDiscoverTopicQuery", "0c92012b100666700cd929a3b5770877", "node", "10154429038356729", RegularImmutableSet.a);
        }

        public final String m13507a(String str) {
            switch (str.hashCode()) {
                case -1920592040:
                    return "5";
                case -1284978202:
                    return "3";
                case -957291989:
                    return "0";
                case -306509:
                    return "4";
                case 16907033:
                    return "1";
                case 667404419:
                    return "2";
                case 692733304:
                    return "6";
                default:
                    return str;
            }
        }
    }

    /* compiled from: has_made_first_issuer_mistake */
    public class FeedAwesomizerFollowingQueryString extends TypedGraphQlQueryString<FeedAwesomizerFollowingQueryModel> {
        public FeedAwesomizerFollowingQueryString() {
            super(FeedAwesomizerFollowingQueryModel.class, false, "FeedAwesomizerFollowingQuery", "8282ac503318a6fdb6d24e6fb86b7f2f", "viewer", "10154429038321729", RegularImmutableSet.a);
        }

        public final String m13508a(String str) {
            switch (str.hashCode()) {
                case -306509:
                    return "2";
                case 16907033:
                    return "0";
                case 667404419:
                    return "1";
                case 692733304:
                    return "3";
                default:
                    return str;
            }
        }
    }

    /* compiled from: has_made_first_issuer_mistake */
    public class FeedAwesomizerSeefirstCardQueryString extends TypedGraphQlQueryString<FeedAwesomizerSeefirstCardQueryModel> {
        public FeedAwesomizerSeefirstCardQueryString() {
            super(FeedAwesomizerSeefirstCardQueryModel.class, false, "FeedAwesomizerSeefirstCardQuery", "ffabab0d2c77219656918068dd430ae2", "viewer", "10154429038351729", RegularImmutableSet.a);
        }

        public final String m13509a(String str) {
            switch (str.hashCode()) {
                case -306509:
                    return "2";
                case 16907033:
                    return "0";
                case 667404419:
                    return "1";
                case 692733304:
                    return "3";
                default:
                    return str;
            }
        }
    }

    /* compiled from: has_made_first_issuer_mistake */
    public class FeedAwesomizerUnfollowingQueryString extends TypedGraphQlQueryString<FeedAwesomizerUnfollowingQueryModel> {
        public FeedAwesomizerUnfollowingQueryString() {
            super(FeedAwesomizerUnfollowingQueryModel.class, false, "FeedAwesomizerUnfollowingQuery", "1761c69a6b570e0da9fd31e0f591bdb1", "viewer", "10154429038331729", RegularImmutableSet.a);
        }

        public final String m13510a(String str) {
            switch (str.hashCode()) {
                case -306509:
                    return "2";
                case 16907033:
                    return "0";
                case 667404419:
                    return "1";
                case 692733304:
                    return "3";
                default:
                    return str;
            }
        }
    }
}

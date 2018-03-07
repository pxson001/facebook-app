package com.facebook.api.graphql.fetchstories;

import com.facebook.api.graphql.fetchstories.FetchInvalidStoriesGraphQlModels.FetchInvalidStoriesModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: android_suggest_edits_bookmark */
public final class FetchInvalidStoriesGraphQl {

    /* compiled from: android_suggest_edits_bookmark */
    public class FetchInvalidStoriesString extends TypedGraphQlQueryString<Map<String, FetchInvalidStoriesModel>> {
        public FetchInvalidStoriesString() {
            super(FetchInvalidStoriesModel.class, true, "FetchInvalidStories", "8dbca268c48d1d06cf2fd764ef4257e2", "nodes", "10152728399871729", RegularImmutableSet.a);
        }

        public final String m16673a(String str) {
            switch (str.hashCode()) {
                case 104120:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final FetchInvalidStoriesString m16674a() {
        return new FetchInvalidStoriesString();
    }
}

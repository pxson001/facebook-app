package com.facebook.privacy.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: sticker_packs_reordered */
public class FetchComposerPrivacyOptions$StoryPrivacyOptionsQueryString extends TypedGraphQlQueryString<GraphQLStory> {
    public FetchComposerPrivacyOptions$StoryPrivacyOptionsQueryString() {
        super(GraphQLStory.class, false, "StoryPrivacyOptionsQuery", "e02a923a1b4f55b7de8eed25b61f208c", "node", "10154658546111729", RegularImmutableSet.a);
    }

    public final TriState m6053g() {
        return TriState.NO;
    }

    public final String m6052a(String str) {
        switch (str.hashCode()) {
            case 1717754021:
                return "0";
            default:
                return str;
        }
    }
}

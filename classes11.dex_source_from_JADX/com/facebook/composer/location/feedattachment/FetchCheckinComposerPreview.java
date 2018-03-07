package com.facebook.composer.location.feedattachment;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: from_cache */
public final class FetchCheckinComposerPreview {

    /* compiled from: from_cache */
    public class FetchCheckinComposerPreviewString extends TypedGraphQlQueryString<GraphQLPlace> {
        public FetchCheckinComposerPreviewString() {
            super(GraphQLPlace.class, false, "FetchCheckinComposerPreview", "5afe9c1992fe75cbb2fc39d044dd5f89", "page", "10154616531416729", RegularImmutableSet.a);
        }

        public final TriState m8138g() {
            return TriState.NO;
        }

        public final String m8137a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

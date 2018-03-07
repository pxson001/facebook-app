package com.facebook.privacy.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: ridge_android_xconfig */
public final class FetchComposerPrivacyGuardrailInfo {

    /* compiled from: ridge_android_xconfig */
    public class FetchComposerPrivacyGuardrailInfoString extends TypedGraphQlQueryString<GraphQLViewer> {
        public FetchComposerPrivacyGuardrailInfoString() {
            super(GraphQLViewer.class, false, "FetchComposerPrivacyGuardrailInfo", "8744422a2b3ff84148cfd2f79e314019", "viewer", "10154343226746729", RegularImmutableSet.a);
        }

        public final TriState m3565g() {
            return TriState.NO;
        }
    }
}

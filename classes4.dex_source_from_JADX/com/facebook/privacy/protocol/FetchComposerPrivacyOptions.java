package com.facebook.privacy.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: sms_in_anonymous_row_mode */
public final class FetchComposerPrivacyOptions {

    /* compiled from: sms_in_anonymous_row_mode */
    public class ComposerPrivacyOptionsQueryString extends TypedGraphQlQueryString<GraphQLViewer> {
        public ComposerPrivacyOptionsQueryString() {
            super(GraphQLViewer.class, false, "ComposerPrivacyOptionsQuery", "116001515f478990a52ff413531fe881", "viewer", "10154661259321729", RegularImmutableSet.a);
        }

        public final TriState m2207g() {
            return TriState.NO;
        }
    }
}

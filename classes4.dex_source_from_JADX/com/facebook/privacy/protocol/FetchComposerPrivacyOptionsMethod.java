package com.facebook.privacy.protocol;

import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.privacy.protocol.FetchComposerPrivacyOptions.ComposerPrivacyOptionsQueryString;
import com.fasterxml.jackson.core.JsonParser;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sms_internal_force_legacy_api */
public final class FetchComposerPrivacyOptionsMethod extends AbstractPersistedGraphQlApiMethod<Void, GraphQLViewer> {
    @Inject
    public FetchComposerPrivacyOptionsMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object m2200a(@Nullable Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        apiResponse.i();
        return (GraphQLViewer) jsonParser.a(GraphQLViewer.class);
    }

    public final int m2201b(@Nullable Object obj, ApiResponse apiResponse) {
        return 1;
    }

    public final GraphQlQueryString m2202f(@Nullable Object obj) {
        return new ComposerPrivacyOptionsQueryString();
    }
}

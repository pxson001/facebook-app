package com.facebook.privacy.protocol;

import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.protocol.FetchComposerPrivacyGuardrailInfo.FetchComposerPrivacyGuardrailInfoString;
import com.fasterxml.jackson.core.JsonParser;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: row_tags_count */
public final class FetchComposerPrivacyGuardrailInfoMethod extends AbstractPersistedGraphQlApiMethod<Void, GraphQLViewer> {
    public static FetchComposerPrivacyGuardrailInfoMethod m3546b(InjectorLike injectorLike) {
        return new FetchComposerPrivacyGuardrailInfoMethod(GraphQLProtocolHelper.a(injectorLike));
    }

    @Inject
    public FetchComposerPrivacyGuardrailInfoMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object m3547a(@Nullable Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        apiResponse.i();
        return (GraphQLViewer) jsonParser.a(GraphQLViewer.class);
    }

    public final GraphQlQueryString m3549f(@Nullable Object obj) {
        return new FetchComposerPrivacyGuardrailInfoString();
    }

    public final int m3548b(@Nullable Object obj, ApiResponse apiResponse) {
        return 1;
    }
}

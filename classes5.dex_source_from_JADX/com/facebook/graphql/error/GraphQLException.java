package com.facebook.graphql.error;

import android.os.Parcelable;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiErrorResult.Builder;
import com.facebook.http.protocol.ApiErrorResult.ErrorDomain;
import com.facebook.http.protocol.ApiException;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: limit must be >= 0 */
public class GraphQLException extends ApiException {
    public final GraphQLError error;

    @VisibleForTesting
    public GraphQLException(GraphQLError graphQLError) {
        Builder a = ApiErrorResult.a(graphQLError.code, graphQLError.description);
        a.d = graphQLError.debugInfo;
        super(a.a(ErrorDomain.GRAPHQL_KERROR_DOMAIN).a());
        this.error = graphQLError;
    }

    public final /* synthetic */ Parcelable m6245a() {
        return this.error;
    }

    public final /* synthetic */ ApiErrorResult m6246b() {
        return this.error;
    }
}

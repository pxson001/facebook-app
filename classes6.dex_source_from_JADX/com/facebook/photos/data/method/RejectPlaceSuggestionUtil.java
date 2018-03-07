package com.facebook.photos.data.method;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: http_headers */
public class RejectPlaceSuggestionUtil {
    public final String f12955a;
    public final GraphQLQueryExecutor f12956b;

    public static RejectPlaceSuggestionUtil m20324a(InjectorLike injectorLike) {
        return new RejectPlaceSuggestionUtil(String_LoggedInUserIdMethodAutoProvider.b(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public RejectPlaceSuggestionUtil(String str, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f12955a = str;
        this.f12956b = graphQLQueryExecutor;
    }
}

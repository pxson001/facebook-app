package com.facebook.photos.data.method;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: image_large_preview */
public class AcceptPlaceSuggestionUtil {
    public final String f12884a;
    public final GraphQLQueryExecutor f12885b;

    public static AcceptPlaceSuggestionUtil m20267a(InjectorLike injectorLike) {
        return new AcceptPlaceSuggestionUtil(String_LoggedInUserIdMethodAutoProvider.b(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public AcceptPlaceSuggestionUtil(String str, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f12884a = str;
        this.f12885b = graphQLQueryExecutor;
    }
}

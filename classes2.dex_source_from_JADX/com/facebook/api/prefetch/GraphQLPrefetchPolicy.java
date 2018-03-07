package com.facebook.api.prefetch;

import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: postSurveyImpressionsParams */
public abstract class GraphQLPrefetchPolicy<T> {
    public abstract GraphQLRequest<T> mo1924a(String str);

    public abstract boolean mo1926a(GraphQLResult<T> graphQLResult);

    public abstract String mo1929c();

    public int mo1927b() {
        return (int) TimeUnit.DAYS.toSeconds(1);
    }

    public boolean mo1930d() {
        return false;
    }

    public boolean mo1931e() {
        return true;
    }

    public boolean mo1925a(GraphQLPrefetchPriority graphQLPrefetchPriority) {
        return graphQLPrefetchPriority.isAtLeast(GraphQLPrefetchPriority.HIGH);
    }

    @Nullable
    public GraphQLRequest<T> mo1928b(String str) {
        return null;
    }

    public int mo1932f() {
        return 10;
    }

    public boolean m14381g() {
        return false;
    }
}

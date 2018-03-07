package com.facebook.timeline.datafetcher;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObservable;
import com.google.common.base.Function;

/* compiled from: group_calling_button */
public class GraphQLResultNullChecker {

    /* compiled from: group_calling_button */
    final class C15291 implements Function<GraphQLResult<T>, T> {
        C15291() {
        }

        public final Object apply(Object obj) {
            Object obj2 = ((GraphQLResult) obj).e;
            if (obj2 != null) {
                return obj2;
            }
            throw new IllegalArgumentException("Expected GraphQLResult#getResult() to return a non-null value");
        }
    }

    /* compiled from: group_calling_button */
    final class C15302 implements Function<GraphQLResult<T>, GraphQLResult<T>> {
        C15302() {
        }

        public final Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e != null) {
                return graphQLResult;
            }
            throw new IllegalArgumentException("Expected GraphQLResult#getResult() to return a non-null value");
        }
    }

    public static <T> RequestObservable<T> m10532a(RequestObservable<GraphQLResult<T>> requestObservable) {
        return requestObservable.a(new C15291());
    }

    public static <T> RequestObservable<GraphQLResult<T>> m10533b(RequestObservable<GraphQLResult<T>> requestObservable) {
        return requestObservable.a(new C15302());
    }
}

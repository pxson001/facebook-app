package com.facebook.dialtone.protocol;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: log_sponsored_image_load_state */
public class DialtonePhotoQuotaAPIHandler {
    public GraphQLQueryExecutor f16258a;

    public static DialtonePhotoQuotaAPIHandler m23080b(InjectorLike injectorLike) {
        return new DialtonePhotoQuotaAPIHandler(GraphQLQueryExecutor.m10435a(injectorLike));
    }

    @Inject
    public DialtonePhotoQuotaAPIHandler(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f16258a = graphQLQueryExecutor;
    }
}

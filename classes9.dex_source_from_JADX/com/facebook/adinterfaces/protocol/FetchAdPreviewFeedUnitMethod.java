package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.protocol.AdInterfacesAdPreviewQueryModels.AdInterfacesAdPreviewFeedUnitQueryModel;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Warning */
public class FetchAdPreviewFeedUnitMethod {
    private AdInterfacesErrorReporter f22335a;
    private ObjectMapper f22336b;
    private final GraphQLQueryExecutor f22337c;
    private final AdInterfacesQueryBuilder f22338d;

    @Inject
    public FetchAdPreviewFeedUnitMethod(AdInterfacesErrorReporter adInterfacesErrorReporter, ObjectMapper objectMapper, GraphQLQueryExecutor graphQLQueryExecutor, AdInterfacesQueryBuilder adInterfacesQueryBuilder) {
        this.f22335a = adInterfacesErrorReporter;
        this.f22336b = objectMapper;
        this.f22337c = graphQLQueryExecutor;
        this.f22338d = adInterfacesQueryBuilder;
    }

    @Nullable
    public final GraphQLQueryFuture<GraphQLResult<AdInterfacesAdPreviewFeedUnitQueryModel>> m24096a(String str, CreativeAdModel creativeAdModel) {
        try {
            GraphQLRequest a = this.f22338d.m23055a(str, this.f22336b.a(creativeAdModel.m22866h()));
            a.a(CallerContext.a(getClass()));
            return this.f22337c.a(a);
        } catch (Throwable e) {
            this.f22335a.m22727a(FetchAdPreviewFeedUnitMethod.class, "Error converting ad creative", e);
            return null;
        }
    }
}

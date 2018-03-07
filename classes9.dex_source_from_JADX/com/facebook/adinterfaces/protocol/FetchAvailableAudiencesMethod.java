package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.protocol.FetchAvailableAudiencesQueryModels.FetchAvailableAudiencesQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: WS */
public class FetchAvailableAudiencesMethod {
    private final GraphQLQueryExecutor f22341a;
    private final AdInterfacesQueryBuilder f22342b;

    /* compiled from: WS */
    public /* synthetic */ class C25431 {
        public static final /* synthetic */ int[] f22340a = new int[ObjectiveType.values().length];

        static {
            try {
                f22340a[ObjectiveType.PAGE_LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22340a[ObjectiveType.PROMOTE_CTA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22340a[ObjectiveType.PROMOTE_WEBSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public FetchAvailableAudiencesMethod(GraphQLQueryExecutor graphQLQueryExecutor, AdInterfacesQueryBuilder adInterfacesQueryBuilder) {
        this.f22341a = graphQLQueryExecutor;
        this.f22342b = adInterfacesQueryBuilder;
    }

    public final ListenableFuture<GraphQLResult<FetchAvailableAudiencesQueryModel>> m24108a(String str, String str2, String str3, int i, ObjectiveType objectiveType) {
        Preconditions.checkNotNull(str2);
        return this.f22341a.a(this.f22342b.m23056a(str, str2, str3, i, objectiveType));
    }
}

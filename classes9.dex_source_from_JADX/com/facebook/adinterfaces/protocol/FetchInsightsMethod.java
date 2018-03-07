package com.facebook.adinterfaces.protocol;

import android.content.Intent;
import android.support.annotation.Nullable;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionInsightsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.Builder;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import javax.inject.Inject;

/* compiled from: WAIT_FOR_NEXT_READY */
public class FetchInsightsMethod {
    public final GraphQLQueryExecutor f22368a;
    private final AdInterfacesQueryBuilder f22369b;

    /* compiled from: WAIT_FOR_NEXT_READY */
    public class C25461 implements Function<GraphQLResult<StoryPromotionInsightsModel>, AdInterfacesBoostPostDataModel> {
        final /* synthetic */ String f22365a;
        final /* synthetic */ Intent f22366b;
        final /* synthetic */ FetchInsightsMethod f22367c;

        public C25461(FetchInsightsMethod fetchInsightsMethod, String str, Intent intent) {
            this.f22367c = fetchInsightsMethod;
            this.f22365a = str;
            this.f22366b = intent;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((StoryPromotionInsightsModel) graphQLResult.e).m23688j() == null) {
                return null;
            }
            Builder builder = new Builder();
            builder.f22244c = ((StoryPromotionInsightsModel) graphQLResult.e).m23688j();
            builder = builder;
            builder.f22243b = ((StoryPromotionInsightsModel) graphQLResult.e).m23684a();
            StoryPromotionModel a = builder.m23689a();
            BaseAdInterfacesData.Builder builder2 = new AdInterfacesBoostPostDataModel.Builder();
            builder2.f21732b = ObjectiveType.BOOST_POST_INSIGHTS;
            builder2 = builder2;
            builder2.f21742l = "boosted_post_mobile";
            AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel = (AdInterfacesBoostPostDataModel) builder2.mo950a();
            adInterfacesBoostPostDataModel.f21780a = a;
            adInterfacesBoostPostDataModel.f21781b = this.f22365a;
            adInterfacesBoostPostDataModel.f21786g = this.f22366b;
            return adInterfacesBoostPostDataModel;
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    /* compiled from: WAIT_FOR_NEXT_READY */
    public enum Key {
        FETCH_INSIGHTS
    }

    @Inject
    public FetchInsightsMethod(GraphQLQueryExecutor graphQLQueryExecutor, AdInterfacesQueryBuilder adInterfacesQueryBuilder) {
        this.f22368a = graphQLQueryExecutor;
        this.f22369b = adInterfacesQueryBuilder;
    }
}

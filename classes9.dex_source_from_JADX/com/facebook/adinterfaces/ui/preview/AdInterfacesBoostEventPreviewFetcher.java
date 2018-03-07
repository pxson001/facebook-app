package com.facebook.adinterfaces.ui.preview;

import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.events.AdInterfacesBoostEventDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesBoostEventAdPreviewQuery.FBEventPromotionAdPreviewFeedUnitQueryString;
import com.facebook.adinterfaces.protocol.AdInterfacesBoostEventAdPreviewQueryModels.FBEventPromotionAdPreviewFeedUnitQueryModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryBuilder;
import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewController.AdInterfacesNativePreviewFetcher;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.EventSpec.EventBoostType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unknown message id type to send  */
public class AdInterfacesBoostEventPreviewFetcher implements AdInterfacesNativePreviewFetcher<AdInterfacesBoostEventDataModel> {
    private final GraphQLQueryExecutor f23192a;
    private final AdInterfacesQueryBuilder f23193b;

    /* compiled from: Unknown message id type to send  */
    class C27301 implements Function<GraphQLResult<FBEventPromotionAdPreviewFeedUnitQueryModel>, FeedUnit> {
        final /* synthetic */ AdInterfacesBoostEventPreviewFetcher f23191a;

        C27301(AdInterfacesBoostEventPreviewFetcher adInterfacesBoostEventPreviewFetcher) {
            this.f23191a = adInterfacesBoostEventPreviewFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FBEventPromotionAdPreviewFeedUnitQueryModel) graphQLResult.e).m23016j() == null) {
                return null;
            }
            return ((FBEventPromotionAdPreviewFeedUnitQueryModel) graphQLResult.e).m23016j().m23007a();
        }
    }

    public static AdInterfacesBoostEventPreviewFetcher m25160b(InjectorLike injectorLike) {
        return new AdInterfacesBoostEventPreviewFetcher(GraphQLQueryExecutor.a(injectorLike), AdInterfacesQueryBuilder.m23051a(injectorLike));
    }

    public final ListenableFuture mo1037a(BaseAdInterfacesData baseAdInterfacesData) {
        AdInterfacesBoostEventDataModel adInterfacesBoostEventDataModel = (AdInterfacesBoostEventDataModel) baseAdInterfacesData;
        GraphQLQueryExecutor graphQLQueryExecutor = this.f23192a;
        AdInterfacesQueryBuilder adInterfacesQueryBuilder = this.f23193b;
        String str = adInterfacesBoostEventDataModel.f21781b;
        EventBoostType eventBoostType = adInterfacesBoostEventDataModel.f21806b;
        GraphQlQueryString fBEventPromotionAdPreviewFeedUnitQueryString = new FBEventPromotionAdPreviewFeedUnitQueryString();
        fBEventPromotionAdPreviewFeedUnitQueryString.a("story_id", str).a("event_boost_type", eventBoostType.toString()).a("image_large_aspect_height", adInterfacesQueryBuilder.f21932a.z()).a("image_large_aspect_width", adInterfacesQueryBuilder.f21932a.y());
        return Futures.a(graphQLQueryExecutor.a(GraphQLRequest.a(fBEventPromotionAdPreviewFeedUnitQueryString)), new C27301(this), MoreExecutors.a());
    }

    @Inject
    public AdInterfacesBoostEventPreviewFetcher(GraphQLQueryExecutor graphQLQueryExecutor, AdInterfacesQueryBuilder adInterfacesQueryBuilder) {
        this.f23192a = graphQLQueryExecutor;
        this.f23193b = adInterfacesQueryBuilder;
    }
}

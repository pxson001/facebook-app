package com.facebook.adinterfaces.ui.preview;

import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesAdPreviewQueryModels.AdInterfacesAdPreviewFeedUnitQueryModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryBuilder;
import com.facebook.adinterfaces.protocol.FetchAdPreviewFeedUnitMethod;
import com.facebook.adinterfaces.ui.AdInterfacesNativePreviewViewController.AdInterfacesNativePreviewFetcher;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unknown media error */
public class AdInterfacesBoostedComponentPreviewFetcher implements AdInterfacesNativePreviewFetcher<AdInterfacesBoostedComponentDataModel> {
    private final AdInterfacesDataHelper f23195a;
    private final FetchAdPreviewFeedUnitMethod f23196b;

    /* compiled from: Unknown media error */
    class C27311 implements Function<GraphQLResult<AdInterfacesAdPreviewFeedUnitQueryModel>, FeedUnit> {
        final /* synthetic */ AdInterfacesBoostedComponentPreviewFetcher f23194a;

        C27311(AdInterfacesBoostedComponentPreviewFetcher adInterfacesBoostedComponentPreviewFetcher) {
            this.f23194a = adInterfacesBoostedComponentPreviewFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return null;
            }
            return ((AdInterfacesAdPreviewFeedUnitQueryModel) graphQLResult.e).m22998j();
        }
    }

    public static AdInterfacesBoostedComponentPreviewFetcher m25162b(InjectorLike injectorLike) {
        return new AdInterfacesBoostedComponentPreviewFetcher(AdInterfacesDataHelper.m22789a(injectorLike), new FetchAdPreviewFeedUnitMethod(AdInterfacesErrorReporter.m22724a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), AdInterfacesQueryBuilder.m23051a(injectorLike)));
    }

    public final ListenableFuture mo1037a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = (AdInterfacesBoostedComponentDataModel) baseAdInterfacesData;
        return Futures.a(this.f23196b.m24096a(AdInterfacesDataHelper.m22792a(baseAdInterfacesData, baseAdInterfacesData.m22853i()).m23145s(), baseAdInterfacesData.mo951C()), new C27311(this), MoreExecutors.a());
    }

    @Inject
    public AdInterfacesBoostedComponentPreviewFetcher(AdInterfacesDataHelper adInterfacesDataHelper, FetchAdPreviewFeedUnitMethod fetchAdPreviewFeedUnitMethod) {
        this.f23195a = adInterfacesDataHelper;
        this.f23196b = fetchAdPreviewFeedUnitMethod;
    }
}

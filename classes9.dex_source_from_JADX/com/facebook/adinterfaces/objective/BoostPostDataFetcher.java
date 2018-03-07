package com.facebook.adinterfaces.objective;

import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.model.events.AdInterfacesBoostEventDataModel.Builder;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryBuilder;
import com.facebook.adinterfaces.protocol.FetchPromotionMethod;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.executor.GraphQLBatchRequestProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.google.common.base.Function;
import com.google.common.base.Functions.IdentityFunction;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: [\-\./] */
public class BoostPostDataFetcher {
    private final FetchPromotionMethod f21852a;
    public final AdInterfacesDataHelper f21853b;
    public final AdInterfacesErrorReporter f21854c;

    public static BoostPostDataFetcher m22923a(InjectorLike injectorLike) {
        return new BoostPostDataFetcher(new FetchPromotionMethod(GraphQLQueryExecutor.a(injectorLike), (GraphQLBatchRequestProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GraphQLBatchRequestProvider.class), AdInterfacesQueryBuilder.m23051a(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike)), AdInterfacesDataHelper.m22789a(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike));
    }

    @Inject
    public BoostPostDataFetcher(FetchPromotionMethod fetchPromotionMethod, AdInterfacesDataHelper adInterfacesDataHelper, AdInterfacesErrorReporter adInterfacesErrorReporter) {
        this.f21852a = fetchPromotionMethod;
        this.f21853b = adInterfacesDataHelper;
        this.f21854c = adInterfacesErrorReporter;
    }

    public final void m22926a(String str, String str2, String str3, final String str4, String str5, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        m22924a(ObjectiveType.BOOST_EVENT, str, str2, str3, str5, adInterfacesDataModel$AdInterfacesDataModelCallback, new Function<AdInterfacesBoostPostDataModel, AdInterfacesBoostPostDataModel>(this) {
            final /* synthetic */ BoostPostDataFetcher f21845b;

            public Object apply(Object obj) {
                AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel = (AdInterfacesBoostPostDataModel) obj;
                if (adInterfacesBoostPostDataModel == null) {
                    return null;
                }
                Builder builder = new Builder();
                builder.f21804a = str4;
                Object c = builder.m22894c();
                c.m22873a(adInterfacesBoostPostDataModel);
                c.f21754j.m22838a(GraphQLBoostedPostAudienceOption.NCPP);
                c.f21756l = "boosted_event_mobile";
                return c;
            }
        });
    }

    public final void m22925a(String str, String str2, String str3, String str4, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        m22924a(ObjectiveType.BOOST_POST, str, str2, str3, str4, adInterfacesDataModel$AdInterfacesDataModelCallback, IdentityFunction.INSTANCE);
    }

    private void m22924a(ObjectiveType objectiveType, String str, String str2, String str3, String str4, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback, Function<AdInterfacesBoostPostDataModel, AdInterfacesBoostPostDataModel> function) {
        final String str5 = str4;
        final String str6 = str3;
        final AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback2 = adInterfacesDataModel$AdInterfacesDataModelCallback;
        final Function<AdInterfacesBoostPostDataModel, AdInterfacesBoostPostDataModel> function2 = function;
        this.f21852a.m24234a(objectiveType, str, str2, str3, new Object(this) {
            public AdInterfacesBoostPostDataModel f21846a;
            public final /* synthetic */ BoostPostDataFetcher f21851f;
        });
    }
}

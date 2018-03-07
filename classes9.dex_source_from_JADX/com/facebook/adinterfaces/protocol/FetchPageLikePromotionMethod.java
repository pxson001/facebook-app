package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.BaseAdInterfacesData.Builder;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchModels.BoostedComponentDataQueryModel;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: WAITING_FOR_ANIMATION_TO_FINISH */
public class FetchPageLikePromotionMethod extends FetchBoostedComponentDataMethod<AdInterfacesBoostedComponentDataModel> {
    private final AdInterfacesErrorReporter f22371a;

    public static FetchPageLikePromotionMethod m24171b(InjectorLike injectorLike) {
        return new FetchPageLikePromotionMethod(GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), AdInterfacesEventBus.m22728a(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike));
    }

    @Inject
    public FetchPageLikePromotionMethod(GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, AdInterfacesEventBus adInterfacesEventBus, AdInterfacesDataHelper adInterfacesDataHelper, AdInterfacesErrorReporter adInterfacesErrorReporter) {
        super(graphQLQueryExecutor, graphQLImageHelper, graphQLStoryHelper, adInterfacesEventBus, tasksManager, adInterfacesDataHelper);
        this.f22371a = adInterfacesErrorReporter;
    }

    protected final String mo978a() {
        return "page_like_promotion_key";
    }

    protected final BaseAdInterfacesData mo976a(BoostedComponentDataQueryModel boostedComponentDataQueryModel, String str) {
        Builder builder = new AdInterfacesBoostedComponentDataModel.Builder();
        builder.f21788a = mo977a(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21789b = mo979b(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21742l = "boosted_page_like_mobile";
        builder = builder;
        builder.f21731a = boostedComponentDataQueryModel.m24010l();
        builder = builder;
        builder.f21733c = str;
        builder = builder;
        builder.f21734d = m24138c(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21732b = ObjectiveType.PAGE_LIKE;
        builder = builder;
        builder.f21743m = m24139d(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21744n = m24140e(boostedComponentDataQueryModel);
        return (AdInterfacesBoostedComponentDataModel) builder.mo950a();
    }

    protected final CreativeAdModel mo977a(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        if (mo979b(boostedComponentDataQueryModel) == null || mo979b(boostedComponentDataQueryModel).m23349p() == null) {
            String b;
            this.f22371a.m22726a(getClass(), "Default Spec is null");
            if (boostedComponentDataQueryModel.m24013o() != null) {
                b = boostedComponentDataQueryModel.m24013o().m23167a().m23163a().b();
            } else {
                b = boostedComponentDataQueryModel.m24019u().b();
            }
            CreativeAdModel.Builder builder = new CreativeAdModel.Builder();
            builder.f21762c = boostedComponentDataQueryModel.m24014p();
            builder = builder;
            builder.f21767h = b;
            CreativeAdModel.Builder builder2 = builder;
            builder2.f21764e = boostedComponentDataQueryModel.m24008j().m23502a();
            builder2 = builder2;
            builder2.f21760a = GraphQLCallToActionType.LIKE_PAGE;
            return builder2.m22863a();
        }
        DefaultCreativeSpecModel k = mo979b(boostedComponentDataQueryModel).m23349p().m23313k();
        builder = new CreativeAdModel.Builder();
        builder.f21762c = boostedComponentDataQueryModel.m24014p();
        builder = builder;
        builder.f21767h = k.m23304j();
        builder = builder;
        builder.f21764e = k.m23303a();
        builder2 = builder;
        builder2.f21760a = GraphQLCallToActionType.LIKE_PAGE;
        return builder2.m22863a();
    }

    @Nullable
    protected final BoostedComponentModel mo979b(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        if (boostedComponentDataQueryModel.m24010l() == null || boostedComponentDataQueryModel.m24010l().m23188l() == null || boostedComponentDataQueryModel.m24010l().m23188l().m23522a().isEmpty()) {
            return null;
        }
        return (BoostedComponentModel) boostedComponentDataQueryModel.m24010l().m23188l().m23522a().get(0);
    }
}

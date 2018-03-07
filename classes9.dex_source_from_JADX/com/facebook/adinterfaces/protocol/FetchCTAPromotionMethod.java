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
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchModels.BoostedComponentDataQueryModel;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchModels.BoostedComponentDataQueryModel.PageCallToActionModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: WATCH_AND_SHOP */
public class FetchCTAPromotionMethod extends FetchBoostedComponentDataMethod<AdInterfacesBoostedComponentDataModel> {
    private final AdInterfacesErrorReporter f22364a;

    public static FetchCTAPromotionMethod m24160b(InjectorLike injectorLike) {
        return new FetchCTAPromotionMethod(GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), AdInterfacesEventBus.m22728a(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike));
    }

    @Inject
    public FetchCTAPromotionMethod(GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, AdInterfacesEventBus adInterfacesEventBus, AdInterfacesDataHelper adInterfacesDataHelper, AdInterfacesErrorReporter adInterfacesErrorReporter) {
        super(graphQLQueryExecutor, graphQLImageHelper, graphQLStoryHelper, adInterfacesEventBus, tasksManager, adInterfacesDataHelper);
        this.f22364a = adInterfacesErrorReporter;
    }

    protected final String mo978a() {
        return "cta_promotion_key";
    }

    protected final BaseAdInterfacesData mo976a(BoostedComponentDataQueryModel boostedComponentDataQueryModel, String str) {
        Builder builder = new AdInterfacesBoostedComponentDataModel.Builder();
        builder.f21788a = mo977a(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21789b = mo979b(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21731a = boostedComponentDataQueryModel.m24010l();
        builder = builder;
        builder.f21733c = str;
        builder = builder;
        builder.f21734d = m24138c(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21732b = ObjectiveType.PROMOTE_CTA;
        builder = builder;
        builder.f21742l = "boosted_cta_mobile";
        builder = builder;
        builder.f21743m = m24139d(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21744n = m24140e(boostedComponentDataQueryModel);
        return (AdInterfacesBoostedComponentDataModel) builder.mo950a();
    }

    protected final CreativeAdModel mo977a(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        BoostedComponentModel b = mo979b(boostedComponentDataQueryModel);
        PageCallToActionModel s = boostedComponentDataQueryModel.m24017s();
        if (b.m23349p() == null || b.m23349p().m23313k() == null || b.m23349p().m23313k().m23305k() == null || b.m23349p().m23313k().m23305k().m23296a() == null) {
            String b2;
            this.f22364a.m22726a(getClass(), "Default Spec is null");
            if (boostedComponentDataQueryModel.m24013o() != null) {
                b2 = boostedComponentDataQueryModel.m24013o().m23167a().m23163a().b();
            } else {
                b2 = boostedComponentDataQueryModel.m24019u().b();
            }
            CreativeAdModel.Builder builder = new CreativeAdModel.Builder();
            builder.f21762c = boostedComponentDataQueryModel.m24014p();
            builder = builder;
            builder.f21763d = boostedComponentDataQueryModel.m24016r();
            builder = builder;
            builder.f21764e = boostedComponentDataQueryModel.m24008j().m23502a();
            builder = builder;
            builder.f21765f = s.m23987j();
            builder = builder;
            builder.f21767h = b2;
            CreativeAdModel.Builder builder2 = builder;
            builder2.f21760a = s.m23985a();
            builder2 = builder2;
            builder2.f21761b = s.m23987j();
            return builder2.m22863a();
        }
        LinkDataModel a = b.m23349p().m23313k().m23305k().m23296a();
        builder = new CreativeAdModel.Builder();
        builder.f21762c = boostedComponentDataQueryModel.m24014p();
        builder = builder;
        builder.f21763d = boostedComponentDataQueryModel.m24016r();
        builder = builder;
        builder.f21764e = a.m23292b();
        builder = builder;
        builder.f21765f = a.m23291a();
        builder = builder;
        builder.f21767h = a.m23293c();
        builder2 = builder;
        builder2.f21760a = s.m23985a();
        builder2 = builder2;
        builder2.f21761b = s.m23987j();
        return builder2.m22863a();
    }

    @Nullable
    protected final BoostedComponentModel mo979b(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        if (boostedComponentDataQueryModel.m24010l() == null || boostedComponentDataQueryModel.m24010l().m23186j() == null || boostedComponentDataQueryModel.m24010l().m23186j().m23539a().isEmpty()) {
            return null;
        }
        return (BoostedComponentModel) boostedComponentDataQueryModel.m24010l().m23186j().m23539a().get(0);
    }
}

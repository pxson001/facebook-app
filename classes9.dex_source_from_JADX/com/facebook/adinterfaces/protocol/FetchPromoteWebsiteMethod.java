package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.BaseAdInterfacesData.Builder;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.websitepromotion.AdInterfacesWebsitePromotionDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchModels.BoostedComponentDataQueryModel;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VideoMetadata */
public class FetchPromoteWebsiteMethod extends FetchBoostedComponentDataMethod<AdInterfacesWebsitePromotionDataModel> {
    private final AdInterfacesErrorReporter f22381a;

    public static FetchPromoteWebsiteMethod m24225a(InjectorLike injectorLike) {
        return new FetchPromoteWebsiteMethod(GraphQLQueryExecutor.a(injectorLike), GraphQLImageHelper.a(injectorLike), GraphQLStoryHelper.a(injectorLike), AdInterfacesEventBus.m22728a(injectorLike), TasksManager.b(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike));
    }

    @Inject
    public FetchPromoteWebsiteMethod(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLImageHelper graphQLImageHelper, GraphQLStoryHelper graphQLStoryHelper, AdInterfacesEventBus adInterfacesEventBus, TasksManager tasksManager, AdInterfacesDataHelper adInterfacesDataHelper, AdInterfacesErrorReporter adInterfacesErrorReporter) {
        super(graphQLQueryExecutor, graphQLImageHelper, graphQLStoryHelper, adInterfacesEventBus, tasksManager, adInterfacesDataHelper);
        this.f22381a = adInterfacesErrorReporter;
    }

    protected final String mo978a() {
        return "promote_website_key";
    }

    protected final BaseAdInterfacesData mo976a(BoostedComponentDataQueryModel boostedComponentDataQueryModel, String str) {
        Builder builder = new AdInterfacesWebsitePromotionDataModel.Builder();
        builder.f21788a = mo977a(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21789b = mo979b(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21742l = "boosted_website_mobile";
        builder = builder;
        builder.f21731a = boostedComponentDataQueryModel.m24010l();
        builder = builder;
        builder.f21733c = str;
        builder = builder;
        builder.f21732b = ObjectiveType.PROMOTE_WEBSITE;
        builder = builder;
        builder.f21734d = m24138c(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21743m = m24139d(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21744n = m24140e(boostedComponentDataQueryModel);
        AdInterfacesWebsitePromotionDataModel adInterfacesWebsitePromotionDataModel = (AdInterfacesWebsitePromotionDataModel) builder.mo950a();
        adInterfacesWebsitePromotionDataModel.c_(m24226f(boostedComponentDataQueryModel));
        return adInterfacesWebsitePromotionDataModel;
    }

    protected final CreativeAdModel mo977a(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        String b;
        if (mo979b(boostedComponentDataQueryModel).m23349p() == null || mo979b(boostedComponentDataQueryModel).m23349p().m23313k() == null || mo979b(boostedComponentDataQueryModel).m23349p().m23313k().m23305k() == null || mo979b(boostedComponentDataQueryModel).m23349p().m23313k().m23305k().m23296a() == null) {
            this.f22381a.m22726a(getClass(), "Default Spec is null");
            if (boostedComponentDataQueryModel.m24013o() != null) {
                b = boostedComponentDataQueryModel.m24013o().m23167a().m23163a().b();
            } else {
                b = boostedComponentDataQueryModel.m24019u().b();
            }
            CreativeAdModel.Builder builder = new CreativeAdModel.Builder();
            builder.f21762c = boostedComponentDataQueryModel.m24014p();
            builder = builder;
            builder.f21763d = boostedComponentDataQueryModel.m24016r();
            builder = builder;
            builder.f21764e = boostedComponentDataQueryModel.m24008j().m23502a();
            builder = builder;
            builder.f21765f = m24226f(boostedComponentDataQueryModel);
            builder = builder;
            builder.f21760a = GraphQLCallToActionType.NO_BUTTON;
            builder = builder;
            builder.f21767h = b;
            return builder.m22863a();
        }
        LinkDataModel a = mo979b(boostedComponentDataQueryModel).m23349p().m23313k().m23305k().m23296a();
        b = a.m23292b();
        if (b == null && boostedComponentDataQueryModel.m24008j() != null) {
            b = boostedComponentDataQueryModel.m24008j().m23502a();
        }
        String c = a.m23293c();
        if (c == null) {
            c = boostedComponentDataQueryModel.m24013o() != null ? boostedComponentDataQueryModel.m24013o().m23167a().m23163a().b() : boostedComponentDataQueryModel.m24019u().b();
        }
        CreativeAdModel.Builder builder2 = new CreativeAdModel.Builder();
        builder2.f21762c = boostedComponentDataQueryModel.m24014p();
        builder2 = builder2;
        builder2.f21763d = boostedComponentDataQueryModel.m24016r();
        builder2 = builder2;
        builder2.f21764e = b;
        CreativeAdModel.Builder builder3 = builder2;
        builder3.f21765f = m24226f(boostedComponentDataQueryModel);
        builder3 = builder3;
        builder3.f21760a = GraphQLCallToActionType.NO_BUTTON;
        builder3 = builder3;
        builder3.f21767h = c;
        return builder3.m22863a();
    }

    @Nullable
    protected final BoostedComponentModel mo979b(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        if (boostedComponentDataQueryModel.m24010l() == null || boostedComponentDataQueryModel.m24010l().m23190n() == null || boostedComponentDataQueryModel.m24010l().m23190n().m23596a().isEmpty()) {
            return null;
        }
        return (BoostedComponentModel) boostedComponentDataQueryModel.m24010l().m23190n().m23596a().get(0);
    }

    private static String m24226f(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        if (boostedComponentDataQueryModel.m24022x().isEmpty()) {
            return "";
        }
        return (String) boostedComponentDataQueryModel.m24022x().get(0);
    }
}

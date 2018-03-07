package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.BaseAdInterfacesData.Builder;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.localawareness.AdInterfacesLocalAwarenessDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchModels.BoostedComponentDataQueryModel;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchModels.BoostedComponentDataQueryModel.AllPhonesModel;
import com.facebook.adinterfaces.util.targeting.AdInterfacesTargetingDelegate;
import com.facebook.common.locale.Locales;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: WAITING_FOR_SURFACE */
public class FetchLocalAwarenessDataMethod extends FetchBoostedComponentDataMethod<AdInterfacesLocalAwarenessDataModel> {
    private final Locales f22370a;

    public static FetchLocalAwarenessDataMethod m24165b(InjectorLike injectorLike) {
        return new FetchLocalAwarenessDataMethod(GraphQLImageHelper.a(injectorLike), GraphQLStoryHelper.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), AdInterfacesEventBus.m22728a(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike), Locales.a(injectorLike));
    }

    @Inject
    public FetchLocalAwarenessDataMethod(GraphQLImageHelper graphQLImageHelper, GraphQLStoryHelper graphQLStoryHelper, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, AdInterfacesEventBus adInterfacesEventBus, AdInterfacesDataHelper adInterfacesDataHelper, Locales locales) {
        super(graphQLQueryExecutor, graphQLImageHelper, graphQLStoryHelper, adInterfacesEventBus, tasksManager, adInterfacesDataHelper);
        this.f22370a = locales;
    }

    protected final String mo978a() {
        return "task_key_fetch_local_awareness_data";
    }

    protected final BaseAdInterfacesData mo976a(BoostedComponentDataQueryModel boostedComponentDataQueryModel, String str) {
        String str2;
        ImmutableList immutableList;
        BoostedComponentModel b = mo979b(boostedComponentDataQueryModel);
        Builder builder = new AdInterfacesLocalAwarenessDataModel.Builder();
        builder.f21788a = mo977a(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21789b = b;
        builder = builder;
        builder.f21742l = "boosted_local_awareness_mobile";
        builder = builder;
        builder.f21731a = boostedComponentDataQueryModel.m24010l();
        builder = builder;
        builder.f21733c = str;
        builder = builder;
        builder.f21732b = ObjectiveType.LOCAL_AWARENESS;
        builder = builder;
        builder.f21734d = m24138c(boostedComponentDataQueryModel);
        AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel = (AdInterfacesLocalAwarenessDataModel) builder.mo950a();
        adInterfacesLocalAwarenessDataModel.f21808b = boostedComponentDataQueryModel.m24021w();
        if (boostedComponentDataQueryModel.m24018t() != null) {
            adInterfacesLocalAwarenessDataModel.f21802g = boostedComponentDataQueryModel.m24018t().b();
        }
        if (boostedComponentDataQueryModel.m24022x().isEmpty()) {
            str2 = "";
        } else {
            str2 = (String) boostedComponentDataQueryModel.m24022x().get(0);
        }
        adInterfacesLocalAwarenessDataModel.c_(str2);
        adInterfacesLocalAwarenessDataModel.f21803h = m24166g(boostedComponentDataQueryModel);
        if (boostedComponentDataQueryModel.m24011m() == null || boostedComponentDataQueryModel.m24011m().isEmpty() || ((AllPhonesModel) boostedComponentDataQueryModel.m24011m().get(0)).m23977a() == null) {
            str2 = null;
        } else {
            str2 = ((AllPhonesModel) boostedComponentDataQueryModel.m24011m().get(0)).m23977a().m23534a();
        }
        adInterfacesLocalAwarenessDataModel.f21809c = str2;
        if (b == null || b.m23349p() == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = b.m23349p().m23310a();
        }
        adInterfacesLocalAwarenessDataModel.f21810d = immutableList;
        boolean z = boostedComponentDataQueryModel.m24010l() != null && boostedComponentDataQueryModel.m24010l().m23198v();
        adInterfacesLocalAwarenessDataModel.f21811e = z;
        return adInterfacesLocalAwarenessDataModel;
    }

    protected final CreativeAdModel mo977a(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        DefaultCreativeSpecModel k = mo979b(boostedComponentDataQueryModel).m23349p().m23313k();
        GraphQLCallToActionType graphQLCallToActionType = m24166g(boostedComponentDataQueryModel) == null ? GraphQLCallToActionType.NO_BUTTON : GraphQLCallToActionType.GET_DIRECTIONS;
        CreativeAdModel.Builder builder = new CreativeAdModel.Builder();
        builder.f21762c = boostedComponentDataQueryModel.m24014p();
        builder = builder;
        builder.f21763d = boostedComponentDataQueryModel.m24016r();
        builder = builder;
        builder.f21764e = k.m23305k().m23296a().m23292b();
        builder = builder;
        builder.f21765f = boostedComponentDataQueryModel.m24021w();
        builder = builder;
        builder.f21767h = k.m23305k().m23296a().m23293c();
        CreativeAdModel.Builder builder2 = builder;
        builder2.f21760a = graphQLCallToActionType;
        CreativeAdModel.Builder builder3 = builder2;
        builder3.f21761b = boostedComponentDataQueryModel.m24014p();
        return builder3.m22863a();
    }

    @Nullable
    protected final BoostedComponentModel mo979b(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        if (boostedComponentDataQueryModel.m24010l() == null || boostedComponentDataQueryModel.m24010l().m23187k() == null || boostedComponentDataQueryModel.m24010l().m23187k().m23476a().isEmpty()) {
            return null;
        }
        return (BoostedComponentModel) boostedComponentDataQueryModel.m24010l().m23187k().m23476a().get(0);
    }

    @Nullable
    private GeoLocationModel m24166g(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        DefaultLocationFieldsModel q = boostedComponentDataQueryModel.m24015q();
        if (q == null) {
            return null;
        }
        String b = boostedComponentDataQueryModel.m24009k() == null ? "" : boostedComponentDataQueryModel.m24009k().b();
        GeoLocationModel.Builder builder = new GeoLocationModel.Builder();
        builder.f22137f = q.a();
        builder = builder;
        builder.f22139h = q.b();
        GeoLocationModel.Builder builder2 = builder;
        builder2.f22132a = b;
        GeoLocationModel.Builder builder3 = builder2;
        builder3.f22141j = 2.0d;
        builder3 = builder3;
        builder3.f22135d = AdInterfacesTargetingDelegate.m25299a(this.f22370a);
        return builder3.m23431a();
    }
}

package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.BaseAdInterfacesData.Builder;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchModels.BoostedComponentDataQueryModel;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchModels.BoostedComponentDataQueryModel.TimelineStoriesModel.NodesModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: WF */
public class FetchBoostPostMethod extends FetchBoostedComponentDataMethod<AdInterfacesBoostedComponentDataModel> {
    private static FetchBoostPostMethod m24141b(InjectorLike injectorLike) {
        return new FetchBoostPostMethod(GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), AdInterfacesEventBus.m22728a(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike));
    }

    @Inject
    public FetchBoostPostMethod(GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, AdInterfacesEventBus adInterfacesEventBus, AdInterfacesDataHelper adInterfacesDataHelper) {
        super(graphQLQueryExecutor, graphQLImageHelper, graphQLStoryHelper, adInterfacesEventBus, tasksManager, adInterfacesDataHelper);
    }

    protected final String mo978a() {
        return "boosted_post_key";
    }

    protected final BaseAdInterfacesData mo976a(BoostedComponentDataQueryModel boostedComponentDataQueryModel, String str) {
        Builder builder = new AdInterfacesBoostedComponentDataModel.Builder();
        builder.f21791d = m24142f(boostedComponentDataQueryModel).m23997j();
        builder = builder;
        builder.f21788a = mo977a(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21789b = mo979b(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21742l = "boosted_post_mobile";
        builder = builder;
        builder.f21731a = boostedComponentDataQueryModel.m24010l();
        builder = builder;
        builder.f21733c = str;
        builder = builder;
        builder.f21734d = m24138c(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21732b = ObjectiveType.BOOSTED_COMPONENT_BOOST_POST;
        return (AdInterfacesBoostedComponentDataModel) builder.mo950a();
    }

    protected final CreativeAdModel mo977a(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        return null;
    }

    @Nullable
    protected final BoostedComponentModel mo979b(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        return m24142f(boostedComponentDataQueryModel).m23998k();
    }

    @Nullable
    private static NodesModel m24142f(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        return (NodesModel) boostedComponentDataQueryModel.m24020v().m24002a().get(0);
    }
}

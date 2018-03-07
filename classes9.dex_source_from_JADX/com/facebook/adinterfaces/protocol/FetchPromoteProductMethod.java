package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.BaseAdInterfacesData.Builder;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.PromoteProductInfoModel.OrderedCollectionsModel.NodesModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.PromoteProductInfoModel.OrderedCollectionsModel.NodesModel.CollectionProductItemsModel.CollectionProductItemsNodesModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.PromoteProductInfoModel.OrderedCollectionsModel.NodesModel.CollectionProductItemsModel.CollectionProductItemsNodesModel.OrderedImagesModel;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchModels.BoostedComponentDataQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VideoProber_Exception */
public class FetchPromoteProductMethod extends FetchBoostedComponentDataMethod<AdInterfacesBoostedComponentDataModel> {
    public static FetchPromoteProductMethod m24219b(InjectorLike injectorLike) {
        return new FetchPromoteProductMethod(GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), AdInterfacesEventBus.m22728a(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike));
    }

    @Inject
    public FetchPromoteProductMethod(GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, AdInterfacesEventBus adInterfacesEventBus, AdInterfacesDataHelper adInterfacesDataHelper) {
        super(graphQLQueryExecutor, graphQLImageHelper, graphQLStoryHelper, adInterfacesEventBus, tasksManager, adInterfacesDataHelper);
    }

    protected final String mo978a() {
        return "promote_product_promotion_key";
    }

    @Nullable
    private static CollectionProductItemsNodesModel m24220f(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        ImmutableList a = boostedComponentDataQueryModel.m24012n().m23591j().m23585a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) a.get(i);
            if (!nodesModel.m23580a().m23576a().isEmpty()) {
                return (CollectionProductItemsNodesModel) nodesModel.m23580a().m23576a().get(0);
            }
        }
        return null;
    }

    protected final BaseAdInterfacesData mo976a(BoostedComponentDataQueryModel boostedComponentDataQueryModel, String str) {
        CollectionProductItemsNodesModel f = m24220f(boostedComponentDataQueryModel);
        if (f == null) {
            Builder builder = new AdInterfacesBoostedComponentDataModel.Builder();
            builder.f21788a = mo977a(boostedComponentDataQueryModel);
            builder = builder;
            builder.f21789b = mo979b(boostedComponentDataQueryModel);
            builder = builder;
            builder.f21742l = "boosted_product_mobile";
            builder = builder;
            builder.f21731a = boostedComponentDataQueryModel.m24010l();
            builder = builder;
            builder.f21733c = str;
            builder = builder;
            builder.f21734d = AdInterfacesStatus.ERROR;
            builder = builder;
            builder.f21732b = ObjectiveType.PROMOTE_PRODUCT;
            return (AdInterfacesBoostedComponentDataModel) builder.mo950a();
        }
        Builder builder2 = new AdInterfacesBoostedComponentDataModel.Builder();
        builder2.f21791d = f.m23569k();
        builder = builder2;
        builder.f21788a = mo977a(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21789b = mo979b(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21742l = "boosted_product_mobile";
        builder = builder;
        builder.f21731a = boostedComponentDataQueryModel.m24010l();
        builder = builder;
        builder.f21733c = str;
        builder = builder;
        builder.f21734d = m24138c(boostedComponentDataQueryModel);
        builder = builder;
        builder.f21732b = ObjectiveType.PROMOTE_PRODUCT;
        return (AdInterfacesBoostedComponentDataModel) builder.mo950a();
    }

    protected final CreativeAdModel mo977a(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        CollectionProductItemsNodesModel f = m24220f(boostedComponentDataQueryModel);
        if (f == null) {
            return null;
        }
        String b = ((OrderedImagesModel) f.m23570l().get(0)).m23561a().b();
        CreativeAdModel.Builder builder = new CreativeAdModel.Builder();
        builder.f21762c = boostedComponentDataQueryModel.m24014p();
        builder = builder;
        builder.f21764e = f.m23568j();
        builder = builder;
        builder.f21765f = "https://www.facebook.com/commerce/products/".concat(f.m23569k());
        CreativeAdModel.Builder builder2 = builder;
        builder2.f21767h = b;
        return builder2.m22863a();
    }

    @Nullable
    protected final BoostedComponentModel mo979b(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        CollectionProductItemsNodesModel f = m24220f(boostedComponentDataQueryModel);
        if (f == null || f.m23571m() == null || f.m23571m().m23550a() == null || f.m23571m().m23550a().size() <= 0) {
            return null;
        }
        return (BoostedComponentModel) f.m23571m().m23550a().get(0);
    }
}

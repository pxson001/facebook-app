package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ErrorDialogEvent;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper.C25081;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetch.BoostedComponentDataQueryString;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchModels.BoostedComponentDataQueryModel;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: WHISTLE */
public abstract class FetchBoostedComponentDataMethod<D extends BaseAdInterfacesData> {
    private final GraphQLQueryExecutor f22349a;
    private final GraphQLImageHelper f22350b;
    private final GraphQLStoryHelper f22351c;
    public final AdInterfacesEventBus f22352d;
    private final TasksManager f22353e;
    public final AdInterfacesDataHelper f22354f;

    protected abstract D mo976a(BoostedComponentDataQueryModel boostedComponentDataQueryModel, String str);

    protected abstract CreativeAdModel mo977a(BoostedComponentDataQueryModel boostedComponentDataQueryModel);

    protected abstract String mo978a();

    protected abstract BoostedComponentModel mo979b(BoostedComponentDataQueryModel boostedComponentDataQueryModel);

    public FetchBoostedComponentDataMethod(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLImageHelper graphQLImageHelper, GraphQLStoryHelper graphQLStoryHelper, AdInterfacesEventBus adInterfacesEventBus, TasksManager tasksManager, AdInterfacesDataHelper adInterfacesDataHelper) {
        this.f22349a = graphQLQueryExecutor;
        this.f22350b = graphQLImageHelper;
        this.f22351c = graphQLStoryHelper;
        this.f22352d = adInterfacesEventBus;
        this.f22353e = tasksManager;
        this.f22354f = adInterfacesDataHelper;
    }

    private BoostedComponentDataQueryString m24131a(ObjectiveType objectiveType, String str, String str2) {
        boolean z = false;
        GraphQlQueryString a = new BoostedComponentDataQueryString().a("page_id", str).a("is_promote_website", Boolean.valueOf(objectiveType == ObjectiveType.PROMOTE_WEBSITE)).a("is_page_like", Boolean.valueOf(objectiveType == ObjectiveType.PAGE_LIKE)).a("is_local_awareness", Boolean.valueOf(objectiveType == ObjectiveType.LOCAL_AWARENESS)).a("is_promote_product", Boolean.valueOf(objectiveType == ObjectiveType.PROMOTE_PRODUCT)).a("is_boosted_post", Boolean.valueOf(objectiveType == ObjectiveType.BOOSTED_COMPONENT_BOOST_POST)).a("product_id", str2).a("fetch_saved_audiences", Boolean.valueOf(objectiveType == ObjectiveType.BOOST_POST)).a("is_cta", Boolean.valueOf(objectiveType == ObjectiveType.PROMOTE_CTA)).a("component_app", objectiveType.getComponentAppEnum()).a("res_size", this.f22351c.r()).a("cover_photo_size", this.f22351c.r()).a("image_large_aspect_height", this.f22351c.z()).a("image_large_aspect_width", this.f22351c.y());
        String str3 = "fetch_websites";
        if (objectiveType == ObjectiveType.LOCAL_AWARENESS || objectiveType == ObjectiveType.PROMOTE_WEBSITE) {
            z = true;
        }
        return (BoostedComponentDataQueryString) a.a(str3, Boolean.valueOf(z)).a("max_budgets_count", FetchBudgetRecommendationsMethod.f22361b).a("media_type", this.f22350b.b()).a("audience_count", Integer.valueOf(5));
    }

    protected final AdInterfacesStatus m24138c(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        BoostedComponentModel b = mo979b(boostedComponentDataQueryModel);
        if (b == null) {
            return AdInterfacesStatus.NEVER_BOOSTED;
        }
        AdInterfacesStatus adInterfacesStatus;
        switch (C25081.f21689b[b.m23344k().ordinal()]) {
            case 1:
                adInterfacesStatus = AdInterfacesStatus.INACTIVE;
                break;
            case 2:
                adInterfacesStatus = AdInterfacesStatus.ACTIVE;
                break;
            case 3:
                adInterfacesStatus = AdInterfacesStatus.PAUSED;
                break;
            case 4:
                adInterfacesStatus = AdInterfacesStatus.FINISHED;
                break;
            case 5:
                adInterfacesStatus = AdInterfacesStatus.REJECTED;
                break;
            case 6:
                adInterfacesStatus = AdInterfacesStatus.PENDING;
                break;
            case 7:
                adInterfacesStatus = AdInterfacesStatus.ERROR;
                break;
            case 8:
                adInterfacesStatus = AdInterfacesStatus.CREATING;
                break;
            default:
                adInterfacesStatus = AdInterfacesStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                break;
        }
        return adInterfacesStatus;
    }

    public final void m24136a(String str, ObjectiveType objectiveType, @Nullable String str2, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        m24135a(str, objectiveType, adInterfacesDataModel$AdInterfacesDataModelCallback, str2, null);
    }

    public final void m24135a(final String str, ObjectiveType objectiveType, final AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback, @Nullable final String str2, @Nullable String str3) {
        Preconditions.checkNotNull(str);
        BoostedComponentDataQueryString a = m24131a(objectiveType, str, str3);
        TasksManager tasksManager = this.f22353e;
        String a2 = mo978a();
        GraphQLQueryExecutor graphQLQueryExecutor = this.f22349a;
        GraphQLRequest a3 = GraphQLRequest.a(a);
        a3.f = CallerContext.a(getClass());
        tasksManager.a(a2, graphQLQueryExecutor.a(a3), new AbstractDisposableFutureCallback<GraphQLResult<BoostedComponentDataQueryModel>>(this) {
            final /* synthetic */ FetchBoostedComponentDataMethod f22358d;

            protected final void m24147a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null) {
                    adInterfacesDataModel$AdInterfacesDataModelCallback.mo941a(null);
                    return;
                }
                BaseAdInterfacesData a = this.f22358d.mo976a((BoostedComponentDataQueryModel) graphQLResult.e, str);
                a.f21755k = str2;
                this.f22358d.f22354f.m22824b(a);
                adInterfacesDataModel$AdInterfacesDataModelCallback.mo941a(a);
            }

            protected final void m24148a(Throwable th) {
                this.f22358d.f22352d.a(new ErrorDialogEvent());
            }
        });
    }

    @Nullable
    protected final ImmutableList<BoostedComponentAudienceModel> m24139d(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        BoostedComponentModel b = mo979b(boostedComponentDataQueryModel);
        if (b == null || b.m23349p() == null || b.m23349p().m23312j() == null) {
            return null;
        }
        return AdInterfacesDataHelper.m22794a(b.m23349p().m23312j());
    }

    protected final int m24140e(BoostedComponentDataQueryModel boostedComponentDataQueryModel) {
        BoostedComponentModel b = mo979b(boostedComponentDataQueryModel);
        if (b == null || b.m23349p() == null || b.m23349p().m23312j() == null) {
            return 0;
        }
        return b.m23349p().m23312j().m23280a();
    }
}

package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.model.AdInterfacesTargetingData;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BudgetRecommendationModel;
import com.facebook.adinterfaces.protocol.FetchBudgetRecommendationsQuery.FetchBudgetRecommendationsQueryString;
import com.facebook.adinterfaces.protocol.FetchBudgetRecommendationsQueryModels.FetchBudgetRecommendationsQueryModel;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.json.JSONObject;

/* compiled from: WEBRTC_REMINDER_NOTIFICATION_ACTION */
public class FetchBudgetRecommendationsMethod {
    public static final Integer f22360a = Integer.valueOf(1);
    public static final Integer f22361b = Integer.valueOf(5);
    private final GraphQLQueryExecutor f22362c;

    /* compiled from: WEBRTC_REMINDER_NOTIFICATION_ACTION */
    class C25451 implements Function<GraphQLResult<FetchBudgetRecommendationsQueryModel>, BudgetRecommendationModel> {
        final /* synthetic */ FetchBudgetRecommendationsMethod f22359a;

        C25451(FetchBudgetRecommendationsMethod fetchBudgetRecommendationsMethod) {
            this.f22359a = fetchBudgetRecommendationsMethod;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchBudgetRecommendationsQueryModel) graphQLResult.e).m24155a() == null) {
                return null;
            }
            return ((FetchBudgetRecommendationsQueryModel) graphQLResult.e).m24155a().m23388a();
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    /* compiled from: WEBRTC_REMINDER_NOTIFICATION_ACTION */
    public enum Key {
        FETCH_BUDGET_RECOMMENDATION,
        FETCH_SINGLE_BUDGET_RECOMMENDATION
    }

    public static FetchBudgetRecommendationsMethod m24149b(InjectorLike injectorLike) {
        return new FetchBudgetRecommendationsMethod(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public FetchBudgetRecommendationsMethod(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f22362c = graphQLQueryExecutor;
    }

    public final ListenableFuture<BudgetRecommendationModel> m24150a(String str, @Nullable Enum enumR, @Nullable String str2, String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable AdInterfacesTargetingData adInterfacesTargetingData, Integer num) {
        String jSONObject;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str3);
        GraphQLQueryExecutor graphQLQueryExecutor = this.f22362c;
        GraphQlQueryString a = new FetchBudgetRecommendationsQueryString().a("page_id", str).a("component_app", enumR).a("story_id", str2).a("ad_account_id", str3).a("duration", str4).a("selected_budget", str5);
        String str8 = "audience";
        if (str7 != null) {
            str6 = GraphQLBoostedPostAudienceOption.CUSTOM_AUDIENCE.name();
        }
        GraphQlQueryString a2 = a.a(str8, str6).a("audience_id", str7);
        String str9 = "targeting";
        if (adInterfacesTargetingData == null || str7 != null) {
            jSONObject = new JSONObject().toString();
        } else {
            jSONObject = adInterfacesTargetingData.m22843j();
        }
        return Futures.a(graphQLQueryExecutor.a(GraphQLRequest.a((FetchBudgetRecommendationsQueryString) a2.a(str9, jSONObject).a("max_budgets_count", num.toString()).a("use_default_settings", Boolean.valueOf(false)))), new C25451(this), MoreExecutors.a());
    }
}

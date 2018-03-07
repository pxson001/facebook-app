package com.facebook.goodwill.dailydialogue.data;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.goodwill.dailydialogue.protocol.FetchDailyDialoguePinnedUnitsGraphQL;
import com.facebook.goodwill.dailydialogue.protocol.FetchDailyDialoguePinnedUnitsGraphQL.FBDailyDialogueUpdateString;
import com.facebook.goodwill.dailydialogue.protocol.FetchDailyDialoguePinnedUnitsGraphQLModels.FBDailyDialogueUpdateModel;
import com.facebook.graphql.calls.DailyDialogueUpdateInputData;
import com.facebook.graphql.calls.DailyDialogueUpdateInputData.LightweightUnitType;
import com.facebook.graphql.calls.DailyDialogueUpdateInputData.MutationType;
import com.facebook.graphql.calls.DailyDialogueUpdateInputData.ProductName;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import javax.inject.Inject;

/* compiled from: people_you_may_know_location */
public class DailyDialogueViewedMutationProtocol {
    private final GraphQLQueryExecutor f10251a;
    private final TasksManager f10252b;
    private final FbObjectMapper f10253c;

    public static DailyDialogueViewedMutationProtocol m15337b(InjectorLike injectorLike) {
        return new DailyDialogueViewedMutationProtocol(GraphQLQueryExecutor.m10435a(injectorLike), TasksManager.m14550b(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    @Inject
    public DailyDialogueViewedMutationProtocol(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, FbObjectMapper fbObjectMapper) {
        this.f10251a = graphQLQueryExecutor;
        this.f10252b = tasksManager;
        this.f10253c = fbObjectMapper;
    }

    public final void m15338a(AbstractDisposableFutureCallback<GraphQLResult<FBDailyDialogueUpdateModel>> abstractDisposableFutureCallback, String str) {
        this.f10252b.m14553a(Integer.valueOf(1), m15336a(str, MutationType.VIEW), (DisposableFutureCallback) abstractDisposableFutureCallback);
    }

    public final void m15339b(AbstractDisposableFutureCallback<GraphQLResult<FBDailyDialogueUpdateModel>> abstractDisposableFutureCallback, String str) {
        this.f10252b.m14553a(Integer.valueOf(2), m15336a(str, MutationType.DISMISS), (DisposableFutureCallback) abstractDisposableFutureCallback);
    }

    private ListenableFuture<GraphQLResult<FBDailyDialogueUpdateModel>> m15336a(String str, MutationType mutationType) {
        String str2;
        String str3;
        LightweightUnitType lightweightUnitType;
        GraphQlCallInput a;
        String str4 = null;
        if (str != null) {
            try {
                Tracking tracking = (Tracking) this.f10253c.m6657a(str, Tracking.class);
                LightweightUnitType valueOf = LightweightUnitType.valueOf(tracking.type);
                try {
                    str2 = tracking.id;
                } catch (IOException e) {
                    str3 = null;
                    lightweightUnitType = valueOf;
                    str4 = str3;
                    str3 = null;
                    a = new DailyDialogueUpdateInputData().a(ProductName.GOOD_MORNING).a(mutationType);
                    if (lightweightUnitType != null) {
                        a.a(str4).a(lightweightUnitType).b(str3);
                    }
                    return this.f10251a.m10448a(new MutationRequest((FBDailyDialogueUpdateString) FetchDailyDialoguePinnedUnitsGraphQL.b().m11310a("input", a)));
                } catch (IllegalArgumentException e2) {
                    str3 = null;
                    lightweightUnitType = valueOf;
                    str4 = str3;
                    str3 = null;
                    a = new DailyDialogueUpdateInputData().a(ProductName.GOOD_MORNING).a(mutationType);
                    if (lightweightUnitType != null) {
                        a.a(str4).a(lightweightUnitType).b(str3);
                    }
                    return this.f10251a.m10448a(new MutationRequest((FBDailyDialogueUpdateString) FetchDailyDialoguePinnedUnitsGraphQL.b().m11310a("input", a)));
                }
                try {
                    str3 = tracking.extra;
                    str4 = str2;
                    lightweightUnitType = valueOf;
                } catch (IOException e3) {
                    str3 = str2;
                    lightweightUnitType = valueOf;
                    str4 = str3;
                    str3 = null;
                    a = new DailyDialogueUpdateInputData().a(ProductName.GOOD_MORNING).a(mutationType);
                    if (lightweightUnitType != null) {
                        a.a(str4).a(lightweightUnitType).b(str3);
                    }
                    return this.f10251a.m10448a(new MutationRequest((FBDailyDialogueUpdateString) FetchDailyDialoguePinnedUnitsGraphQL.b().m11310a("input", a)));
                } catch (IllegalArgumentException e4) {
                    str3 = str2;
                    lightweightUnitType = valueOf;
                    str4 = str3;
                    str3 = null;
                    a = new DailyDialogueUpdateInputData().a(ProductName.GOOD_MORNING).a(mutationType);
                    if (lightweightUnitType != null) {
                        a.a(str4).a(lightweightUnitType).b(str3);
                    }
                    return this.f10251a.m10448a(new MutationRequest((FBDailyDialogueUpdateString) FetchDailyDialoguePinnedUnitsGraphQL.b().m11310a("input", a)));
                }
            } catch (IOException e5) {
                str3 = null;
                lightweightUnitType = null;
                str4 = str3;
                str3 = null;
                a = new DailyDialogueUpdateInputData().a(ProductName.GOOD_MORNING).a(mutationType);
                if (lightweightUnitType != null) {
                    a.a(str4).a(lightweightUnitType).b(str3);
                }
                return this.f10251a.m10448a(new MutationRequest((FBDailyDialogueUpdateString) FetchDailyDialoguePinnedUnitsGraphQL.b().m11310a("input", a)));
            } catch (IllegalArgumentException e6) {
                str3 = null;
                lightweightUnitType = null;
                str4 = str3;
                str3 = null;
                a = new DailyDialogueUpdateInputData().a(ProductName.GOOD_MORNING).a(mutationType);
                if (lightweightUnitType != null) {
                    a.a(str4).a(lightweightUnitType).b(str3);
                }
                return this.f10251a.m10448a(new MutationRequest((FBDailyDialogueUpdateString) FetchDailyDialoguePinnedUnitsGraphQL.b().m11310a("input", a)));
            }
        }
        str3 = null;
        lightweightUnitType = null;
        a = new DailyDialogueUpdateInputData().a(ProductName.GOOD_MORNING).a(mutationType);
        if (lightweightUnitType != null) {
            a.a(str4).a(lightweightUnitType).b(str3);
        }
        return this.f10251a.m10448a(new MutationRequest((FBDailyDialogueUpdateString) FetchDailyDialoguePinnedUnitsGraphQL.b().m11310a("input", a)));
    }
}

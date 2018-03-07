package com.facebook.backstage.graphql;

import com.facebook.backstage.graphql.FBBackstageMutationFragments.FBBackstageUpdateAudienceModeMutationString;
import com.facebook.backstage.graphql.FBBackstageMutationFragments.UpdateWhiteListMutationString;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsModels.FBBackstageUpdateAudienceModeMutationModel;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsModels.UpdateWhiteListMutationModel;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.BackstageUserUpdateAudienceModeInputData;
import com.facebook.graphql.calls.BackstageUserUpdateAudienceModeInputData.BackstageAudienceMode;
import com.facebook.graphql.calls.BackstageUserUpdateWhitelistedFriendsInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: scrollEnabled */
public class AudienceControlMutationHelper {
    public static final String f5187a = AudienceControlMutationHelper.class.getSimpleName();
    public final Executor f5188b;
    public final Executor f5189c;
    public final GraphQLQueryExecutor f5190d;
    public final Provider<String> f5191e;

    /* compiled from: scrollEnabled */
    public interface CallBack {
        void mo152a();
    }

    /* compiled from: scrollEnabled */
    public class C05532 implements FutureCallback<GraphQLResult<UpdateWhiteListMutationModel>> {
        final /* synthetic */ CallBack f5185a;
        final /* synthetic */ AudienceControlMutationHelper f5186b;

        public C05532(AudienceControlMutationHelper audienceControlMutationHelper, CallBack callBack) {
            this.f5186b = audienceControlMutationHelper;
            this.f5185a = callBack;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            String str = AudienceControlMutationHelper.f5187a;
            ((UpdateWhiteListMutationModel) graphQLResult.e).m5049a().m5047j();
            this.f5185a.mo152a();
        }

        public void onFailure(Throwable th) {
            BLog.b(AudienceControlMutationHelper.f5187a, "OnFailure", th);
        }
    }

    public static AudienceControlMutationHelper m4962b(InjectorLike injectorLike) {
        return new AudienceControlMutationHelper((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public AudienceControlMutationHelper(Executor executor, Executor executor2, GraphQLQueryExecutor graphQLQueryExecutor, Provider<String> provider) {
        this.f5188b = executor;
        this.f5189c = executor2;
        this.f5190d = graphQLQueryExecutor;
        this.f5191e = provider;
    }

    public final void m4963a(final List<String> list, final List<String> list2, final CallBack callBack) {
        C05521 c05521 = new FutureCallback<GraphQLResult<FBBackstageUpdateAudienceModeMutationModel>>(this) {
            final /* synthetic */ AudienceControlMutationHelper f5184d;

            public void onSuccess(@Nullable Object obj) {
                String str = AudienceControlMutationHelper.f5187a;
                AudienceControlMutationHelper audienceControlMutationHelper = this.f5184d;
                List list = list;
                List list2 = list2;
                CallBack callBack = callBack;
                GraphQlQueryString updateWhiteListMutationString = new UpdateWhiteListMutationString();
                BackstageUserUpdateWhitelistedFriendsInputData backstageUserUpdateWhitelistedFriendsInputData = new BackstageUserUpdateWhitelistedFriendsInputData();
                backstageUserUpdateWhitelistedFriendsInputData.a("actor_id", (String) audienceControlMutationHelper.f5191e.get());
                GraphQlCallInput graphQlCallInput = backstageUserUpdateWhitelistedFriendsInputData;
                graphQlCallInput.a("client_mutation_id", updateWhiteListMutationString.d);
                graphQlCallInput = graphQlCallInput;
                if (!(list2 == null || list2.isEmpty())) {
                    graphQlCallInput.a("remove_friend_ids", list2);
                }
                if (!(list == null || list.isEmpty())) {
                    graphQlCallInput.a("add_friend_ids", list);
                }
                updateWhiteListMutationString.a("0", graphQlCallInput);
                Futures.a(audienceControlMutationHelper.f5190d.a(GraphQLRequest.a(updateWhiteListMutationString)), new C05532(audienceControlMutationHelper, callBack), audienceControlMutationHelper.f5188b);
            }

            public void onFailure(Throwable th) {
                BLog.b(AudienceControlMutationHelper.f5187a, "White list failed!", th);
            }
        };
        GraphQlQueryString fBBackstageUpdateAudienceModeMutationString = new FBBackstageUpdateAudienceModeMutationString();
        BackstageUserUpdateAudienceModeInputData backstageUserUpdateAudienceModeInputData = new BackstageUserUpdateAudienceModeInputData();
        backstageUserUpdateAudienceModeInputData.a("actor_id", (String) this.f5191e.get());
        GraphQlCallInput graphQlCallInput = backstageUserUpdateAudienceModeInputData;
        graphQlCallInput.a("client_mutation_id", fBBackstageUpdateAudienceModeMutationString.d);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("backstage_audience_mode", BackstageAudienceMode.WHITELIST);
        fBBackstageUpdateAudienceModeMutationString.a("0", graphQlCallInput);
        Futures.a(this.f5190d.a(GraphQLRequest.a(fBBackstageUpdateAudienceModeMutationString)), c05521, this.f5189c);
    }
}

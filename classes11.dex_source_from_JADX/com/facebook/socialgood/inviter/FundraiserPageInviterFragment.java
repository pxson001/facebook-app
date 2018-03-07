package com.facebook.socialgood.inviter;

import android.content.Context;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThreadImmediate;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.graphql.calls.FundraiserSendInvitesInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.socialgood.protocol.FundraiserPage.FundraiserInviteSuggestionsQueryString;
import com.facebook.socialgood.protocol.FundraiserPage.FundraiserSendInvitesMutationString;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel.InviteSuggestionsModel.NodesModel;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserSendInvitesMutationFieldsModel;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Original detail view is not PandoraAlbumPermalinkDetailsView */
public class FundraiserPageInviterFragment extends GenericFriendsSelectorFragment {
    public String aA;
    @Inject
    AnalyticsLogger au;
    @DefaultExecutorService
    @Inject
    ExecutorService av;
    @Inject
    @ForUiThreadImmediate
    ExecutorService aw;
    @Inject
    public GraphQLQueryExecutor ax;
    @Inject
    Toaster ay;
    public String az;

    /* compiled from: Original detail view is not PandoraAlbumPermalinkDetailsView */
    class C14991 implements Function<GraphQLResult<FundraiserInviteSuggestionsQueryModel>, ImmutableMap<String, ImmutableList<User>>> {
        final /* synthetic */ FundraiserPageInviterFragment f12708a;

        C14991(FundraiserPageInviterFragment fundraiserPageInviterFragment) {
            this.f12708a = fundraiserPageInviterFragment;
        }

        public Object apply(@Nullable Object obj) {
            ImmutableMap b;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            FundraiserPageInviterFragment fundraiserPageInviterFragment = this.f12708a;
            Builder builder = ImmutableMap.builder();
            if (graphQLResult == null || graphQLResult.e == null) {
                b = builder.b();
            } else {
                InviteSuggestionsModel j = ((FundraiserInviteSuggestionsQueryModel) graphQLResult.e).m13331j();
                if (j == null || j.m13322a() == null) {
                    b = builder.b();
                } else {
                    Collection arrayList = new ArrayList();
                    ImmutableList a = j.m13322a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        NodesModel nodesModel = (NodesModel) a.get(i);
                        DefaultImageFieldsModel l = nodesModel.m13318l();
                        if (!(nodesModel.m13316j() == null || nodesModel.m13317k() == null || l == null)) {
                            UserBuilder a2 = new UserBuilder().a(Type.FACEBOOK, nodesModel.m13316j());
                            a2.g = new Name(nodesModel.m13317k());
                            UserBuilder userBuilder = a2;
                            userBuilder.n = l.b();
                            arrayList.add(userBuilder.aa());
                        }
                    }
                    Collections.sort(arrayList, new C15002(fundraiserPageInviterFragment));
                    builder.b(GenericFriendsSelectorFragment.a, ImmutableList.copyOf(arrayList));
                    b = builder.b();
                }
            }
            return b;
        }
    }

    /* compiled from: Original detail view is not PandoraAlbumPermalinkDetailsView */
    public class C15002 implements Comparator<User> {
        final /* synthetic */ FundraiserPageInviterFragment f12709a;

        public C15002(FundraiserPageInviterFragment fundraiserPageInviterFragment) {
            this.f12709a = fundraiserPageInviterFragment;
        }

        public int compare(Object obj, Object obj2) {
            User user = (User) obj;
            User user2 = (User) obj2;
            if (user.e == null || user2.e == null) {
                return 0;
            }
            return user.e.g().compareTo(user2.e.g());
        }
    }

    /* compiled from: Original detail view is not PandoraAlbumPermalinkDetailsView */
    class FundraiserSendInvitesMutationCallback implements FutureCallback<GraphQLResult<FundraiserSendInvitesMutationFieldsModel>> {
        final /* synthetic */ FundraiserPageInviterFragment f12710a;

        public FundraiserSendInvitesMutationCallback(FundraiserPageInviterFragment fundraiserPageInviterFragment) {
            this.f12710a = fundraiserPageInviterFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            AnalyticsLogger analyticsLogger = this.f12710a.au;
            String str = this.f12710a.az;
            String str2 = this.f12710a.aA;
            int size = this.f12710a.ax().size();
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fundraiser_page_sent_invite");
            honeyClientEvent.c = "social_good";
            analyticsLogger.a(honeyClientEvent.b("fundraiser_campaign_id", str).b("source", str2).a("invitee_count", size));
            this.f12710a.ay.b(new ToastBuilder(2131237292));
            this.f12710a.aI();
        }

        public void onFailure(Throwable th) {
            this.f12710a.ay.b(new ToastBuilder(2131242347));
        }
    }

    public static void m13210a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FundraiserPageInviterFragment) obj).m13209a(AnalyticsLoggerMethodAutoProvider.a(fbInjector), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), Toaster.b(fbInjector));
    }

    private void m13209a(AnalyticsLogger analyticsLogger, ExecutorService executorService, ExecutorService executorService2, GraphQLQueryExecutor graphQLQueryExecutor, Toaster toaster) {
        this.au = analyticsLogger;
        this.av = executorService;
        this.aw = executorService2;
        this.ax = graphQLQueryExecutor;
        this.ay = toaster;
    }

    public final void m13212c(Bundle bundle) {
        Class cls = FundraiserPageInviterFragment.class;
        m13210a(this, getContext());
        super.c(bundle);
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.az = bundle2.getString("fundraiser_campaign_id");
            this.aA = bundle2.getString("source");
        }
    }

    protected final boolean m13211a(String str) {
        return true;
    }

    protected final boolean at() {
        return true;
    }

    protected final ListenableFuture<ImmutableMap<String, ImmutableList<User>>> ay() {
        GraphQLRequest a = GraphQLRequest.a(new FundraiserInviteSuggestionsQueryString());
        a.a(new FundraiserInviteSuggestionsQueryString().a("campaign_id", this.az).a("profile_image_size", Integer.valueOf(0)).a("count", Integer.valueOf(300)).a);
        return Futures.a(this.ax.a(a), new C14991(this), this.av);
    }

    protected final void aH() {
        String str = this.az;
        ImmutableList ax = ax();
        FundraiserSendInvitesInputData fundraiserSendInvitesInputData = new FundraiserSendInvitesInputData();
        fundraiserSendInvitesInputData.a("fundraiser_campaign_id", str);
        GraphQlCallInput graphQlCallInput = fundraiserSendInvitesInputData;
        graphQlCallInput.a("invitee_ids", ax);
        Futures.a(this.ax.a(GraphQLRequest.a((FundraiserSendInvitesMutationString) new FundraiserSendInvitesMutationString().a("input", graphQlCallInput))), new FundraiserSendInvitesMutationCallback(this), this.aw);
    }
}

package com.facebook.groups.memberrequests;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.memberrequests.protocol.FetchMemberRequestsModels.FetchMemberRequestsModel.AdminAwareGroupModel.GroupPendingMembersModel.EdgesModel;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutationsModels.GroupApproveAllPendingMembersMutationModel;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutationsModels.GroupApprovePendingMemberMutationModel;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutationsModels.GroupRejectAllPendingMembersMutationModel;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutationsModels.GroupRejectPendingMemberMutationModel;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: TVL.startLoadThreadView */
public class MemberRequestsController {
    public HashMap<String, MemberRequestStates> f22934a = new HashMap();
    public final ExecutorService f22935b;
    public final String f22936c;
    public final GraphQLQueryExecutor f22937d;
    public Toaster f22938e;

    /* compiled from: TVL.startLoadThreadView */
    public class C33091 implements FutureCallback<GraphQLResult<GroupApprovePendingMemberMutationModel>> {
        final /* synthetic */ EdgesModel f22926a;
        final /* synthetic */ MemberRequestsController f22927b;

        public C33091(MemberRequestsController memberRequestsController, EdgesModel edgesModel) {
            this.f22927b = memberRequestsController;
            this.f22926a = edgesModel;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            this.f22927b.f22934a.remove(this.f22926a.m24105a().m24096b());
        }
    }

    /* compiled from: TVL.startLoadThreadView */
    public class C33102 implements FutureCallback<GraphQLResult<GroupRejectPendingMemberMutationModel>> {
        final /* synthetic */ EdgesModel f22928a;
        final /* synthetic */ MemberRequestsController f22929b;

        public C33102(MemberRequestsController memberRequestsController, EdgesModel edgesModel) {
            this.f22929b = memberRequestsController;
            this.f22928a = edgesModel;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            this.f22929b.f22934a.remove(this.f22928a.m24105a().m24096b());
        }
    }

    /* compiled from: TVL.startLoadThreadView */
    public class C33113 implements FutureCallback<GraphQLResult<GroupRejectPendingMemberMutationModel>> {
        final /* synthetic */ EdgesModel f22930a;
        final /* synthetic */ MemberRequestsController f22931b;

        public C33113(MemberRequestsController memberRequestsController, EdgesModel edgesModel) {
            this.f22931b = memberRequestsController;
            this.f22930a = edgesModel;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            this.f22931b.f22934a.remove(this.f22930a.m24105a().m24096b());
        }
    }

    /* compiled from: TVL.startLoadThreadView */
    public class C33124 implements FutureCallback<GraphQLResult<GroupApproveAllPendingMembersMutationModel>> {
        final /* synthetic */ MemberRequestsController f22932a;

        public C33124(MemberRequestsController memberRequestsController) {
            this.f22932a = memberRequestsController;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            this.f22932a.f22938e.b(new ToastBuilder(2131242211));
        }
    }

    /* compiled from: TVL.startLoadThreadView */
    public class C33135 implements FutureCallback<GraphQLResult<GroupRejectAllPendingMembersMutationModel>> {
        final /* synthetic */ MemberRequestsController f22933a;

        public C33135(MemberRequestsController memberRequestsController) {
            this.f22933a = memberRequestsController;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            this.f22933a.f22938e.b(new ToastBuilder(2131242211));
        }
    }

    /* compiled from: TVL.startLoadThreadView */
    public enum MemberRequestStates {
        MEMBER_REQUEST_IGNORED,
        MEMBER_REQUEST_ACCEPTED,
        MEMBER_REQUEST_BLOCKED
    }

    public static MemberRequestsController m24030b(InjectorLike injectorLike) {
        return new MemberRequestsController((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), Toaster.b(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public MemberRequestsController(ExecutorService executorService, String str, Toaster toaster, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f22935b = executorService;
        this.f22936c = str;
        this.f22938e = toaster;
        this.f22937d = graphQLQueryExecutor;
    }
}

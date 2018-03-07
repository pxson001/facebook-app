package com.facebook.messaging.groups.threadactions;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.MessengerGroupChangeThreadApprovalSettingsInputData;
import com.facebook.graphql.calls.MessengerGroupChangeThreadApprovalSettingsInputData.Mode;
import com.facebook.graphql.calls.MessengerGroupChangeThreadJoinableSettingsInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.groups.admin.AdminAlertDialogFactory;
import com.facebook.messaging.groups.admin.AdminRequiredActionCallback;
import com.facebook.messaging.groups.admin.GroupAdminController;
import com.facebook.messaging.groups.graphql.GroupsGraphQLMutator;
import com.facebook.messaging.groups.graphql.JoinableGroupsMutations.ChangeGroupApprovalModeSettingString;
import com.facebook.messaging.groups.graphql.JoinableGroupsMutations.ChangeGroupJoinableThreadSettingsString;
import com.facebook.messaging.groups.graphql.JoinableGroupsMutationsModels.ChangeGroupApprovalModeSettingModel;
import com.facebook.messaging.groups.graphql.JoinableGroupsMutationsModels.ChangeGroupJoinableThreadSettingsModel;
import com.facebook.messaging.groups.logging.GroupJoinableLinksLogger;
import com.facebook.messaging.groups.sharesheet.GroupShareSheetCreator.C04215;
import com.facebook.messaging.groups.threadactions.AdminActionDialogParams.Builder;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummary.GroupType;
import com.facebook.messaging.service.model.FetchIsThreadQueueEnabledParams;
import com.facebook.messaging.service.model.FetchIsThreadQueueEnabledResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: shareid */
public class GroupThreadActionHandler {
    public final GroupAdminController f2577a;
    public final Resources f2578b;
    private final Provider<UserKey> f2579c;
    public final ExecutorService f2580d;
    public final GroupsGraphQLMutator f2581e;
    public final AbstractFbErrorReporter f2582f;
    public final DefaultBlueServiceOperationFactory f2583g;
    public final GroupJoinableLinksLogger f2584h;

    /* compiled from: shareid */
    public class C04313 extends OperationResultFutureCallback2 {
        final /* synthetic */ ChangeJoinableGroupModeCallback f2566a;
        final /* synthetic */ ThreadSummary f2567b;
        final /* synthetic */ GroupType f2568c;
        final /* synthetic */ GroupThreadActionHandler f2569d;

        public C04313(GroupThreadActionHandler groupThreadActionHandler, ChangeJoinableGroupModeCallback changeJoinableGroupModeCallback, ThreadSummary threadSummary, GroupType groupType) {
            this.f2569d = groupThreadActionHandler;
            this.f2566a = changeJoinableGroupModeCallback;
            this.f2567b = threadSummary;
            this.f2568c = groupType;
        }

        protected final void m2567a(OperationResult operationResult) {
            FetchIsThreadQueueEnabledResult fetchIsThreadQueueEnabledResult = (FetchIsThreadQueueEnabledResult) operationResult.k();
            if (fetchIsThreadQueueEnabledResult == null || !fetchIsThreadQueueEnabledResult.a) {
                this.f2566a.mo66b();
            } else {
                GroupThreadActionHandler.m2574b(this.f2569d, this.f2567b, this.f2568c, this.f2566a);
            }
        }

        protected final void m2569a(Throwable th) {
            this.f2566a.mo66b();
        }
    }

    /* compiled from: shareid */
    public class C04336 implements AdminRequiredActionCallback {
        final /* synthetic */ ThreadSummary f2572a;
        final /* synthetic */ boolean f2573b;
        final /* synthetic */ Context f2574c;
        final /* synthetic */ C04215 f2575d;
        final /* synthetic */ GroupThreadActionHandler f2576e;

        public C04336(GroupThreadActionHandler groupThreadActionHandler, ThreadSummary threadSummary, boolean z, Context context, C04215 c04215) {
            this.f2576e = groupThreadActionHandler;
            this.f2572a = threadSummary;
            this.f2573b = z;
            this.f2574c = context;
            this.f2575d = c04215;
        }

        public final void mo72a() {
            Enum enumR;
            GroupsGraphQLMutator groupsGraphQLMutator = this.f2576e.f2581e;
            ThreadKey threadKey = this.f2572a.a;
            boolean z = this.f2573b;
            MessengerGroupChangeThreadApprovalSettingsInputData messengerGroupChangeThreadApprovalSettingsInputData = new MessengerGroupChangeThreadApprovalSettingsInputData();
            messengerGroupChangeThreadApprovalSettingsInputData.a("thread_fbid", Long.toString(threadKey.i()));
            GraphQlCallInput graphQlCallInput = messengerGroupChangeThreadApprovalSettingsInputData;
            graphQlCallInput.a("actor_id", (String) groupsGraphQLMutator.f2464a.get());
            graphQlCallInput = graphQlCallInput;
            if (z) {
                enumR = Mode.APPROVALS;
            } else {
                enumR = Mode.OPEN;
            }
            graphQlCallInput.a("mode", enumR);
            GraphQlQueryString changeGroupApprovalModeSettingString = new ChangeGroupApprovalModeSettingString();
            changeGroupApprovalModeSettingString.a("input", messengerGroupChangeThreadApprovalSettingsInputData);
            ListenableFuture a = groupsGraphQLMutator.f2465b.a(GraphQLRequest.a(changeGroupApprovalModeSettingString));
            final DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(this.f2574c, 2131231922);
            dialogBasedProgressIndicator.a();
            Futures.a(a, new FutureCallback<GraphQLResult<ChangeGroupApprovalModeSettingModel>>(this) {
                final /* synthetic */ C04336 f2571b;

                public void onSuccess(@Nullable Object obj) {
                    C04215 c04215 = this.f2571b.f2575d;
                    c04215.f2512b.f2523i.m2549c(c04215.f2511a ? 2131241309 : 2131241310);
                    dialogBasedProgressIndicator.b();
                }

                public void onFailure(Throwable th) {
                    dialogBasedProgressIndicator.b();
                    this.f2571b.f2575d.m2525a(this.f2571b.f2573b);
                }
            }, this.f2576e.f2580d);
        }

        public final void mo73b() {
            this.f2576e.f2582f.b("GroupThreadActionHandler", "onAdminPromotionDeclined callback inappropriately called");
        }

        public final void mo74c() {
            AdminAlertDialogFactory.m2336a(this.f2574c).b();
            this.f2575d.m2525a(this.f2573b);
        }
    }

    public static GroupThreadActionHandler m2573b(InjectorLike injectorLike) {
        return new GroupThreadActionHandler(GroupAdminController.m2341b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3597), new GroupsGraphQLMutator(IdBasedProvider.a(injectorLike, 4442), GraphQLQueryExecutor.a(injectorLike)), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), GroupJoinableLinksLogger.m2486a(injectorLike));
    }

    @Inject
    public GroupThreadActionHandler(GroupAdminController groupAdminController, Resources resources, Provider<UserKey> provider, GroupsGraphQLMutator groupsGraphQLMutator, ExecutorService executorService, FbErrorReporter fbErrorReporter, BlueServiceOperationFactory blueServiceOperationFactory, GroupJoinableLinksLogger groupJoinableLinksLogger) {
        this.f2577a = groupAdminController;
        this.f2578b = resources;
        this.f2579c = provider;
        this.f2581e = groupsGraphQLMutator;
        this.f2580d = executorService;
        this.f2582f = fbErrorReporter;
        this.f2583g = blueServiceOperationFactory;
        this.f2584h = groupJoinableLinksLogger;
    }

    public final void m2575a(FragmentManager fragmentManager, ThreadSummary threadSummary) {
        Builder builder = new Builder();
        builder.f2545a = threadSummary.a;
        Builder builder2 = builder;
        builder2.f2546b = (UserKey) this.f2579c.get();
        builder = builder2;
        builder.f2551g = "remove_member";
        builder = builder;
        builder.f2547c = this.f2578b.getString(2131231903);
        builder = builder;
        builder.f2549e = this.f2578b.getString(2131231906);
        builder = builder;
        builder.f2550f = this.f2578b.getString(2131231907);
        builder = builder;
        if (this.f2577a.m2346c(threadSummary)) {
            builder.f2548d = this.f2578b.getString(2131231904);
        } else {
            builder.f2548d = this.f2578b.getString(2131231905);
        }
        AdminActionDialogFragment.m2560a(builder.m2563h()).a(fragmentManager, "leaveThreadDialog");
    }

    public final void m2577b(UserKey userKey, String str, ThreadSummary threadSummary, FragmentManager fragmentManager) {
        if (this.f2577a.m2346c(threadSummary)) {
            Builder builder = new Builder();
            builder.f2545a = threadSummary.a;
            Builder builder2 = builder;
            builder2.f2546b = userKey;
            builder2 = builder2;
            builder2.f2551g = "remove_admins_from_group";
            builder2 = builder2;
            builder2.f2547c = this.f2578b.getString(2131231912);
            builder2 = builder2;
            builder2.f2549e = this.f2578b.getString(2131231918);
            builder2.f2550f = this.f2578b.getString(2131231921);
            if (((UserKey) this.f2579c.get()).equals(userKey)) {
                Object obj;
                GroupAdminController groupAdminController = this.f2577a;
                if (!groupAdminController.m2344a(threadSummary)) {
                    obj = null;
                } else if (GroupAdminController.m2340a(threadSummary.h).size() == 1 && groupAdminController.m2345a(threadSummary, (UserKey) groupAdminController.f2428a.get())) {
                    int i = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    builder.f2548d = this.f2578b.getString(2131231915);
                } else {
                    builder.f2548d = this.f2578b.getString(2131231914);
                }
            } else {
                builder.f2548d = this.f2578b.getString(2131231913, new Object[]{str});
            }
            AdminActionDialogFragment.m2560a(builder.m2563h()).a(fragmentManager, "removeAdminsDialog");
        }
    }

    public final void m2576a(ThreadSummary threadSummary, GroupType groupType, Context context, ChangeJoinableGroupModeCallback changeJoinableGroupModeCallback, String str) {
        Preconditions.checkArgument(threadSummary.a.b());
        this.f2584h.m2491a(threadSummary, groupType == GroupType.HIDDEN, str);
        final GroupType groupType2 = groupType;
        final ThreadSummary threadSummary2 = threadSummary;
        final ChangeJoinableGroupModeCallback changeJoinableGroupModeCallback2 = changeJoinableGroupModeCallback;
        final Context context2 = context;
        this.f2577a.m2342a(threadSummary, new AdminRequiredActionCallback(this) {
            final /* synthetic */ GroupThreadActionHandler f2563e;

            public final void mo72a() {
                if (groupType2 == GroupType.HIDDEN) {
                    this.f2563e.f2584h.m2492b(threadSummary2);
                }
                GroupThreadActionHandler groupThreadActionHandler = this.f2563e;
                ThreadSummary threadSummary = threadSummary2;
                GroupType groupType = groupType2;
                ChangeJoinableGroupModeCallback changeJoinableGroupModeCallback = changeJoinableGroupModeCallback2;
                changeJoinableGroupModeCallback.mo64a();
                if (groupType == GroupType.HIDDEN && threadSummary.T == TriState.UNSET) {
                    ThreadKey threadKey = threadSummary.a;
                    FutureCallback c04313 = new C04313(groupThreadActionHandler, changeJoinableGroupModeCallback, threadSummary, groupType);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(FetchIsThreadQueueEnabledParams.a, new FetchIsThreadQueueEnabledParams(threadKey));
                    Futures.a(BlueServiceOperationFactoryDetour.a(groupThreadActionHandler.f2583g, "fetch_thread_queue_enabled", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(GroupThreadActionHandler.class), -1467335249).b(), c04313, groupThreadActionHandler.f2580d);
                    return;
                }
                GroupThreadActionHandler.m2574b(groupThreadActionHandler, threadSummary, groupType, changeJoinableGroupModeCallback);
            }

            public final void mo73b() {
                this.f2563e.f2584h.m2489a(threadSummary2);
                changeJoinableGroupModeCallback2.mo67c();
            }

            public final void mo74c() {
                AdminAlertDialogFactory.m2336a(context2).b();
                changeJoinableGroupModeCallback2.mo66b();
            }
        }, context);
    }

    public static void m2574b(GroupThreadActionHandler groupThreadActionHandler, ThreadSummary threadSummary, GroupType groupType, final ChangeJoinableGroupModeCallback changeJoinableGroupModeCallback) {
        GroupsGraphQLMutator groupsGraphQLMutator = groupThreadActionHandler.f2581e;
        ThreadKey threadKey = threadSummary.a;
        MessengerGroupChangeThreadJoinableSettingsInputData messengerGroupChangeThreadJoinableSettingsInputData = new MessengerGroupChangeThreadJoinableSettingsInputData();
        messengerGroupChangeThreadJoinableSettingsInputData.a("thread_fbid", Long.toString(threadKey.i()));
        messengerGroupChangeThreadJoinableSettingsInputData.a("actor_id", (String) groupsGraphQLMutator.f2464a.get());
        MessengerGroupChangeThreadJoinableSettingsInputData a = GroupsGraphQLMutator.m2436a(groupType, messengerGroupChangeThreadJoinableSettingsInputData);
        GraphQlQueryString changeGroupJoinableThreadSettingsString = new ChangeGroupJoinableThreadSettingsString();
        changeGroupJoinableThreadSettingsString.a("input", a);
        Futures.a(groupsGraphQLMutator.f2465b.a(GraphQLRequest.a(changeGroupJoinableThreadSettingsString)), new FutureCallback<GraphQLResult<ChangeGroupJoinableThreadSettingsModel>>(groupThreadActionHandler) {
            final /* synthetic */ GroupThreadActionHandler f2565b;

            public void onSuccess(@Nullable Object obj) {
                Uri uri;
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null || ((ChangeGroupJoinableThreadSettingsModel) graphQLResult.e).m2463a() == null || ((ChangeGroupJoinableThreadSettingsModel) graphQLResult.e).m2463a().m2460a() == null || ((ChangeGroupJoinableThreadSettingsModel) graphQLResult.e).m2463a().m2460a().m2456a() == null) {
                    uri = null;
                } else {
                    uri = Uri.parse(((ChangeGroupJoinableThreadSettingsModel) graphQLResult.e).m2463a().m2460a().m2456a());
                }
                changeJoinableGroupModeCallback.mo65a(uri);
            }

            public void onFailure(Throwable th) {
                changeJoinableGroupModeCallback.mo66b();
            }
        }, groupThreadActionHandler.f2580d);
    }
}

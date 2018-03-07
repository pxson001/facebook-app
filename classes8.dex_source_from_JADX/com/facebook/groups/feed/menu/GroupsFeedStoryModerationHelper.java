package com.facebook.groups.feed.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents.ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupApprovePendingStoryInputData;
import com.facebook.graphql.calls.GroupBlockInputData;
import com.facebook.graphql.calls.GroupPinStoryInputData;
import com.facebook.graphql.calls.GroupRemoveMemberInputData;
import com.facebook.graphql.calls.GroupRemoveMemberInputData.Source;
import com.facebook.graphql.calls.GroupUnpinStoryInputData;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.feed.data.GroupsFeedEvents.StoryApproveEvent;
import com.facebook.groups.feed.data.GroupsFeedEvents.StoryIgnoreReportEvent;
import com.facebook.groups.feed.data.GroupsFeedEvents.StoryPinEvent;
import com.facebook.groups.feed.data.PinState;
import com.facebook.groups.feed.menu.common.GroupsReportToAdminHelper;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutations;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutations.GroupBlockMutationString;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutations.GroupRemoveMemberMutationString;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsModels.GroupBlockMutationModel;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsModels.GroupRemoveMemberMutationModel;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.groups.mutations.protocol.GroupPostMutations.GroupApprovePendingStoryMutationString;
import com.facebook.groups.mutations.protocol.GroupPostMutations.GroupPinStoryMutationString;
import com.facebook.groups.mutations.protocol.GroupPostMutationsModels.LocalGroupModerationFieldsModel;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Functions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: faceweb/f?href=/%s/settings/add_services/?service_id=%s */
public class GroupsFeedStoryModerationHelper {
    public static final String f14114l = GroupsFeedStoryModerationHelper.class.getName();
    private static volatile GroupsFeedStoryModerationHelper f14115m;
    public final DefaultAndroidThreadUtil f14116a;
    public final FeedEventBus f14117b;
    public final Toaster f14118c;
    private final GraphPostService f14119d;
    public final GroupsClient f14120e;
    public final GraphQLQueryExecutor f14121f;
    public final String f14122g;
    public final ExecutorService f14123h;
    public final AbstractFbErrorReporter f14124i;
    public final GroupsReportToAdminHelper f14125j;
    public final ControllerMutationGatekeepers f14126k;

    /* compiled from: faceweb/f?href=/%s/settings/add_services/?service_id=%s */
    public class C15022 implements FutureCallback<Void> {
        final /* synthetic */ FeedProps f14094a;
        final /* synthetic */ GroupsFeedStoryModerationHelper f14095b;

        public C15022(GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper, FeedProps feedProps) {
            this.f14095b = groupsFeedStoryModerationHelper;
            this.f14094a = feedProps;
        }

        public void onSuccess(Object obj) {
            if (this.f14095b.f14126k.b()) {
                this.f14095b.f14117b.a(new StoryIgnoreReportEvent(this.f14094a, true, false));
            }
            this.f14095b.f14118c.b(new ToastBuilder(2131239423));
        }

        public void onFailure(Throwable th) {
            this.f14095b.f14118c.b(new ToastBuilder(2131239424));
            if (this.f14095b.f14126k.b()) {
                this.f14095b.f14117b.a(new StoryIgnoreReportEvent(this.f14094a, false, true));
            }
        }
    }

    /* compiled from: faceweb/f?href=/%s/settings/add_services/?service_id=%s */
    public class C15055 implements FutureCallback<GraphQLResult<GroupBlockMutationModel>> {
        final /* synthetic */ FeedProps f14102a;
        final /* synthetic */ GroupsFeedStoryModerationHelper f14103b;

        public C15055(GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper, FeedProps feedProps) {
            this.f14103b = groupsFeedStoryModerationHelper;
            this.f14102a = feedProps;
        }

        public void onSuccess(Object obj) {
            GroupsFeedStoryModerationHelper.m15666a(this.f14103b, this.f14102a, 2131239426);
        }

        public void onFailure(Throwable th) {
            this.f14103b.f14118c.b(new ToastBuilder(2131233449));
        }
    }

    /* compiled from: faceweb/f?href=/%s/settings/add_services/?service_id=%s */
    public class C15066 implements OnClickListener {
        final /* synthetic */ GraphQLStory f14104a;
        final /* synthetic */ FeedProps f14105b;
        final /* synthetic */ GroupsFeedStoryModerationHelper f14106c;

        public C15066(GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper, GraphQLStory graphQLStory, FeedProps feedProps) {
            this.f14106c = groupsFeedStoryModerationHelper;
            this.f14104a = graphQLStory;
            this.f14105b = feedProps;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            String a = GroupsFeedStoryModerationHelper.m15665a(this.f14104a);
            if (StoryActorHelper.b(this.f14104a) == null || StoryActorHelper.b(this.f14104a).H() == null) {
                this.f14106c.f14118c.b(new ToastBuilder(2131233449));
                this.f14106c.f14124i.a(GroupsFeedStoryModerationHelper.f14114l, "Group feed story " + this.f14104a.c() + "does not have an actor id in group" + a + "in method deletePostAndRemoveMember");
                return;
            }
            GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper = this.f14106c;
            GroupRemoveMemberInputData c = new GroupRemoveMemberInputData().a(groupsFeedStoryModerationHelper.f14122g).b(a).a(Source.TREEHOUSE_GROUP_MALL).c(StoryActorHelper.b(this.f14104a).H());
            GroupRemoveMemberMutationString c2 = GroupMemberAdminMutations.m16355c();
            c2.a("input", c);
            TypedGraphQLMutationString typedGraphQLMutationString = c2;
            groupsFeedStoryModerationHelper = this.f14106c;
            Futures.a(groupsFeedStoryModerationHelper.f14121f.a(GraphQLRequest.a(typedGraphQLMutationString)), new C15077(groupsFeedStoryModerationHelper, this.f14105b), groupsFeedStoryModerationHelper.f14123h);
        }
    }

    /* compiled from: faceweb/f?href=/%s/settings/add_services/?service_id=%s */
    public class C15077 implements FutureCallback<GraphQLResult<GroupRemoveMemberMutationModel>> {
        final /* synthetic */ FeedProps f14107a;
        final /* synthetic */ GroupsFeedStoryModerationHelper f14108b;

        public C15077(GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper, FeedProps feedProps) {
            this.f14108b = groupsFeedStoryModerationHelper;
            this.f14107a = feedProps;
        }

        public void onSuccess(Object obj) {
            GroupsFeedStoryModerationHelper.m15666a(this.f14108b, this.f14107a, 2131239427);
        }

        public void onFailure(Throwable th) {
            this.f14108b.f14118c.b(new ToastBuilder(2131233449));
        }
    }

    public static com.facebook.groups.feed.menu.GroupsFeedStoryModerationHelper m15664a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f14115m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.groups.feed.menu.GroupsFeedStoryModerationHelper.class;
        monitor-enter(r1);
        r0 = f14115m;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m15668b(r0);	 Catch:{ all -> 0x0035 }
        f14115m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14115m;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.menu.GroupsFeedStoryModerationHelper.a(com.facebook.inject.InjectorLike):com.facebook.groups.feed.menu.GroupsFeedStoryModerationHelper");
    }

    private static GroupsFeedStoryModerationHelper m15668b(InjectorLike injectorLike) {
        return new GroupsFeedStoryModerationHelper(DefaultAndroidThreadUtil.b(injectorLike), FeedEventBus.a(injectorLike), Toaster.b(injectorLike), GraphPostService.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), GroupsClient.m16961b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GroupsReportToAdminHelper.a(injectorLike), ControllerMutationGatekeepers.b(injectorLike));
    }

    @Inject
    public GroupsFeedStoryModerationHelper(DefaultAndroidThreadUtil defaultAndroidThreadUtil, FeedEventBus feedEventBus, Toaster toaster, GraphPostService graphPostService, ExecutorService executorService, String str, GraphQLQueryExecutor graphQLQueryExecutor, GroupsClient groupsClient, AbstractFbErrorReporter abstractFbErrorReporter, GroupsReportToAdminHelper groupsReportToAdminHelper, ControllerMutationGatekeepers controllerMutationGatekeepers) {
        this.f14116a = defaultAndroidThreadUtil;
        this.f14122g = str;
        this.f14123h = executorService;
        this.f14117b = feedEventBus;
        this.f14118c = toaster;
        this.f14119d = graphPostService;
        this.f14120e = groupsClient;
        this.f14121f = graphQLQueryExecutor;
        this.f14124i = abstractFbErrorReporter;
        this.f14125j = groupsReportToAdminHelper;
        this.f14126k = controllerMutationGatekeepers;
    }

    public static void m15666a(GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper, FeedProps feedProps, final int i) {
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        groupsFeedStoryModerationHelper.f14117b.a(new StoryDeleteEvent(feedProps));
        groupsFeedStoryModerationHelper.f14117b.a(new ChangeRendererEvent());
        groupsFeedStoryModerationHelper.f14116a.a(groupsFeedStoryModerationHelper.f14119d.a(graphQLStory), new OperationResultFutureCallback(groupsFeedStoryModerationHelper) {
            final /* synthetic */ GroupsFeedStoryModerationHelper f14113c;

            protected final void m15662a(ServiceException serviceException) {
                this.f14113c.f14118c.b(new ToastBuilder(2131233451));
                this.f14113c.f14117b.a(new StoryVisibilityEvent(graphQLStory.g(), graphQLStory.ai(), null, StoryVisibility.VISIBLE, graphQLStory.p()));
                this.f14113c.f14117b.a(new ChangeRendererEvent());
            }

            protected final void m15663a(Object obj) {
                this.f14113c.f14118c.b(new ToastBuilder(i));
            }
        });
    }

    public final void m15669a(Context context, final FeedProps<GraphQLStory> feedProps, final GroupBlockInputData.Source source) {
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        new Builder(context).b(context.getResources().getString(2131233447)).a(2131233462, new OnClickListener(this) {
            final /* synthetic */ GroupsFeedStoryModerationHelper f14101d;

            public void onClick(DialogInterface dialogInterface, int i) {
                String a = GroupsFeedStoryModerationHelper.m15665a(graphQLStory);
                if (StoryActorHelper.b(graphQLStory) == null || StoryActorHelper.b(graphQLStory).H() == null) {
                    this.f14101d.f14118c.b(new ToastBuilder(2131233449));
                    this.f14101d.f14124i.a(GroupsFeedStoryModerationHelper.f14114l, "Group feed story " + graphQLStory.c() + "does not have an actor id in group" + a + "in method deletePostAndBlockUser");
                    return;
                }
                String H = StoryActorHelper.b(graphQLStory).H();
                GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper = this.f14101d;
                GroupBlockInputData c = new GroupBlockInputData().a(groupsFeedStoryModerationHelper.f14122g).b(a).a(source).c(H);
                GroupBlockMutationString d = GroupMemberAdminMutations.m16356d();
                d.a("input", c);
                TypedGraphQLMutationString typedGraphQLMutationString = d;
                GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper2 = this.f14101d;
                Futures.a(groupsFeedStoryModerationHelper2.f14121f.a(GraphQLRequest.a(typedGraphQLMutationString)), new C15055(groupsFeedStoryModerationHelper2, feedProps), groupsFeedStoryModerationHelper2.f14123h);
            }
        }).b(2131233563, null).b();
    }

    public final void m15671a(final FeedProps<GraphQLStory> feedProps, final PinState pinState) {
        ListenableFuture a;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        if (this.f14126k.b()) {
            this.f14117b.a(new StoryPinEvent(feedProps, pinState, true));
        }
        if (pinState == PinState.Pin) {
            GroupsClient groupsClient = this.f14120e;
            GroupPinStoryInputData.Source source = GroupPinStoryInputData.Source.GROUP_MALL;
            GroupPinStoryInputData groupPinStoryInputData = new GroupPinStoryInputData();
            groupPinStoryInputData.a("group_id", graphQLStory.aJ().b());
            GraphQlCallInput graphQlCallInput = groupPinStoryInputData;
            graphQlCallInput.a("story_id", graphQLStory.c());
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("source", source);
            graphQlCallInput = graphQlCallInput;
            GraphQlQueryString groupPinStoryMutationString = new GroupPinStoryMutationString();
            groupPinStoryMutationString.a("input", graphQlCallInput);
            MutationRequest a2 = GraphQLRequest.a(groupPinStoryMutationString);
            if (groupsClient.f14754b.a()) {
                LocalGroupModerationFieldsModel.Builder builder = new LocalGroupModerationFieldsModel.Builder();
                builder.f14781a = graphQLStory.c();
                builder = builder;
                builder.f14784d = true;
                builder = builder;
                builder.f14785e = false;
                a2.a(builder.m17110a());
                a2.d = true;
            }
            a = Futures.a(groupsClient.f14753a.a(a2), Functions.constant(null));
        } else {
            a = this.f14120e.m16962a(graphQLStory, GroupUnpinStoryInputData.Source.GROUP_MALL);
        }
        this.f14116a.a(a, new FutureCallback<Void>(this) {
            final /* synthetic */ GroupsFeedStoryModerationHelper f14093c;

            public void onSuccess(Object obj) {
                this.f14093c.f14117b.a(new StoryPinEvent(feedProps, pinState, false));
            }

            public void onFailure(Throwable th) {
                int i;
                PinState pinState = pinState;
                if (GroupsFeedStoryModerationHelper.m15667b(th) == 1376071) {
                    i = 2131239418;
                } else if (pinState == PinState.Pin) {
                    i = 2131239419;
                } else {
                    i = 2131239420;
                }
                this.f14093c.f14118c.b(new ToastBuilder(i));
                if (this.f14093c.f14126k.b()) {
                    this.f14093c.f14117b.a(new StoryPinEvent(feedProps, pinState == PinState.Pin ? PinState.Unpin : PinState.Pin, true));
                }
            }
        });
    }

    public final void m15672b(final FeedProps<GraphQLStory> feedProps) {
        if (this.f14126k.b()) {
            this.f14117b.a(new StoryApproveEvent(feedProps, true, true));
        }
        GroupsClient groupsClient = this.f14120e;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        GroupApprovePendingStoryInputData groupApprovePendingStoryInputData = new GroupApprovePendingStoryInputData();
        groupApprovePendingStoryInputData.a("group_id", graphQLStory.aJ().b());
        GraphQlCallInput graphQlCallInput = groupApprovePendingStoryInputData;
        graphQlCallInput.a("story_id", graphQLStory.c());
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString groupApprovePendingStoryMutationString = new GroupApprovePendingStoryMutationString();
        groupApprovePendingStoryMutationString.a("input", graphQlCallInput);
        MutationRequest a = GraphQLRequest.a(groupApprovePendingStoryMutationString);
        if (groupsClient.f14754b.a()) {
            LocalGroupModerationFieldsModel.Builder builder = new LocalGroupModerationFieldsModel.Builder();
            builder.f14781a = graphQLStory.c();
            builder = builder;
            builder.f14782b = true;
            a.a(builder.m17110a());
            a.d = true;
        }
        this.f14116a.a(Futures.a(groupsClient.f14753a.a(a), Functions.constant(null)), new FutureCallback<Void>(this) {
            final /* synthetic */ GroupsFeedStoryModerationHelper f14097b;

            public void onSuccess(Object obj) {
                if (this.f14097b.f14126k.b()) {
                    this.f14097b.f14117b.a(new StoryApproveEvent(feedProps, true, false));
                }
                this.f14097b.f14118c.b(new ToastBuilder(2131239422));
            }

            public void onFailure(Throwable th) {
                this.f14097b.f14118c.b(new ToastBuilder(2131239421));
                if (this.f14097b.f14126k.b()) {
                    this.f14097b.f14117b.a(new StoryApproveEvent(feedProps, false, true));
                }
            }
        });
    }

    public static String m15665a(GraphQLStory graphQLStory) {
        if (graphQLStory == null || graphQLStory.aJ() == null || graphQLStory.aJ().b() == null) {
            return null;
        }
        return graphQLStory.aJ().b();
    }

    public final void m15670a(final FeedProps<GraphQLStory> feedProps, Context context) {
        new Builder(context).b(context.getResources().getString(2131233442)).a(2131233456, new OnClickListener(this) {
            final /* synthetic */ GroupsFeedStoryModerationHelper f14110b;

            public void onClick(DialogInterface dialogInterface, int i) {
                GroupsFeedStoryModerationHelper.m15666a(this.f14110b, feedProps, 2131239425);
            }
        }).b(2131233563, null).b();
    }

    public static int m15667b(Throwable th) {
        if (th instanceof ApiException) {
            ApiException apiException = (ApiException) th;
            if (apiException.b() != null) {
                return apiException.b().a();
            }
        }
        return 0;
    }
}

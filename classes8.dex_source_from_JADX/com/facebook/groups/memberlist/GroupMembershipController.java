package com.facebook.groups.memberlist;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupAddAdminInputData;
import com.facebook.graphql.calls.GroupAddAdminInputData.AdminType;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.feed.data.ViewerStatusCache;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEventBus;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupAdminMemberEvent;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupBlockedMemberEvent;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupRemoveInviteEvent;
import com.facebook.groups.memberlist.event.GroupMemberUpdateEvents.GroupRemoveMemberEvent;
import com.facebook.groups.memberlist.protocol.GroupInviteMutationsModels.GroupRemoveInviteMutationModel;
import com.facebook.groups.memberlist.protocol.GroupInviteMutationsModels.GroupSendReminderMutationModel;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutations;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutations.GroupAddAdminMutationString;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsModels.GroupAddAdminMutationModel;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsModels.GroupBlockMutationModel;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsModels.GroupRemoveAdminMutationModel;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsModels.GroupRemoveMemberMutationModel;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsModels.GroupSuggestAdminMutationModel;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsModels.GroupUnblockMutationModel;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: extra_photo_title_text */
public class GroupMembershipController {
    public final String f14332a;
    public final ExecutorService f14333b;
    public final Resources f14334c;
    public final GraphQLQueryExecutor f14335d;
    public final Toaster f14336e;
    public final GroupMemberUpdateEventBus f14337f;
    private final ViewerStatusCache f14338g;

    /* compiled from: extra_photo_title_text */
    public class AnonymousClass10 implements FutureCallback<GraphQLResult<GroupRemoveInviteMutationModel>> {
        final /* synthetic */ String f14300a;
        final /* synthetic */ String f14301b;
        final /* synthetic */ String f14302c;
        final /* synthetic */ GroupMembershipController f14303d;

        public AnonymousClass10(GroupMembershipController groupMembershipController, String str, String str2, String str3) {
            this.f14303d = groupMembershipController;
            this.f14300a = str;
            this.f14301b = str2;
            this.f14302c = str3;
        }

        public void onSuccess(Object obj) {
            this.f14303d.f14337f.a(new GroupRemoveInviteEvent(this.f14300a, this.f14301b));
            this.f14303d.f14336e.b(new ToastBuilder(this.f14303d.f14334c.getString(2131239502, new Object[]{this.f14302c})));
        }

        public void onFailure(Throwable th) {
            this.f14303d.f14336e.b(new ToastBuilder(this.f14303d.f14334c.getString(2131239503)));
        }
    }

    /* compiled from: extra_photo_title_text */
    public class AnonymousClass11 implements FutureCallback<GraphQLResult<GroupSendReminderMutationModel>> {
        final /* synthetic */ String f14304a;
        final /* synthetic */ GroupMembershipController f14305b;

        public AnonymousClass11(GroupMembershipController groupMembershipController, String str) {
            this.f14305b = groupMembershipController;
            this.f14304a = str;
        }

        public void onSuccess(Object obj) {
            this.f14305b.f14336e.b(new ToastBuilder(this.f14305b.f14334c.getString(2131239504, new Object[]{this.f14304a})));
        }

        public void onFailure(Throwable th) {
            this.f14305b.f14336e.b(new ToastBuilder(this.f14305b.f14334c.getString(2131239505)));
        }
    }

    /* compiled from: extra_photo_title_text */
    public class C15471 implements FutureCallback<GraphQLResult<GroupBlockMutationModel>> {
        final /* synthetic */ String f14306a;
        final /* synthetic */ String f14307b;
        final /* synthetic */ String f14308c;
        final /* synthetic */ GroupMembershipController f14309d;

        public C15471(GroupMembershipController groupMembershipController, String str, String str2, String str3) {
            this.f14309d = groupMembershipController;
            this.f14306a = str;
            this.f14307b = str2;
            this.f14308c = str3;
        }

        public void onSuccess(Object obj) {
            this.f14309d.f14336e.b(new ToastBuilder(this.f14309d.f14334c.getString(2131239462, new Object[]{this.f14306a})));
            this.f14309d.f14337f.a(new GroupBlockedMemberEvent(this.f14307b, this.f14308c, true));
        }

        public void onFailure(Throwable th) {
            int i = 0;
            if (th instanceof ApiException) {
                ApiException apiException = (ApiException) th;
                if (apiException.b() != null) {
                    i = apiException.b().a();
                }
            }
            if (i == 1376049) {
                this.f14309d.f14336e.b(new ToastBuilder(this.f14309d.f14334c.getString(2131239465)));
            } else {
                this.f14309d.f14336e.b(new ToastBuilder(this.f14309d.f14334c.getString(2131239464)));
            }
        }
    }

    /* compiled from: extra_photo_title_text */
    public class C15482 implements FutureCallback<GraphQLResult<GroupUnblockMutationModel>> {
        final /* synthetic */ String f14310a;
        final /* synthetic */ String f14311b;
        final /* synthetic */ String f14312c;
        final /* synthetic */ GroupMembershipController f14313d;

        public C15482(GroupMembershipController groupMembershipController, String str, String str2, String str3) {
            this.f14313d = groupMembershipController;
            this.f14310a = str;
            this.f14311b = str2;
            this.f14312c = str3;
        }

        public void onSuccess(Object obj) {
            this.f14313d.f14336e.b(new ToastBuilder(this.f14313d.f14334c.getString(2131239463, new Object[]{this.f14310a})));
            this.f14313d.f14337f.a(new GroupBlockedMemberEvent(this.f14311b, this.f14312c, false));
        }

        public void onFailure(Throwable th) {
            this.f14313d.f14336e.b(new ToastBuilder(this.f14313d.f14334c.getString(2131239466)));
        }
    }

    /* compiled from: extra_photo_title_text */
    public class C15504 implements FutureCallback<GraphQLResult<GroupRemoveAdminMutationModel>> {
        final /* synthetic */ String f14317a;
        final /* synthetic */ String f14318b;
        final /* synthetic */ GroupMembershipController f14319c;

        public C15504(GroupMembershipController groupMembershipController, String str, String str2) {
            this.f14319c = groupMembershipController;
            this.f14317a = str;
            this.f14318b = str2;
        }

        public void onSuccess(Object obj) {
            this.f14319c.f14336e.b(new ToastBuilder(this.f14319c.f14334c.getString(2131239486)));
            GroupMembershipController.m15916a(this.f14319c, this.f14317a, this.f14318b, GraphQLGroupAdminType.NONE);
        }

        public void onFailure(Throwable th) {
            this.f14319c.f14336e.b(new ToastBuilder(this.f14319c.f14334c.getString(2131239485)));
        }
    }

    /* compiled from: extra_photo_title_text */
    public class C15515 implements FutureCallback<GraphQLResult<GroupRemoveMemberMutationModel>> {
        final /* synthetic */ String f14320a;
        final /* synthetic */ String f14321b;
        final /* synthetic */ String f14322c;
        final /* synthetic */ GroupMembershipController f14323d;

        public C15515(GroupMembershipController groupMembershipController, String str, String str2, String str3) {
            this.f14323d = groupMembershipController;
            this.f14320a = str;
            this.f14321b = str2;
            this.f14322c = str3;
        }

        public void onSuccess(Object obj) {
            this.f14323d.f14336e.b(new ToastBuilder(this.f14323d.f14334c.getString(2131239461, new Object[]{this.f14320a})));
            this.f14323d.f14337f.a(new GroupRemoveMemberEvent(this.f14321b, this.f14322c));
        }

        public void onFailure(Throwable th) {
            this.f14323d.f14336e.b(new ToastBuilder(this.f14323d.f14334c.getString(2131239467)));
        }
    }

    /* compiled from: extra_photo_title_text */
    public class C15537 implements FutureCallback<GraphQLResult<GroupRemoveAdminMutationModel>> {
        final /* synthetic */ String f14327a;
        final /* synthetic */ String f14328b;
        final /* synthetic */ GroupMembershipController f14329c;

        public C15537(GroupMembershipController groupMembershipController, String str, String str2) {
            this.f14329c = groupMembershipController;
            this.f14327a = str;
            this.f14328b = str2;
        }

        public void onSuccess(Object obj) {
            this.f14329c.f14336e.b(new ToastBuilder(this.f14329c.f14334c.getString(2131239469)));
            GroupMembershipController.m15916a(this.f14329c, this.f14327a, this.f14328b, GraphQLGroupAdminType.NONE);
        }

        public void onFailure(Throwable th) {
            this.f14329c.f14336e.b(new ToastBuilder(this.f14329c.f14334c.getString(2131239468)));
        }
    }

    /* compiled from: extra_photo_title_text */
    public class C15548 implements OnClickListener {
        final /* synthetic */ GroupMembershipController f14330a;

        public C15548(GroupMembershipController groupMembershipController) {
            this.f14330a = groupMembershipController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: extra_photo_title_text */
    public class C15559 implements FutureCallback<GraphQLResult<GroupSuggestAdminMutationModel>> {
        final /* synthetic */ GroupMembershipController f14331a;

        public C15559(GroupMembershipController groupMembershipController) {
            this.f14331a = groupMembershipController;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            this.f14331a.f14336e.b(new ToastBuilder(this.f14331a.f14334c.getString(2131239501)));
        }
    }

    public static GroupMembershipController m15917b(InjectorLike injectorLike) {
        return new GroupMembershipController(ResourcesMethodAutoProvider.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), Toaster.b(injectorLike), GroupMemberUpdateEventBus.m15974a(injectorLike), ViewerStatusCache.m15635a(injectorLike));
    }

    @Inject
    public GroupMembershipController(Resources resources, String str, ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, Toaster toaster, GroupMemberUpdateEventBus groupMemberUpdateEventBus, ViewerStatusCache viewerStatusCache) {
        this.f14334c = resources;
        this.f14332a = str;
        this.f14333b = executorService;
        this.f14335d = graphQLQueryExecutor;
        this.f14336e = toaster;
        this.f14337f = groupMemberUpdateEventBus;
        this.f14338g = viewerStatusCache;
    }

    public final void m15918a(final String str, final String str2) {
        GroupAddAdminInputData c = new GroupAddAdminInputData().a(this.f14332a).b(str).c(str2);
        c.a("admin_type", AdminType.MODERATOR);
        GraphQlCallInput graphQlCallInput = c;
        GroupAddAdminMutationString a = GroupMemberAdminMutations.m16353a();
        a.a("input", graphQlCallInput);
        Futures.a(this.f14335d.a(GraphQLRequest.a(a)), new FutureCallback<GraphQLResult<GroupAddAdminMutationModel>>(this) {
            final /* synthetic */ GroupMembershipController f14316c;

            public void onSuccess(Object obj) {
                this.f14316c.f14336e.b(new ToastBuilder(this.f14316c.f14334c.getString(2131239484)));
                GroupMembershipController.m15916a(this.f14316c, str, str2, GraphQLGroupAdminType.MODERATOR);
            }

            public void onFailure(Throwable th) {
                this.f14316c.f14336e.b(new ToastBuilder(this.f14316c.f14334c.getString(2131239483)));
            }
        }, this.f14333b);
    }

    public final void m15919c(final String str, final String str2) {
        GroupAddAdminInputData c = new GroupAddAdminInputData().a(this.f14332a).b(str).c(str2);
        GroupAddAdminMutationString a = GroupMemberAdminMutations.m16353a();
        a.a("input", c);
        Futures.a(this.f14335d.a(GraphQLRequest.a(a)), new FutureCallback<GraphQLResult<GroupAddAdminMutationModel>>(this) {
            final /* synthetic */ GroupMembershipController f14326c;

            public void onSuccess(Object obj) {
                this.f14326c.f14336e.b(new ToastBuilder(this.f14326c.f14334c.getString(2131239460)));
                GroupMembershipController.m15916a(this.f14326c, str, str2, GraphQLGroupAdminType.ADMIN);
            }

            public void onFailure(Throwable th) {
                this.f14326c.f14336e.b(new ToastBuilder(this.f14326c.f14334c.getString(2131239459)));
            }
        }, this.f14333b);
    }

    public static void m15916a(GroupMembershipController groupMembershipController, String str, String str2, GraphQLGroupAdminType graphQLGroupAdminType) {
        groupMembershipController.f14337f.a(new GroupAdminMemberEvent(str, str2, graphQLGroupAdminType));
        if (groupMembershipController.f14332a.equals(str2)) {
            groupMembershipController.f14338g.m15636a(str, graphQLGroupAdminType);
        }
    }
}

package com.facebook.groups.feed.ui;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.debug.log.BLog;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.fbui.widget.megaphone.Megaphone.OnDismissListener;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupUserInviteAcceptInputData;
import com.facebook.graphql.calls.GroupUserInviteAcceptInputData.Source;
import com.facebook.graphql.calls.GroupUserInviteDeclineInputData;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel.Builder;
import com.facebook.groups.feed.ui.GroupsFeedFragment.AnonymousClass15;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.groups.mutations.protocol.GroupMutations.GroupAcceptInvitationToJoinMutationString;
import com.facebook.groups.mutations.protocol.GroupMutations.GroupDeclineInvitationToJoinMutationString;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.remoteasset.RemoteAsset;
import com.facebook.remoteasset.RemoteAssetUriGenerator;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TimelineFragment.onFragmentCreate.getViewportListener */
public class GroupMallInvitedMegaphoneController implements GroupMallMegaphoneController {
    private static final String f22020a = GroupMallInvitedMegaphoneController.class.getName();
    public final AnonymousClass15 f22021b;
    private final Resources f22022c;
    public final GroupsClient f22023d;
    private final DefaultAndroidThreadUtil f22024e;
    private final AnalyticsLogger f22025f;
    public FetchGroupInformationModel f22026g;
    private Uri f22027h;

    /* compiled from: TimelineFragment.onFragmentCreate.getViewportListener */
    class C31531 implements OnClickListener {
        final /* synthetic */ GroupMallInvitedMegaphoneController f22015a;

        C31531(GroupMallInvitedMegaphoneController groupMallInvitedMegaphoneController) {
            this.f22015a = groupMallInvitedMegaphoneController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1718106130);
            if (GroupMallInvitedMegaphoneController.m23160j(this.f22015a)) {
                GroupsClient groupsClient = this.f22015a.f22023d;
                String b = this.f22015a.f22026g.x().b();
                Source source = Source.MOBILE_GROUP_JOIN;
                GroupUserInviteAcceptInputData groupUserInviteAcceptInputData = new GroupUserInviteAcceptInputData();
                groupUserInviteAcceptInputData.a("invite_id", b);
                GraphQlCallInput graphQlCallInput = groupUserInviteAcceptInputData;
                graphQlCallInput.a("source", source);
                graphQlCallInput = graphQlCallInput;
                GraphQlQueryString groupAcceptInvitationToJoinMutationString = new GroupAcceptInvitationToJoinMutationString();
                groupAcceptInvitationToJoinMutationString.a("input", graphQlCallInput);
                ListenableFuture a2 = groupsClient.a.a(GraphQLRequest.a(groupAcceptInvitationToJoinMutationString));
                Builder a3 = Builder.a(FetchGroupInformationModel.a(this.f22015a.f22026g));
                a3.p = GraphQLGroupJoinState.MEMBER;
                a3.o = null;
                GroupMallInvitedMegaphoneController.m23159a(this.f22015a, this.f22015a.f22026g, a3.a(), a2);
                LogUtils.a(-49769406, a);
                return;
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1194400427, a);
        }
    }

    /* compiled from: TimelineFragment.onFragmentCreate.getViewportListener */
    class C31542 implements OnClickListener {
        final /* synthetic */ GroupMallInvitedMegaphoneController f22016a;

        C31542(GroupMallInvitedMegaphoneController groupMallInvitedMegaphoneController) {
            this.f22016a = groupMallInvitedMegaphoneController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1292877996);
            if (GroupMallInvitedMegaphoneController.m23160j(this.f22016a)) {
                GroupsClient groupsClient = this.f22016a.f22023d;
                String b = this.f22016a.f22026g.x().b();
                GroupUserInviteDeclineInputData.Source source = GroupUserInviteDeclineInputData.Source.MOBILE_GROUP_JOIN;
                GraphQlQueryString groupDeclineInvitationToJoinMutationString = new GroupDeclineInvitationToJoinMutationString();
                GroupUserInviteDeclineInputData groupUserInviteDeclineInputData = new GroupUserInviteDeclineInputData();
                groupUserInviteDeclineInputData.a("invite_id", b);
                GraphQlCallInput graphQlCallInput = groupUserInviteDeclineInputData;
                graphQlCallInput.a("source", source);
                groupDeclineInvitationToJoinMutationString.a("input", graphQlCallInput);
                ListenableFuture a2 = groupsClient.a.a(GraphQLRequest.a(groupDeclineInvitationToJoinMutationString));
                Builder a3 = Builder.a(FetchGroupInformationModel.a(this.f22016a.f22026g));
                a3.o = null;
                GroupMallInvitedMegaphoneController.m23159a(this.f22016a, this.f22016a.f22026g, a3.a(), a2);
                LogUtils.a(2058889154, a);
                return;
            }
            Logger.a(2, EntryType.UI_INPUT_END, 432886891, a);
        }
    }

    @Inject
    public GroupMallInvitedMegaphoneController(@Assisted AnonymousClass15 anonymousClass15, RemoteAssetUriGenerator remoteAssetUriGenerator, Resources resources, DefaultAndroidThreadUtil defaultAndroidThreadUtil, GroupsClient groupsClient, AnalyticsLogger analyticsLogger) {
        this.f22021b = anonymousClass15;
        this.f22024e = defaultAndroidThreadUtil;
        this.f22023d = groupsClient;
        RemoteAsset.Builder builder = new RemoteAsset.Builder();
        builder.a = "invitedMemberMegaphone";
        builder = builder;
        builder.b = "Groups";
        builder = builder;
        builder.c = "png";
        this.f22027h = Uri.parse(remoteAssetUriGenerator.a(builder.a()));
        this.f22022c = resources;
        this.f22025f = analyticsLogger;
    }

    public final String mo977a() {
        return this.f22022c.getString(2131238064);
    }

    public final String mo978b() {
        if (!m23160j(this)) {
            return "";
        }
        DraculaReturnValue b = this.f22026g.b();
        MutableFlatBuffer mutableFlatBuffer = b.a;
        int i = b.b;
        int i2 = b.c;
        return this.f22022c.getString(2131238065, new Object[]{this.f22026g.x().j().c(), mutableFlatBuffer.k(i, 13)});
    }

    public final String mo979c() {
        return this.f22022c.getString(2131238067);
    }

    public final String mo980d() {
        return this.f22022c.getString(2131238066);
    }

    public final Uri mo981e() {
        return this.f22027h;
    }

    public final OnClickListener mo982f() {
        return new C31531(this);
    }

    public final OnClickListener mo983g() {
        return new C31542(this);
    }

    public final OnDismissListener mo984h() {
        return null;
    }

    public final void mo985i() {
        if (m23160j(this)) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("group_invite_dialog_shown");
            honeyClientEvent.b("group_id", this.f22026g.gW_());
            honeyClientEvent.b("invite_id", this.f22026g.x().b());
            honeyClientEvent.b("inviter_id", this.f22026g.x().j().b());
            this.f22025f.a(honeyClientEvent);
        }
    }

    public static void m23159a(GroupMallInvitedMegaphoneController groupMallInvitedMegaphoneController, final FetchGroupInformationModel fetchGroupInformationModel, final FetchGroupInformationModel fetchGroupInformationModel2, ListenableFuture listenableFuture) {
        groupMallInvitedMegaphoneController.f22021b.m23231a(fetchGroupInformationModel, fetchGroupInformationModel2);
        groupMallInvitedMegaphoneController.f22024e.a(listenableFuture, new FutureCallback<GraphQLResult>(groupMallInvitedMegaphoneController) {
            final /* synthetic */ GroupMallInvitedMegaphoneController f22019c;

            public void onSuccess(@Nullable Object obj) {
                this.f22019c.f22021b.m23232a(false);
            }

            public void onFailure(Throwable th) {
                this.f22019c.f22021b.m23231a(fetchGroupInformationModel2, fetchGroupInformationModel);
                this.f22019c.f22021b.m23232a(true);
            }
        });
    }

    public static boolean m23160j(GroupMallInvitedMegaphoneController groupMallInvitedMegaphoneController) {
        if (groupMallInvitedMegaphoneController.f22026g != null && groupMallInvitedMegaphoneController.f22026g.x() != null && groupMallInvitedMegaphoneController.f22026g.x().j() != null) {
            return true;
        }
        BLog.c(f22020a, "Invitation model is null");
        return false;
    }
}

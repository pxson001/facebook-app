package com.facebook.groups.feed.ui;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.feed.ui.GroupMallMegaphoneController.MallMegaphoneType;
import com.facebook.groups.feed.ui.GroupsFeedFragment.AnonymousClass15;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.remoteasset.RemoteAssetUriGenerator;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Time between Process Status analytics events */
public class GroupsFeedMegaphoneControllerProvider {
    private final GroupMallNotifMegaphoneControllerProvider f22161a;
    private final GroupMallInvitedMegaphoneControllerProvider f22162b;
    private final Provider<Boolean> f22163c;
    private GroupMallInvitedMegaphoneController f22164d;
    private GroupMallNotifMegaphoneController f22165e;

    public static GroupsFeedMegaphoneControllerProvider m23302b(InjectorLike injectorLike) {
        return new GroupsFeedMegaphoneControllerProvider((GroupMallNotifMegaphoneControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GroupMallNotifMegaphoneControllerProvider.class), (GroupMallInvitedMegaphoneControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GroupMallInvitedMegaphoneControllerProvider.class), IdBasedProvider.a(injectorLike, 4015));
    }

    @Inject
    public GroupsFeedMegaphoneControllerProvider(GroupMallNotifMegaphoneControllerProvider groupMallNotifMegaphoneControllerProvider, GroupMallInvitedMegaphoneControllerProvider groupMallInvitedMegaphoneControllerProvider, Provider<Boolean> provider) {
        this.f22162b = groupMallInvitedMegaphoneControllerProvider;
        this.f22161a = groupMallNotifMegaphoneControllerProvider;
        this.f22163c = provider;
    }

    @Nullable
    public final GroupMallMegaphoneController m23304a(FetchGroupInformationModel fetchGroupInformationModel, AnonymousClass15 anonymousClass15) {
        MallMegaphoneType a = m23303a(fetchGroupInformationModel);
        if (a == null) {
            return null;
        }
        switch (a) {
            case INVITED_MEMBER:
                if (this.f22164d == null) {
                    GroupMallInvitedMegaphoneControllerProvider groupMallInvitedMegaphoneControllerProvider = this.f22162b;
                    this.f22164d = new GroupMallInvitedMegaphoneController(anonymousClass15, RemoteAssetUriGenerator.b(groupMallInvitedMegaphoneControllerProvider), ResourcesMethodAutoProvider.a(groupMallInvitedMegaphoneControllerProvider), DefaultAndroidThreadUtil.b(groupMallInvitedMegaphoneControllerProvider), GroupsClient.b(groupMallInvitedMegaphoneControllerProvider), AnalyticsLoggerMethodAutoProvider.a(groupMallInvitedMegaphoneControllerProvider));
                }
                this.f22164d.f22026g = fetchGroupInformationModel;
                return this.f22164d;
            case NOTIF_SETTINGS:
                if (this.f22165e == null) {
                    this.f22165e = this.f22161a.m23181a(anonymousClass15);
                }
                this.f22165e.f22037f = fetchGroupInformationModel;
                return this.f22165e;
            default:
                return null;
        }
    }

    @Nullable
    public final MallMegaphoneType m23303a(FetchGroupInformationModel fetchGroupInformationModel) {
        if (fetchGroupInformationModel == null) {
            return null;
        }
        Object obj;
        if (fetchGroupInformationModel.p() == null || !(fetchGroupInformationModel.p().equals(GraphQLGroupJoinState.CAN_JOIN) || fetchGroupInformationModel.p().equals(GraphQLGroupJoinState.CAN_REQUEST))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (!((Boolean) this.f22163c.get()).booleanValue() || r1 == null || fetchGroupInformationModel.x() == null || fetchGroupInformationModel.x().j() == null) {
            return (fetchGroupInformationModel == null || !fetchGroupInformationModel.j()) ? null : MallMegaphoneType.NOTIF_SETTINGS;
        } else {
            return MallMegaphoneType.INVITED_MEMBER;
        }
    }
}

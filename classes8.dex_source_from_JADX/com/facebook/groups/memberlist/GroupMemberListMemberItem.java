package com.facebook.groups.memberlist;

import com.facebook.groups.memberlist.GroupMemberListItem.GroupMemberItemViewType;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.InviteeDataModel.InviteeModel;
import com.facebook.groups.widget.memberrow.protocol.MemberDataInterfaces.GroupMemberData;
import com.google.common.base.Objects;

/* compiled from: extra_service_launched_from_page */
public class GroupMemberListMemberItem implements GroupMemberListItem {
    public final AdminState f14269a;
    private final BlockState f14270b;
    public final MemberSection f14271c;
    public final GroupMemberData f14272d;
    public final GroupMemberAddedByInformation f14273e;
    private final InvitedState f14274f;
    public final InviteeModel f14275g;

    /* compiled from: extra_service_launched_from_page */
    public enum AdminState {
        ADMIN,
        MODERATOR,
        NOT_ADMIN
    }

    /* compiled from: extra_service_launched_from_page */
    public enum BlockState {
        BLOCKED,
        NOT_BLOCKED
    }

    /* compiled from: extra_service_launched_from_page */
    public enum InvitedState {
        ONSITE_INVITE,
        EMAIL_INVITE,
        NONE
    }

    /* compiled from: extra_service_launched_from_page */
    public enum MemberSection {
        FRIEND,
        NON_FRIEND_MEMBER,
        INVITES,
        ADMIN,
        MODERATOR
    }

    public GroupMemberListMemberItem(GroupMemberData groupMemberData, AdminState adminState, BlockState blockState, MemberSection memberSection, GroupMemberAddedByInformation groupMemberAddedByInformation) {
        this.f14272d = groupMemberData;
        this.f14269a = adminState;
        this.f14270b = blockState;
        this.f14271c = memberSection;
        this.f14273e = groupMemberAddedByInformation;
        this.f14274f = InvitedState.NONE;
        this.f14275g = null;
    }

    public GroupMemberListMemberItem(GroupMemberData groupMemberData, AdminState adminState, BlockState blockState, GroupMemberAddedByInformation groupMemberAddedByInformation) {
        this.f14272d = groupMemberData;
        this.f14269a = adminState;
        this.f14270b = blockState;
        this.f14271c = groupMemberData.c() ? MemberSection.FRIEND : MemberSection.NON_FRIEND_MEMBER;
        this.f14273e = groupMemberAddedByInformation;
        this.f14274f = InvitedState.NONE;
        this.f14275g = null;
    }

    public GroupMemberListMemberItem(GroupMemberData groupMemberData, AdminState adminState, BlockState blockState, GroupMemberAddedByInformation groupMemberAddedByInformation, InvitedState invitedState, InviteeModel inviteeModel) {
        this.f14272d = groupMemberData;
        this.f14269a = adminState;
        this.f14270b = blockState;
        this.f14273e = groupMemberAddedByInformation;
        this.f14274f = invitedState;
        this.f14275g = inviteeModel;
        if (groupMemberData.c()) {
            this.f14271c = MemberSection.FRIEND;
        } else if (this.f14274f == InvitedState.NONE) {
            this.f14271c = MemberSection.NON_FRIEND_MEMBER;
        } else {
            this.f14271c = MemberSection.INVITES;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return m15881k().equals(((GroupMemberListMemberItem) obj).m15881k());
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f14272d.b()});
    }

    public String toString() {
        return this.f14272d.he_();
    }

    public final boolean m15884d() {
        return this.f14269a == AdminState.ADMIN;
    }

    public final boolean m15885e() {
        return this.f14269a == AdminState.MODERATOR;
    }

    public final boolean m15886f() {
        return this.f14270b == BlockState.BLOCKED;
    }

    public final boolean m15887g() {
        if (this.f14274f == null || this.f14274f.name() == null || this.f14274f.name().equals(InvitedState.NONE.name())) {
            return false;
        }
        return true;
    }

    public final boolean m15883a(String str) {
        return (this.f14273e == null || str == null) ? false : str.equals(this.f14273e.f14223b);
    }

    private String m15881k() {
        return this.f14272d.b();
    }

    public final GroupMemberItemViewType mo872a() {
        return GroupMemberItemViewType.GroupMemberRow;
    }
}

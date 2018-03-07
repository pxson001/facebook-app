package com.facebook.groups.memberlist;

import android.support.v4.util.Pair;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.AdminState;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.BlockState;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.InvitedState;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.MemberSection;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesList;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesList.FetchGroupMemberProfilesListString;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.FetchGroupMemberProfilesListModel;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesConnectionDefaultFieldsModel.EdgesModel.NodeModel;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberProfilesListModels.MemberProfilesPageInfoFieldsModel;
import com.facebook.groups.members.GroupMemberBaseListLoader;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: extra_place_suggestion_complete */
public final class GroupMembersPagedListLoader extends GroupMemberBaseListLoader<FetchGroupMemberProfilesListModel> {
    private ImmutableList<GroupMemberListMemberItem> f14293e = RegularImmutableList.a;
    private boolean f14294f;
    private Integer f14295g;
    private String f14296h;
    private String f14297i;
    private final String f14298j;
    private final boolean f14299k;

    @Inject
    public GroupMembersPagedListLoader(TasksManager tasksManager, @Assisted String str, @Assisted String str2, @Assisted Boolean bool, @Assisted Boolean bool2, @Assisted Integer num, GraphQLQueryExecutor graphQLQueryExecutor, @Assisted MemberListLoaderListener memberListLoaderListener, String str3) {
        super(tasksManager, graphQLQueryExecutor, memberListLoaderListener);
        this.f14294f = bool.booleanValue();
        this.f14298j = str3;
        this.f14296h = str;
        this.f14295g = num;
        this.f14297i = str2;
        this.f14299k = bool2.booleanValue();
    }

    protected final void m15914j() {
        this.f14293e = RegularImmutableList.a;
    }

    public final boolean m15911c() {
        return true;
    }

    protected final TypedGraphQlQueryString<FetchGroupMemberProfilesListModel> m15909a(String str) {
        int i;
        int i2 = 12;
        boolean isNullOrEmpty = Strings.isNullOrEmpty(str);
        FetchGroupMemberProfilesListString a = FetchGroupMemberProfilesList.m16190a();
        GraphQlQueryString a2 = a.a("group_id", this.f14296h).a("search_term", this.f14297i).a("profile_image_size", String.valueOf(this.f14295g)).a("friend_count", "12").a("friend_end_cursor", str);
        String str2 = "other_count";
        if (isNullOrEmpty) {
            i = 12;
        } else {
            i = 1;
        }
        GraphQlQueryString a3 = a2.a(str2, String.valueOf(i));
        String str3 = "invite_count";
        if (!isNullOrEmpty) {
            i2 = 1;
        }
        a3.a(str3, String.valueOf(i2));
        if (this.c != null) {
            if (this.c.get(MemberSection.NON_FRIEND_MEMBER) != null) {
                a.a("other_end_cursor", (String) ((Pair) this.c.get(MemberSection.NON_FRIEND_MEMBER)).a);
            }
            if (this.c.get(MemberSection.INVITES) != null) {
                a.a("invite_end_cursor", (String) ((Pair) this.c.get(MemberSection.INVITES)).a);
            }
        }
        return a;
    }

    protected final TypedGraphQlQueryString m15908a(Enum enumR) {
        FetchGroupMemberProfilesListString a = FetchGroupMemberProfilesList.m16190a();
        a.a("group_id", this.f14296h).a("search_term", this.f14297i).a("profile_image_size", String.valueOf(this.f14295g)).a("friend_end_cursor", this.a);
        if (this.c != null) {
            if (this.c.get(MemberSection.NON_FRIEND_MEMBER) != null) {
                a.a("other_end_cursor", (String) ((Pair) this.c.get(MemberSection.NON_FRIEND_MEMBER)).a);
            }
            if (this.c.get(MemberSection.INVITES) != null) {
                a.a("invite_end_cursor", (String) ((Pair) this.c.get(MemberSection.INVITES)).a);
            }
            if (this.c.get(MemberSection.FRIEND) != null) {
                a.a("friend_end_cursor", (String) ((Pair) this.c.get(MemberSection.FRIEND)).a);
            }
        }
        if (enumR == MemberSection.NON_FRIEND_MEMBER) {
            a.a("other_count", "12").a("friend_count", "1").a("invite_count", "1");
            return a;
        } else if (enumR == MemberSection.INVITES) {
            a.a("other_count", "1").a("friend_count", "1").a("invite_count", "12");
            return a;
        } else if (enumR != MemberSection.FRIEND) {
            return null;
        } else {
            a.a("other_count", "1").a("invite_count", "1").a("friend_count", "50");
            return a;
        }
    }

    protected final void m15910a(GraphQLResult<FetchGroupMemberProfilesListModel> graphQLResult) {
        MemberProfilesPageInfoFieldsModel memberProfilesPageInfoFieldsModel;
        Builder builder = new Builder();
        builder.b(this.f14293e);
        Builder builder2 = ImmutableList.builder();
        if (!(graphQLResult == null || graphQLResult.d() == null || ((FetchGroupMemberProfilesListModel) graphQLResult.d()).m16206a() == null)) {
            this.d = ((FetchGroupMemberProfilesListModel) graphQLResult.d()).m16206a().m16201l();
            if (!(((FetchGroupMemberProfilesListModel) graphQLResult.d()).m16206a().m16196a() == null || ((FetchGroupMemberProfilesListModel) graphQLResult.d()).m16206a().m16196a().m16265a() == null)) {
                builder2.b(((FetchGroupMemberProfilesListModel) graphQLResult.d()).m16206a().m16196a().m16265a());
            }
            if (!(((FetchGroupMemberProfilesListModel) graphQLResult.d()).m16206a().m16200k() == null || ((FetchGroupMemberProfilesListModel) graphQLResult.d()).m16206a().m16200k().m16265a() == null)) {
                builder2.b(((FetchGroupMemberProfilesListModel) graphQLResult.d()).m16206a().m16200k().m16265a());
            }
            if (!(((FetchGroupMemberProfilesListModel) graphQLResult.d()).m16206a().m16199j() == null || ((FetchGroupMemberProfilesListModel) graphQLResult.d()).m16206a().m16199j().m16265a() == null || this.f14299k)) {
                builder2.b(((FetchGroupMemberProfilesListModel) graphQLResult.d()).m16206a().m16199j().m16265a());
            }
        }
        ImmutableList b = builder2.b();
        int i = 0;
        while (i < b.size()) {
            if (!(b.get(i) == null || ((EdgesModel) b.get(i)).m16261k() == null || (this.f14294f && ((EdgesModel) b.get(i)).m16261k().m16249b().equals(this.f14298j)))) {
                GroupMemberAddedByInformation groupMemberAddedByInformation;
                InvitedState invitedState = InvitedState.NONE;
                if (((EdgesModel) b.get(i)).m16261k().m16253j().g() == 2135465544) {
                    invitedState = InvitedState.EMAIL_INVITE;
                } else if (((EdgesModel) b.get(i)).m16261k().m16253j().g() == 1476491891) {
                    invitedState = InvitedState.ONSITE_INVITE;
                }
                NodeModel k = ((EdgesModel) b.get(i)).m16261k();
                AdminState adminState = AdminState.NOT_ADMIN;
                BlockState blockState = BlockState.NOT_BLOCKED;
                if (((EdgesModel) b.get(i)).m16258a() == null) {
                    groupMemberAddedByInformation = null;
                } else {
                    groupMemberAddedByInformation = new GroupMemberAddedByInformation(((EdgesModel) b.get(i)).m16258a().m16230k(), ((EdgesModel) b.get(i)).m16258a().m16229j(), ((EdgesModel) b.get(i)).m16260j());
                }
                builder.c(new GroupMemberListMemberItem(k, adminState, blockState, groupMemberAddedByInformation, invitedState, ((EdgesModel) b.get(i)).m16261k().m16254k()));
            }
            i++;
        }
        if (graphQLResult.d() == null || ((FetchGroupMemberProfilesListModel) graphQLResult.d()).m16206a() == null || ((FetchGroupMemberProfilesListModel) graphQLResult.d()).m16206a().m16196a() == null) {
            memberProfilesPageInfoFieldsModel = null;
        } else {
            memberProfilesPageInfoFieldsModel = ((FetchGroupMemberProfilesListModel) graphQLResult.d()).m16206a().m16196a().m16266j();
        }
        this.f14293e = builder.b();
        this.a = memberProfilesPageInfoFieldsModel != null ? memberProfilesPageInfoFieldsModel.m16273a() : null;
        boolean z = memberProfilesPageInfoFieldsModel == null || !memberProfilesPageInfoFieldsModel.m16275j();
        this.b = z;
        m15907b(graphQLResult);
        g();
    }

    protected final String m15912h() {
        return "Group members fetch failed";
    }

    protected final ImmutableList<? extends Object> m15913i() {
        return this.f14293e;
    }

    private void m15907b(GraphQLResult<FetchGroupMemberProfilesListModel> graphQLResult) {
        if (graphQLResult != null && graphQLResult.e != null && ((FetchGroupMemberProfilesListModel) graphQLResult.e).m16206a() != null) {
            if (((FetchGroupMemberProfilesListModel) graphQLResult.e).m16206a().m16196a() != null && b(MemberSection.FRIEND)) {
                this.c.put(MemberSection.FRIEND, m15906a(((FetchGroupMemberProfilesListModel) graphQLResult.e).m16206a().m16196a().m16266j()));
            }
            if (((FetchGroupMemberProfilesListModel) graphQLResult.e).m16206a().m16200k() != null && b(MemberSection.NON_FRIEND_MEMBER)) {
                this.c.put(MemberSection.NON_FRIEND_MEMBER, m15906a(((FetchGroupMemberProfilesListModel) graphQLResult.e).m16206a().m16200k().m16266j()));
            }
            if (((FetchGroupMemberProfilesListModel) graphQLResult.e).m16206a().m16199j() != null && b(MemberSection.INVITES)) {
                this.c.put(MemberSection.INVITES, m15906a(((FetchGroupMemberProfilesListModel) graphQLResult.e).m16206a().m16199j().m16266j()));
            }
        }
    }

    private static Pair<String, Boolean> m15906a(MemberProfilesPageInfoFieldsModel memberProfilesPageInfoFieldsModel) {
        Object a = memberProfilesPageInfoFieldsModel != null ? memberProfilesPageInfoFieldsModel.m16273a() : null;
        boolean z = memberProfilesPageInfoFieldsModel == null || !memberProfilesPageInfoFieldsModel.m16275j();
        return Pair.a(a, Boolean.valueOf(z));
    }
}

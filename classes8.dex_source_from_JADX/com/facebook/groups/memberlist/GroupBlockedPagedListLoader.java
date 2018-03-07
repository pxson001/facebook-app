package com.facebook.groups.memberlist;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.AdminState;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.BlockState;
import com.facebook.groups.memberlist.protocol.FetchGroupBlockedList.FetchGroupBlockedListString;
import com.facebook.groups.memberlist.protocol.FetchGroupBlockedListModels.FetchGroupBlockedListModel;
import com.facebook.groups.memberlist.protocol.FetchGroupBlockedListModels.FetchGroupBlockedListModel.GroupBannedMembersModel.EdgesModel;
import com.facebook.groups.memberlist.protocol.FetchGroupBlockedListModels.FetchGroupBlockedListModel.GroupBannedMembersModel.PageInfoModel;
import com.facebook.groups.members.GroupMemberBaseListLoader;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: extra_video_item */
public final class GroupBlockedPagedListLoader extends GroupMemberBaseListLoader<FetchGroupBlockedListModel> {
    private ImmutableList<GroupMemberListMemberItem> f14218e = RegularImmutableList.a;
    private Integer f14219f;
    private String f14220g;
    private String f14221h;

    @Inject
    public GroupBlockedPagedListLoader(TasksManager tasksManager, @Assisted String str, @Assisted String str2, @Assisted Integer num, GraphQLQueryExecutor graphQLQueryExecutor, @Assisted MemberListLoaderListener memberListLoaderListener) {
        super(tasksManager, graphQLQueryExecutor, memberListLoaderListener);
        this.f14220g = str;
        this.f14219f = num;
        this.f14221h = str2;
    }

    protected final void m15802a(GraphQLResult<FetchGroupBlockedListModel> graphQLResult) {
        PageInfoModel pageInfoModel;
        String str = null;
        Builder builder = new Builder();
        builder.b(this.f14218e);
        ImmutableList immutableList = RegularImmutableList.a;
        if (!(graphQLResult.e == null || ((FetchGroupBlockedListModel) graphQLResult.e).m16160a() == null || ((FetchGroupBlockedListModel) graphQLResult.e).m16160a().m16155a() == null)) {
            immutableList = ((FetchGroupBlockedListModel) graphQLResult.e).m16160a().m16155a();
        }
        if (!immutableList.isEmpty()) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) immutableList.get(i);
                if (edgesModel != null) {
                    builder.c(new GroupMemberListMemberItem(edgesModel.m16142a(), AdminState.NOT_ADMIN, BlockState.BLOCKED, null));
                }
            }
        }
        if (graphQLResult.e == null || ((FetchGroupBlockedListModel) graphQLResult.e).m16160a() == null) {
            pageInfoModel = null;
        } else {
            pageInfoModel = ((FetchGroupBlockedListModel) graphQLResult.e).m16160a().m16156j();
        }
        this.f14218e = builder.b();
        if (pageInfoModel != null) {
            str = pageInfoModel.m16149a();
        }
        this.a = str;
        boolean z = pageInfoModel == null || !pageInfoModel.m16151j();
        this.b = z;
        g();
    }

    protected final void m15805j() {
        this.f14218e = RegularImmutableList.a;
    }

    protected final TypedGraphQlQueryString<FetchGroupBlockedListModel> m15801a(String str) {
        GraphQlQueryString fetchGroupBlockedListString = new FetchGroupBlockedListString();
        fetchGroupBlockedListString.a("end_cursor", str).a("group_id", this.f14220g).a("search_term", this.f14221h).a("profile_image_size", String.valueOf(this.f14219f)).a("member_count", "12");
        return fetchGroupBlockedListString;
    }

    protected final String m15803h() {
        return "Group admin members fetch failed";
    }

    protected final ImmutableList<? extends Object> m15804i() {
        return this.f14218e;
    }
}

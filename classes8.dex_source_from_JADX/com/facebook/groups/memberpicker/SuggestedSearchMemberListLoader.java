package com.facebook.groups.memberpicker;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQuery;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQuery.GroupSuggestedMembersSearchQueryString;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.EdgesModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersSearchQueryModels.GroupSuggestedMembersSearchQueryModel.SuggestedMembersModel.PageInfoModel;
import com.facebook.groups.members.GroupMemberBaseListLoader;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: exp_date_input_controller_fragment_tag */
public final class SuggestedSearchMemberListLoader extends GroupMemberBaseListLoader<GroupSuggestedMembersSearchQueryModel> {
    private ImmutableList<User> f14621e = RegularImmutableList.a;
    private String f14622f;
    private String f14623g;

    @Inject
    public SuggestedSearchMemberListLoader(TasksManager tasksManager, @Assisted String str, @Assisted String str2, GraphQLQueryExecutor graphQLQueryExecutor, @Assisted MemberListLoaderListener memberListLoaderListener) {
        super(tasksManager, graphQLQueryExecutor, memberListLoaderListener);
        this.f14622f = str;
        this.f14623g = str2;
    }

    protected final TypedGraphQlQueryString<GroupSuggestedMembersSearchQueryModel> m16507a(String str) {
        GroupSuggestedMembersSearchQueryString a = GroupSuggestedMembersSearchQuery.m16766a();
        a.a("group_id", this.f14622f);
        a.a("search_term", this.f14623g);
        a.a("member_count_to_fetch", Integer.valueOf(12));
        a.a("afterCursor", this.a);
        return a;
    }

    protected final void m16508a(GraphQLResult<GroupSuggestedMembersSearchQueryModel> graphQLResult) {
        PageInfoModel pageInfoModel;
        String str = null;
        Builder builder = new Builder();
        builder.b(this.f14621e);
        if (graphQLResult.e == null || ((GroupSuggestedMembersSearchQueryModel) graphQLResult.e).m16811j() == null) {
            pageInfoModel = null;
        } else {
            SuggestedMembersModel j = ((GroupSuggestedMembersSearchQueryModel) graphQLResult.e).m16811j();
            ImmutableList asList = j.m16802a().asList();
            int size = asList.size();
            for (int i = 0; i < size; i++) {
                builder.c(SuggestedMemberListLoader.m16493a(((EdgesModel) asList.get(i)).m16790a(), null));
            }
            pageInfoModel = j.m16803j();
        }
        this.f14621e = builder.b();
        if (pageInfoModel != null) {
            str = pageInfoModel.m16796a();
        }
        this.a = str;
        boolean z = pageInfoModel == null || !pageInfoModel.m16798j();
        this.b = z;
        g();
    }

    protected final void m16511j() {
        this.f14621e = RegularImmutableList.a;
    }

    protected final ImmutableList<? extends Object> m16510i() {
        return this.f14621e;
    }

    protected final String m16509h() {
        return "Group suggested search member fetch failed";
    }
}

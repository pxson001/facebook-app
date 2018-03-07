package com.facebook.groups.memberpicker;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersCollectionQuery;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersCollectionQuery.GroupSuggestedMembersCollectionQueryString;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersCollectionQueryModels.GroupSuggestedMembersCollectionQueryModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersCollectionQueryModels.GroupSuggestedMembersCollectionQueryModel.SuggestedMembersModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersCollectionQueryModels.GroupSuggestedMembersCollectionQueryModel.SuggestedMembersModel.EdgesModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMembersCollectionQueryModels.GroupSuggestedMembersCollectionQueryModel.SuggestedMembersModel.PageInfoModel;
import com.facebook.groups.members.GroupMemberBaseListLoader;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: experience_command */
public class SuggestedMemberAlphabeticalListLoader extends GroupMemberBaseListLoader<GroupSuggestedMembersCollectionQueryModel> {
    private ImmutableList<User> f14604e = RegularImmutableList.a;
    private String f14605f;

    @Inject
    public SuggestedMemberAlphabeticalListLoader(TasksManager tasksManager, @Assisted String str, GraphQLQueryExecutor graphQLQueryExecutor, @Assisted MemberListLoaderListener memberListLoaderListener) {
        super(tasksManager, graphQLQueryExecutor, memberListLoaderListener);
        this.f14605f = str;
    }

    protected final TypedGraphQlQueryString<GroupSuggestedMembersCollectionQueryModel> m16488a(String str) {
        GroupSuggestedMembersCollectionQueryString a = GroupSuggestedMembersCollectionQuery.m16710a();
        a.a("group_id", this.f14605f);
        a.a("member_count_to_fetch", "12");
        a.a("afterCursor", this.a);
        a.a("suggested_member_friend_sort_param", "is_viewer_friend");
        a.a("suggested_member_order_param", "name");
        return a;
    }

    protected final void m16492j() {
        this.f14604e = RegularImmutableList.a;
    }

    protected final void m16489a(GraphQLResult<GroupSuggestedMembersCollectionQueryModel> graphQLResult) {
        PageInfoModel pageInfoModel;
        String str = null;
        Builder builder = new Builder();
        builder.b(this.f14604e);
        if (graphQLResult.e == null || ((GroupSuggestedMembersCollectionQueryModel) graphQLResult.e).m16755j() == null) {
            pageInfoModel = null;
        } else {
            SuggestedMembersModel j = ((GroupSuggestedMembersCollectionQueryModel) graphQLResult.e).m16755j();
            ImmutableList asList = j.m16746a().asList();
            int size = asList.size();
            for (int i = 0; i < size; i++) {
                builder.c(SuggestedMemberListLoader.m16493a(((EdgesModel) asList.get(i)).m16734a(), null));
            }
            pageInfoModel = j.m16747j();
        }
        this.f14604e = builder.b();
        if (pageInfoModel != null) {
            str = pageInfoModel.m16740a();
        }
        this.a = str;
        boolean z = pageInfoModel == null || !pageInfoModel.m16742j();
        this.b = z;
        g();
    }

    protected final ImmutableList<? extends Object> m16491i() {
        return this.f14604e;
    }

    protected final String m16490h() {
        return "Group alphabetical suggested member fetch failed";
    }
}

package com.facebook.groups.memberpicker;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberpicker.protocol.UserFriendsCollectionQuery.UserFriendsCollectionQueryString;
import com.facebook.groups.memberpicker.protocol.UserFriendsCollectionQueryModels.UserFriendsCollectionQueryModel;
import com.facebook.groups.memberpicker.protocol.UserFriendsCollectionQueryModels.UserFriendsCollectionQueryModel.FriendsModel;
import com.facebook.groups.memberpicker.protocol.UserFriendsCollectionQueryModels.UserFriendsCollectionQueryModel.FriendsModel.EdgesModel;
import com.facebook.groups.memberpicker.protocol.UserFriendsCollectionQueryModels.UserFriendsCollectionQueryModel.FriendsModel.PageInfoModel;
import com.facebook.groups.members.GroupMemberBaseListLoader;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: exited_search_via_back_button */
public class UserFriendsListLoader extends GroupMemberBaseListLoader<UserFriendsCollectionQueryModel> {
    private ImmutableList<User> f14624e = RegularImmutableList.a;
    private String f14625f;

    @Inject
    public UserFriendsListLoader(TasksManager tasksManager, @Assisted String str, GraphQLQueryExecutor graphQLQueryExecutor, @Assisted MemberListLoaderListener memberListLoaderListener) {
        super(tasksManager, graphQLQueryExecutor, memberListLoaderListener);
        this.f14625f = str;
    }

    protected final void m16513a(GraphQLResult<UserFriendsCollectionQueryModel> graphQLResult) {
        PageInfoModel pageInfoModel;
        String str = null;
        Builder builder = new Builder();
        builder.b(this.f14624e);
        if (graphQLResult.e == null || ((UserFriendsCollectionQueryModel) graphQLResult.e).m16894j() == null) {
            pageInfoModel = null;
        } else {
            FriendsModel j = ((UserFriendsCollectionQueryModel) graphQLResult.e).m16894j();
            ImmutableList asList = j.m16884a().asList();
            int size = asList.size();
            for (int i = 0; i < size; i++) {
                builder.c(SuggestedMemberListLoader.m16493a(((EdgesModel) asList.get(i)).m16872a(), null));
            }
            pageInfoModel = j.m16885j();
        }
        this.f14624e = builder.b();
        if (pageInfoModel != null) {
            str = pageInfoModel.m16878a();
        }
        this.a = str;
        boolean z = pageInfoModel == null || !pageInfoModel.m16880j();
        this.b = z;
        g();
    }

    protected final void m16516j() {
        this.f14624e = RegularImmutableList.a;
    }

    protected final TypedGraphQlQueryString<UserFriendsCollectionQueryModel> m16512a(String str) {
        GraphQlQueryString userFriendsCollectionQueryString = new UserFriendsCollectionQueryString();
        userFriendsCollectionQueryString.a("user_id", this.f14625f);
        userFriendsCollectionQueryString.a("member_count_to_fetch", Integer.valueOf(12));
        userFriendsCollectionQueryString.a("afterCursor", this.a);
        return userFriendsCollectionQueryString;
    }

    protected final ImmutableList<? extends Object> m16515i() {
        return this.f14624e;
    }

    protected final String m16514h() {
        return "User friends fetch failed";
    }
}

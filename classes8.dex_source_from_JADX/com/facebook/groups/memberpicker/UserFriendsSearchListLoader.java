package com.facebook.groups.memberpicker;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberpicker.protocol.UserFriendsSearchQuery;
import com.facebook.groups.memberpicker.protocol.UserFriendsSearchQuery.UserFriendsSearchQueryString;
import com.facebook.groups.memberpicker.protocol.UserFriendsSearchQueryModels.UserFriendsSearchQueryModel;
import com.facebook.groups.memberpicker.protocol.UserFriendsSearchQueryModels.UserFriendsSearchQueryModel.FriendsModel;
import com.facebook.groups.memberpicker.protocol.UserFriendsSearchQueryModels.UserFriendsSearchQueryModel.FriendsModel.EdgesModel;
import com.facebook.groups.memberpicker.protocol.UserFriendsSearchQueryModels.UserFriendsSearchQueryModel.FriendsModel.PageInfoModel;
import com.facebook.groups.members.GroupMemberBaseListLoader;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: existing_photo */
public class UserFriendsSearchListLoader extends GroupMemberBaseListLoader<UserFriendsSearchQueryModel> {
    private ImmutableList<User> f14626e = RegularImmutableList.a;
    private String f14627f;
    private String f14628g;

    @Inject
    public UserFriendsSearchListLoader(TasksManager tasksManager, @Assisted String str, @Assisted String str2, GraphQLQueryExecutor graphQLQueryExecutor, @Assisted MemberListLoaderListener memberListLoaderListener) {
        super(tasksManager, graphQLQueryExecutor, memberListLoaderListener);
        this.f14627f = str;
        this.f14628g = str2;
    }

    protected final TypedGraphQlQueryString<UserFriendsSearchQueryModel> m16517a(String str) {
        UserFriendsSearchQueryString a = UserFriendsSearchQuery.m16905a();
        a.a("user_id", this.f14627f);
        a.a("searchTerm", this.f14628g);
        a.a("afterCursor", this.a);
        a.a("member_count_to_fetch", Integer.valueOf(12));
        return a;
    }

    protected final void m16518a(GraphQLResult<UserFriendsSearchQueryModel> graphQLResult) {
        if (!(graphQLResult.e == null || ((UserFriendsSearchQueryModel) graphQLResult.e).m16950j() == null)) {
            String a;
            Builder builder = new Builder();
            builder.b(this.f14626e);
            FriendsModel j = ((UserFriendsSearchQueryModel) graphQLResult.e).m16950j();
            ImmutableList asList = j.m16940a().asList();
            int size = asList.size();
            for (int i = 0; i < size; i++) {
                builder.c(SuggestedMemberListLoader.m16493a(((EdgesModel) asList.get(i)).m16928a(), null));
            }
            PageInfoModel j2 = j.m16941j();
            this.f14626e = builder.b();
            if (j2 != null) {
                a = j2.m16934a();
            } else {
                a = null;
            }
            this.a = a;
            boolean z = j2 == null || !j2.m16936j();
            this.b = z;
        }
        g();
    }

    protected final void m16521j() {
        this.f14626e = RegularImmutableList.a;
    }

    protected final ImmutableList<? extends Object> m16520i() {
        return this.f14626e;
    }

    protected final String m16519h() {
        return "User friends search fetch failed";
    }
}

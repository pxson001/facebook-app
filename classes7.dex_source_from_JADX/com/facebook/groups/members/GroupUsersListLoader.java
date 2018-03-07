package com.facebook.groups.members;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.groups.members.protocol.FetchGroupMembers.FetchGroupFriendMemberString;
import com.facebook.groups.members.protocol.FetchGroupMembersModels.FetchGroupFriendMemberModel;
import com.facebook.groups.members.protocol.FetchGroupMembersModels.FetchGroupFriendMemberModel.GroupMembersModel.NodesModel;
import com.facebook.groups.members.protocol.FetchGroupMembersModels.FetchGroupFriendMemberModel.GroupMembersModel.PageInfoModel;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: promo_price */
public class GroupUsersListLoader extends GroupMemberBaseListLoader<FetchGroupFriendMemberModel> {
    private ImmutableList<User> f5781e = RegularImmutableList.a;
    private Integer f5782f;
    private String f5783g;
    public String f5784h;
    private String f5785i;

    @Inject
    public GroupUsersListLoader(TasksManager tasksManager, @Assisted String str, @Assisted String str2, @Assisted Integer num, GraphQLQueryExecutor graphQLQueryExecutor, @Assisted MemberListLoaderListener memberListLoaderListener, String str3, @Assisted Boolean bool) {
        super(tasksManager, graphQLQueryExecutor, memberListLoaderListener, bool);
        this.f5783g = str;
        this.f5785i = str3;
        this.f5782f = num;
        this.f5784h = str2;
    }

    protected final void mo308a(GraphQLResult<FetchGroupFriendMemberModel> graphQLResult) {
        PageInfoModel pageInfoModel;
        String str = null;
        Builder builder = new Builder();
        builder.b(this.f5781e);
        if (!(graphQLResult == null || graphQLResult.e == null || ((FetchGroupFriendMemberModel) graphQLResult.e).m7196a() == null || ((FetchGroupFriendMemberModel) graphQLResult.e).m7196a().m7191a() == null)) {
            ImmutableList a = ((FetchGroupFriendMemberModel) graphQLResult.e).m7196a().m7191a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) a.get(i);
                if (!(nodesModel.m7178j() == null || nodesModel.m7178j().equals(this.f5785i))) {
                    String a2;
                    UserBuilder a3 = new UserBuilder().a(Type.FACEBOOK, nodesModel.m7178j());
                    a3.h = nodesModel.m7179k();
                    a3 = a3;
                    if (nodesModel.m7180l() != null) {
                        a2 = nodesModel.m7180l().m7171a();
                    } else {
                        a2 = null;
                    }
                    a3.n = a2;
                    builder.c(a3.aa());
                }
            }
        }
        if (graphQLResult.e == null || ((FetchGroupFriendMemberModel) graphQLResult.e).m7196a() == null) {
            pageInfoModel = null;
        } else {
            pageInfoModel = ((FetchGroupFriendMemberModel) graphQLResult.e).m7196a().m7192j();
        }
        this.f5781e = builder.b();
        if (pageInfoModel != null) {
            str = pageInfoModel.m7185a();
        }
        this.a = str;
        boolean z = pageInfoModel == null || !pageInfoModel.m7187j();
        this.b = z;
        m7101g();
    }

    protected final void mo311j() {
        this.f5781e = RegularImmutableList.a;
    }

    protected final TypedGraphQlQueryString<FetchGroupFriendMemberModel> mo307a(String str) {
        GraphQlQueryString fetchGroupFriendMemberString = new FetchGroupFriendMemberString();
        fetchGroupFriendMemberString.a("after_cursor", str).a("group_id", this.f5783g).a("search_term", this.f5784h).a("profile_image_size", String.valueOf(this.f5782f)).a("member_count", "12");
        return fetchGroupFriendMemberString;
    }

    protected final String mo309h() {
        return "Group members for group chat fetch failed";
    }

    protected final ImmutableList<? extends Object> mo310i() {
        return this.f5781e;
    }
}

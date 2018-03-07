package com.facebook.groups.memberpicker;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataInterfaces.FBTaggableUserFragment;
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
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: expands_on_click */
public final class SuggestedMemberListLoader extends GroupMemberBaseListLoader<GroupSuggestedMembersCollectionQueryModel> {
    private ImmutableList<User> f14606e = RegularImmutableList.a;
    private String f14607f;
    private int f14608g;

    @Inject
    public SuggestedMemberListLoader(TasksManager tasksManager, @Assisted String str, @Assisted Integer num, GraphQLQueryExecutor graphQLQueryExecutor, @Assisted MemberListLoaderListener memberListLoaderListener) {
        super(tasksManager, graphQLQueryExecutor, memberListLoaderListener);
        this.f14607f = str;
        this.f14608g = num.intValue();
    }

    protected final TypedGraphQlQueryString<GroupSuggestedMembersCollectionQueryModel> m16494a(String str) {
        GroupSuggestedMembersCollectionQueryString a = GroupSuggestedMembersCollectionQuery.m16710a();
        a.a("group_id", this.f14607f);
        a.a("member_count_to_fetch", String.valueOf(this.f14608g));
        a.a("afterCursor", this.a);
        a.a("suggested_member_order_param", "importance");
        a.a("suggested_member_friend_sort_param", "is_viewer_friend");
        return a;
    }

    protected final void m16498j() {
        this.f14606e = RegularImmutableList.a;
    }

    protected final void m16495a(GraphQLResult<GroupSuggestedMembersCollectionQueryModel> graphQLResult) {
        PageInfoModel pageInfoModel;
        String str = null;
        Builder builder = new Builder();
        builder.b(this.f14606e);
        if (graphQLResult.e == null || ((GroupSuggestedMembersCollectionQueryModel) graphQLResult.e).m16755j() == null) {
            pageInfoModel = null;
        } else {
            SuggestedMembersModel j = ((GroupSuggestedMembersCollectionQueryModel) graphQLResult.e).m16755j();
            ImmutableList asList = j.m16746a().asList();
            int size = asList.size();
            for (int i = 0; i < size; i++) {
                builder.c(m16493a(((EdgesModel) asList.get(i)).m16734a(), null));
            }
            pageInfoModel = j.m16747j();
        }
        this.f14606e = builder.b();
        if (pageInfoModel != null) {
            str = pageInfoModel.m16740a();
        }
        this.a = str;
        boolean z = pageInfoModel == null || !pageInfoModel.m16742j();
        this.b = z;
        g();
    }

    protected final ImmutableList<? extends Object> m16497i() {
        return this.f14606e;
    }

    protected final String m16496h() {
        return "Group suggested member fetch failed";
    }

    public static User m16493a(FBTaggableUserFragment fBTaggableUserFragment, String str) {
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.a(Type.FACEBOOK_CONTACT, fBTaggableUserFragment.mo891j());
        userBuilder.n = fBTaggableUserFragment.mo894m().m16693a();
        ImmutableList l = fBTaggableUserFragment.mo893l();
        String str2 = "";
        String str3 = "";
        if (!l.isEmpty()) {
            str2 = (String) l.get(0);
            if (l.size() > 1) {
                str3 = (String) l.get(1);
            }
        }
        userBuilder.g = new Name(str2, str3, fBTaggableUserFragment.mo892k());
        if (!Strings.isNullOrEmpty(str)) {
            userBuilder.x = str;
        }
        return userBuilder.aa();
    }
}

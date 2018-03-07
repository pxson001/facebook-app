package com.facebook.groups.members;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: promo_name */
public class GroupUsersListLoaderProvider extends AbstractAssistedProvider<GroupUsersListLoader> {
    public final GroupUsersListLoader m7110a(String str, String str2, Integer num, MemberListLoaderListener memberListLoaderListener, Boolean bool) {
        return new GroupUsersListLoader(TasksManager.b(this), str, str2, num, GraphQLQueryExecutor.a(this), memberListLoaderListener, String_LoggedInUserIdMethodAutoProvider.b(this), bool);
    }
}

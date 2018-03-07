package com.facebook.groups.memberlist;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: extra_place_list */
public class GroupMembersPagedListLoaderProvider extends AbstractAssistedProvider<GroupMembersPagedListLoader> {
    public final GroupMembersPagedListLoader m15915a(String str, String str2, Boolean bool, Boolean bool2, Integer num, MemberListLoaderListener memberListLoaderListener) {
        return new GroupMembersPagedListLoader(TasksManager.b(this), str, str2, bool, bool2, num, GraphQLQueryExecutor.a(this), memberListLoaderListener, String_LoggedInUserIdMethodAutoProvider.b(this));
    }
}

package com.facebook.groups.memberlist;

import android.content.Context;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.groups.memberlist.GroupMemberListSeeMoreView.MemberListSeeMoreListener;
import com.facebook.groups.memberlist.memberrow.GroupMemberRow.GroupsMemberRowListener;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: extra_source */
public class GroupMemberItemRendererProvider extends AbstractAssistedProvider<GroupMemberItemRenderer> {
    public final GroupMemberItemRenderer m15822a(GroupsMemberRowListener groupsMemberRowListener, GroupMemberListInfoManager groupMemberListInfoManager, MemberListSeeMoreListener memberListSeeMoreListener) {
        return new GroupMemberItemRenderer(groupsMemberRowListener, groupMemberListInfoManager, memberListSeeMoreListener, String_LoggedInUserIdMethodAutoProvider.b(this), (Context) getInstance(Context.class));
    }
}

package com.facebook.groups.memberlist;

import com.facebook.groups.memberlist.GroupMemberListItem.GroupMemberItemViewType;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.MemberSection;

/* compiled from: extra_selected_city */
public class GroupMemberListSeeMoreItem implements GroupMemberListItem {
    public final MemberSection f14276a;

    public GroupMemberListSeeMoreItem(MemberSection memberSection) {
        this.f14276a = memberSection;
    }

    public final GroupMemberItemViewType mo872a() {
        return GroupMemberItemViewType.SeeMoreBar;
    }
}

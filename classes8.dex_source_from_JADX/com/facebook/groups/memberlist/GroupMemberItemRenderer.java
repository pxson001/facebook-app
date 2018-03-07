package com.facebook.groups.memberlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.groups.memberlist.GroupMemberListItem.GroupMemberItemViewType;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.AdminState;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.MemberSection;
import com.facebook.groups.memberlist.GroupMemberListSeeMoreView.C15461;
import com.facebook.groups.memberlist.GroupMemberListSeeMoreView.MemberListSeeMoreListener;
import com.facebook.groups.memberlist.memberrow.GroupMemberRow;
import com.facebook.groups.memberlist.memberrow.GroupMemberRow.GroupsMemberRowListener;
import com.facebook.inject.Assisted;
import com.facebook.widget.compositeadapter.stickyheader.StickyHeaderCompositeAdapter.StickyHeaderRenderer;
import javax.inject.Inject;

/* compiled from: extra_sport_query_live_page_title */
public class GroupMemberItemRenderer implements StickyHeaderRenderer {
    private final int f14226a;
    private final int f14227b;
    private GroupsMemberRowListener f14228c;
    public GroupMemberListInfoManager f14229d;
    private MemberListSeeMoreListener f14230e;
    private String f14231f;

    @Inject
    public GroupMemberItemRenderer(@Assisted GroupsMemberRowListener groupsMemberRowListener, @Assisted GroupMemberListInfoManager groupMemberListInfoManager, @Assisted MemberListSeeMoreListener memberListSeeMoreListener, String str, Context context) {
        this.f14228c = groupsMemberRowListener;
        this.f14229d = groupMemberListInfoManager;
        this.f14230e = memberListSeeMoreListener;
        this.f14226a = context.getResources().getDimensionPixelSize(2131432955);
        this.f14227b = context.getResources().getColor(2131363689);
        this.f14231f = str;
    }

    public final View mo864a(int i, ViewGroup viewGroup) {
        switch (GroupMemberItemViewType.fromOrdinal(i)) {
            case GroupMemberRow:
                return new GroupMemberRow(viewGroup.getContext(), this.f14228c);
            case Header:
                return new GroupMemberStickyHeaderView(viewGroup.getContext());
            case LoadingBar:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130904678, viewGroup, false);
            case SeeMoreBar:
                return new GroupMemberListSeeMoreView(viewGroup.getContext());
            default:
                throw new IllegalArgumentException("Unknown view type: " + i);
        }
    }

    public final void mo865a(Object obj, View view, int i, ViewGroup viewGroup) {
        switch (GroupMemberItemViewType.fromOrdinal(i)) {
            case GroupMemberRow:
                m15817a((GroupMemberRow) view, (GroupMemberListMemberItem) obj);
                return;
            case Header:
                ((GroupMemberStickyHeaderView) view).m15905a(viewGroup.getContext().getString(((GroupMemberListHeaderItem) obj).f14259a));
                return;
            case LoadingBar:
                int i2;
                if (this.f14229d.f14266d) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                view.setVisibility(i2);
                return;
            case SeeMoreBar:
                GroupMemberListSeeMoreView groupMemberListSeeMoreView = (GroupMemberListSeeMoreView) view;
                MemberSection memberSection = ((GroupMemberListSeeMoreItem) obj).f14276a;
                MemberListSeeMoreListener memberListSeeMoreListener = this.f14230e;
                groupMemberListSeeMoreView.setVisibility(1 != 0 ? 0 : 8);
                groupMemberListSeeMoreView.f14281a.setVisibility(0);
                groupMemberListSeeMoreView.setOnClickListener(new C15461(groupMemberListSeeMoreView, memberListSeeMoreListener, memberSection));
                return;
            default:
                throw new IllegalArgumentException("Unknown view type: " + i);
        }
    }

    public final int mo863a() {
        return this.f14226a;
    }

    public final int mo866b() {
        return this.f14227b;
    }

    private void m15817a(GroupMemberRow groupMemberRow, GroupMemberListMemberItem groupMemberListMemberItem) {
        String b = groupMemberListMemberItem.f14272d.b();
        AdminState adminState = AdminState.NOT_ADMIN;
        if (this.f14229d.m15880c(b)) {
            adminState = AdminState.ADMIN;
        } else if (this.f14229d.f14264b.contains(b)) {
            adminState = AdminState.MODERATOR;
        }
        groupMemberRow.m15983a(groupMemberListMemberItem, this.f14229d.f14267e, adminState, this.f14229d.f14268f, this.f14229d.m15879b(b), this.f14229d.m15880c(this.f14231f));
    }
}

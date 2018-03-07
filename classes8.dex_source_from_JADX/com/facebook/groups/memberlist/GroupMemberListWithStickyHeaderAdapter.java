package com.facebook.groups.memberlist;

import android.content.Context;
import android.view.View;
import com.facebook.groups.memberlist.memberrow.GroupMemberRow;
import com.facebook.inject.Assisted;
import com.facebook.widget.compositeadapter.CompositeAdapter.Controller;
import com.facebook.widget.compositeadapter.CompositeAdapter.Model;
import com.facebook.widget.compositeadapter.stickyheader.StickyHeaderCompositeAdapter;
import com.facebook.widget.compositeadapter.stickyheader.StickyHeaderCompositeAdapter.StickyHeaderRenderer;
import com.facebook.widget.itemslist.StickyHeaderSectionIndexer;
import com.facebook.widget.listview.BetterListView;
import javax.inject.Inject;

/* compiled from: extra_reaction_analytics_params */
public class GroupMemberListWithStickyHeaderAdapter extends StickyHeaderCompositeAdapter implements GroupMemberListAdapterHelper {
    private GroupMemberListInfoManager f14291a;

    @Inject
    public GroupMemberListWithStickyHeaderAdapter(@Assisted Model model, @Assisted StickyHeaderSectionIndexer stickyHeaderSectionIndexer, @Assisted StickyHeaderRenderer stickyHeaderRenderer, @Assisted GroupMemberListInfoManager groupMemberListInfoManager, @Assisted Controller controller, Context context) {
        super(context, model, stickyHeaderSectionIndexer, stickyHeaderRenderer, controller);
        this.f14291a = groupMemberListInfoManager;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public boolean isEnabled(int i) {
        if (getItem(i) instanceof GroupMemberListMemberItem) {
            return true;
        }
        return false;
    }

    public final GroupMemberListInfoManager mo867a() {
        return this.f14291a;
    }

    public final void mo869b() {
        this.f14291a.m15876a();
    }

    public final void mo868a(String str, BetterListView betterListView) {
        int i;
        for (i = 0; i < getCount(); i++) {
            Object item = getItem(i);
            if ((item instanceof GroupMemberListMemberItem) && ((GroupMemberListMemberItem) item).f14272d.b().equals(str)) {
                this.f14291a.m15877a(str);
                break;
            }
        }
        int i2 = 0;
        i = 0;
        GroupMemberStickyHeaderView groupMemberStickyHeaderView = null;
        while (i2 <= betterListView.getChildCount()) {
            int i3;
            View childAt = betterListView.getChildAt(i2);
            if (childAt != null && (childAt instanceof GroupMemberStickyHeaderView)) {
                if (i == 0 && groupMemberStickyHeaderView != null) {
                    groupMemberStickyHeaderView.m15904a();
                }
                groupMemberStickyHeaderView = (GroupMemberStickyHeaderView) childAt;
                i = 0;
            }
            if (childAt == null || !(childAt instanceof GroupMemberRow)) {
                i3 = i;
            } else {
                GroupMemberRow groupMemberRow = (GroupMemberRow) childAt;
                if (groupMemberRow.f14456j.equals(str)) {
                    groupMemberRow.m15982a();
                    i3 = i;
                } else {
                    i3 = i + 1;
                }
            }
            i2++;
            i = i3;
        }
        if (i == 0 && groupMemberStickyHeaderView != null) {
            groupMemberStickyHeaderView.m15904a();
        }
    }

    public final boolean mo870c() {
        return getCount() != 0 && this.f14291a.m15878b() == getCount() - getSections().length;
    }
}

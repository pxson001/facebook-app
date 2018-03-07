package com.facebook.groups.memberlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.groups.memberlist.memberrow.GroupMemberRow;
import com.facebook.groups.memberlist.memberrow.GroupMemberRow.GroupsMemberRowListener;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: extra_slideshow_data */
public class GroupMemberListAdapter extends FbBaseAdapter implements GroupMemberListAdapterHelper {
    private final GroupsMemberRowListener f14233a;
    private ImmutableList<GroupMemberListMemberItem> f14234b = RegularImmutableList.a;
    public GroupMemberListInfoManager f14235c;
    public String f14236d;

    /* compiled from: extra_slideshow_data */
    enum ItemTypes {
        MEMBER_ROW,
        LOADING_BAR
    }

    public /* synthetic */ Object getItem(int i) {
        return m15830a(i);
    }

    @Inject
    public GroupMemberListAdapter(@Assisted GroupsMemberRowListener groupsMemberRowListener, @Assisted GroupMemberListInfoManager groupMemberListInfoManager, String str) {
        this.f14233a = groupsMemberRowListener;
        this.f14235c = groupMemberListInfoManager;
        this.f14236d = str;
    }

    public final GroupMemberListInfoManager mo867a() {
        return this.f14235c;
    }

    public final void m15832a(ImmutableList<GroupMemberListMemberItem> immutableList) {
        if (immutableList != null) {
            this.f14234b = immutableList;
            AdapterDetour.a(this, 1261470610);
        }
    }

    public final void mo869b() {
        m15832a(RegularImmutableList.a);
        this.f14235c.m15876a();
    }

    public final void m15835b(ImmutableList<GroupMemberListMemberItem> immutableList) {
        if (immutableList != null) {
            this.f14234b = immutableList;
        }
    }

    public final boolean mo870c() {
        return !this.f14234b.isEmpty() && this.f14235c.m15878b() == this.f14234b.size();
    }

    public final void mo868a(String str, BetterListView betterListView) {
        int i = 0;
        int size = this.f14234b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((GroupMemberListMemberItem) this.f14234b.get(i2)).f14272d.b().equals(str)) {
                this.f14235c.m15877a(str);
                break;
            }
        }
        while (i <= betterListView.getChildCount()) {
            View childAt = betterListView.getChildAt(i);
            if (childAt != null && (childAt instanceof GroupMemberRow)) {
                GroupMemberRow groupMemberRow = (GroupMemberRow) childAt;
                if (groupMemberRow.f14456j.equals(str)) {
                    groupMemberRow.m15982a();
                    return;
                }
            }
            i++;
        }
    }

    public final View m15828a(int i, ViewGroup viewGroup) {
        switch (ItemTypes.values()[i]) {
            case LOADING_BAR:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130904678, viewGroup, false);
            case MEMBER_ROW:
                return new GroupMemberRow(viewGroup.getContext(), this.f14233a);
            default:
                return new View(viewGroup.getContext());
        }
    }

    public final void m15831a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        switch (ItemTypes.values()[i2]) {
            case LOADING_BAR:
                view.setVisibility(m15827d() ? 0 : 8);
                return;
            case MEMBER_ROW:
                GroupMemberListMemberItem groupMemberListMemberItem = (GroupMemberListMemberItem) obj;
                ((GroupMemberRow) view).m15983a(groupMemberListMemberItem, this.f14235c.f14267e, groupMemberListMemberItem.f14269a, this.f14235c.f14268f, this.f14235c.m15879b(groupMemberListMemberItem.f14272d.b()), this.f14235c.m15880c(this.f14236d));
                return;
            default:
                return;
        }
    }

    public int getCount() {
        return (this.f14234b.size() + ItemTypes.values().length) - 1;
    }

    public final GroupMemberListMemberItem m15830a(int i) {
        if (i < this.f14234b.size()) {
            return (GroupMemberListMemberItem) this.f14234b.get(i);
        }
        return null;
    }

    public int getItemViewType(int i) {
        if (i < this.f14234b.size()) {
            return ItemTypes.MEMBER_ROW.ordinal();
        }
        return ItemTypes.LOADING_BAR.ordinal();
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return ItemTypes.values().length;
    }

    private boolean m15827d() {
        return this.f14235c.f14266d;
    }
}

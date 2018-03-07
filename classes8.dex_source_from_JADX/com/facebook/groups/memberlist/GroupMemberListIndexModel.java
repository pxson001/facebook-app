package com.facebook.groups.memberlist;

import com.facebook.groups.memberlist.GroupMemberListItem.GroupMemberItemViewType;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.MemberSection;
import com.facebook.widget.compositeadapter.CompositeAdapter.Model;
import com.facebook.widget.itemslist.ImmutableItemsList;
import com.facebook.widget.itemslist.ImmutableItemsListIndex;
import com.facebook.widget.itemslist.StickyHeaderSectionIndexer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: extra_should_merge_camera_roll */
public class GroupMemberListIndexModel implements Model, StickyHeaderSectionIndexer {
    protected ImmutableItemsListIndex f14260a = ImmutableItemsListIndex.a;
    private final Map<MemberSection, Builder<Object>> f14261b = new HashMap();
    private final Map<MemberSection, ArrayList> f14262c = new HashMap();

    public GroupMemberListIndexModel() {
        m15868d();
    }

    public final void m15871a(ImmutableList<GroupMemberListMemberItem> immutableList, ImmutableMap<Enum, Boolean> immutableMap) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GroupMemberListMemberItem groupMemberListMemberItem = (GroupMemberListMemberItem) immutableList.get(i);
            if (groupMemberListMemberItem.mo872a() == GroupMemberItemViewType.GroupMemberRow) {
                MemberSection memberSection = groupMemberListMemberItem.f14271c;
                if (!this.f14261b.containsKey(memberSection)) {
                    this.f14261b.put(memberSection, ImmutableList.builder());
                    Builder builder = (Builder) this.f14261b.get(memberSection);
                    int i2 = 2131239508;
                    if (memberSection == MemberSection.FRIEND) {
                        i2 = 2131239510;
                    } else if (memberSection == MemberSection.INVITES) {
                        i2 = 2131239509;
                    } else if (memberSection == MemberSection.ADMIN) {
                        i2 = 2131239511;
                    } else if (memberSection == MemberSection.MODERATOR) {
                        i2 = 2131239512;
                    }
                    builder.c(new GroupMemberListHeaderItem(i2));
                    this.f14262c.put(memberSection, Lists.a());
                }
                if (!((ArrayList) this.f14262c.get(memberSection)).contains(groupMemberListMemberItem.f14272d.b())) {
                    ((Builder) this.f14261b.get(memberSection)).c(groupMemberListMemberItem);
                    ((ArrayList) this.f14262c.get(memberSection)).add(groupMemberListMemberItem.f14272d.b());
                }
            }
        }
        Builder builder2 = ImmutableList.builder();
        for (MemberSection memberSection2 : MemberSection.values()) {
            if (this.f14261b.containsKey(memberSection2)) {
                ImmutableList b = ((Builder) this.f14261b.get(memberSection2)).b();
                if (b.size() > 1) {
                    builder2.c(new ImmutableItemsList(b, true));
                    if (!(immutableMap == null || ((Boolean) immutableMap.get(memberSection2)).booleanValue())) {
                        m15867a(builder2, memberSection2);
                    }
                }
            }
        }
        m15866a(builder2);
        this.f14260a = new ImmutableItemsListIndex(builder2.b());
    }

    private static void m15867a(Builder<ImmutableItemsList> builder, MemberSection memberSection) {
        builder.c(new ImmutableItemsList(ImmutableList.of(new GroupMemberListSeeMoreItem(memberSection)), false));
    }

    private static void m15866a(Builder<ImmutableItemsList> builder) {
        builder.c(new ImmutableItemsList(ImmutableList.of(new GroupMemberLoadingBarItem()), false));
    }

    private void m15868d() {
        Builder builder = ImmutableList.builder();
        m15866a(builder);
        this.f14260a = new ImmutableItemsListIndex(builder.b());
    }

    public final void m15874c() {
        m15868d();
        this.f14261b.clear();
    }

    public final int mo873a() {
        return this.f14260a.d;
    }

    public final Object mo874a(int i) {
        return this.f14260a.a(i);
    }

    public final int mo876b(int i) {
        return ((GroupMemberListItem) mo874a(i)).mo872a().ordinal();
    }

    public final int mo875b() {
        return GroupMemberItemViewType.values().length;
    }

    public final boolean z_(int i) {
        return this.f14260a.z_(i);
    }

    public final boolean mo877c(int i) {
        return this.f14260a.c(i);
    }

    public Object[] getSections() {
        return this.f14260a.getSections();
    }

    public int getPositionForSection(int i) {
        return this.f14260a.getPositionForSection(i);
    }

    public int getSectionForPosition(int i) {
        return this.f14260a.getSectionForPosition(i);
    }
}

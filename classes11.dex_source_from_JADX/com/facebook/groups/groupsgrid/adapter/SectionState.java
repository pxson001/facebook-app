package com.facebook.groups.groupsgrid.adapter;

import com.facebook.groups.groupsections.Enums.GroupSections;
import com.facebook.groups.groupsections.GroupsSectionInterface;
import com.facebook.groups.groupsections.noncursored.AbstractGraphQLBackedSection;
import java.util.HashMap;
import javax.annotation.Nullable;

/* compiled from: X-Cache-Remote */
public class SectionState {
    int f10339a;
    int f10340b;
    int f10341c;
    int f10342d;
    int f10343e;
    int f10344f;
    int f10345g;
    private final HashMap<GroupSections, Integer> f10346h = new HashMap();
    private final GroupsRecyclerViewSectionedGridAdapter f10347i;

    SectionState(GroupsRecyclerViewSectionedGridAdapter groupsRecyclerViewSectionedGridAdapter) {
        this.f10347i = groupsRecyclerViewSectionedGridAdapter;
        m10758a();
    }

    static boolean m10760a(HashMap<GroupSections, GroupsSectionInterface> hashMap) {
        return Helper.m10757a((AbstractGraphQLBackedSection) hashMap.get(GroupSections.FAVORITES_SECTION)) || ((AbstractGraphQLBackedSection) hashMap.get(GroupSections.FILTERED_GROUPS_SECTION)).m10609b() + ((AbstractGraphQLBackedSection) hashMap.get(GroupSections.RECENTLY_JOINED_SECTION)).m10609b() >= 9;
    }

    static boolean m10761b(HashMap<GroupSections, GroupsSectionInterface> hashMap) {
        AbstractGraphQLBackedSection abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) hashMap.get(GroupSections.HIDDEN_GROUPS_SECTION);
        return abstractGraphQLBackedSection != null && abstractGraphQLBackedSection.f10219c;
    }

    private static boolean m10759a(AbstractGraphQLBackedSection abstractGraphQLBackedSection) {
        return abstractGraphQLBackedSection.m10614f() && abstractGraphQLBackedSection.m10613e();
    }

    @Nullable
    public final GroupSections m10763a(int i) {
        if (this.f10346h == null || this.f10346h.isEmpty()) {
            return null;
        }
        for (GroupSections groupSections : GroupSections.values()) {
            if (this.f10346h.get(groupSections) != null && ((Integer) this.f10346h.get(groupSections)).intValue() == i) {
                return groupSections;
            }
        }
        return null;
    }

    public final int m10762a(Enum enumR) {
        if (this.f10346h == null || this.f10346h.get(enumR) == null) {
            return -1;
        }
        return ((Integer) this.f10346h.get(enumR)).intValue();
    }

    public final void m10764c(HashMap<GroupSections, GroupsSectionInterface> hashMap) {
        m10758a();
        AbstractGraphQLBackedSection abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) hashMap.get(GroupSections.FILTERED_GROUPS_SECTION);
        AbstractGraphQLBackedSection abstractGraphQLBackedSection2 = (AbstractGraphQLBackedSection) hashMap.get(GroupSections.RECENTLY_JOINED_SECTION);
        AbstractGraphQLBackedSection abstractGraphQLBackedSection3 = (AbstractGraphQLBackedSection) hashMap.get(GroupSections.FAVORITES_SECTION);
        AbstractGraphQLBackedSection abstractGraphQLBackedSection4 = (AbstractGraphQLBackedSection) hashMap.get(GroupSections.HIDDEN_GROUPS_SECTION);
        if (m10759a(abstractGraphQLBackedSection) && m10759a(abstractGraphQLBackedSection3) && m10759a(abstractGraphQLBackedSection2) && m10759a(abstractGraphQLBackedSection4)) {
            this.f10345g = 0;
            return;
        }
        int i;
        int a;
        int i2;
        if (m10760a((HashMap) hashMap)) {
            this.f10339a = 0;
            if (m10759a(abstractGraphQLBackedSection3)) {
                this.f10340b = this.f10339a + 1;
                i = this.f10340b + 1;
            } else {
                int a2 = (this.f10339a + 1) + abstractGraphQLBackedSection3.m10603a();
                i = a2 + 1;
                this.f10346h.put(GroupSections.FAVORITES_SECTION, Integer.valueOf(a2));
            }
        } else {
            i = 0;
        }
        if (!m10759a(abstractGraphQLBackedSection2)) {
            this.f10343e = i;
            a = abstractGraphQLBackedSection2.m10603a() + (this.f10343e + 1);
            i = a + 1;
            this.f10346h.put(GroupSections.RECENTLY_JOINED_SECTION, Integer.valueOf(a));
        }
        this.f10341c = i;
        a = this.f10341c + 1;
        if (m10759a(abstractGraphQLBackedSection)) {
            this.f10342d = a;
            i2 = this.f10342d + 1;
        } else {
            a += abstractGraphQLBackedSection.m10603a();
            i2 = a + 1;
            this.f10346h.put(GroupSections.FILTERED_GROUPS_SECTION, Integer.valueOf(a));
        }
        if (!m10759a(abstractGraphQLBackedSection4)) {
            this.f10344f = i2;
            this.f10346h.put(GroupSections.HIDDEN_GROUPS_SECTION, Integer.valueOf((this.f10344f + 1) + abstractGraphQLBackedSection4.m10603a()));
        }
        this.f10347i.notifyDataSetChanged();
    }

    private void m10758a() {
        this.f10339a = -1;
        this.f10340b = -1;
        this.f10341c = -1;
        this.f10342d = -1;
        this.f10343e = -1;
        this.f10344f = -1;
        this.f10345g = -1;
        this.f10346h.clear();
    }
}

package com.facebook.groups.groupsections;

import com.facebook.groups.groupsections.Enums.FilteredGroupsSectionOrdering;
import com.facebook.groups.groupsections.Enums.GroupSections;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;

/* compiled from: activity_feeds */
public interface SectionedGroupsQueryManager {

    /* compiled from: activity_feeds */
    public interface SectionRequeryListener {
        void mo257a();

        void mo258a(HashMap<GroupSections, GroupsSectionInterface> hashMap, boolean z, int i);
    }

    /* compiled from: activity_feeds */
    public interface SectionTailLoadListener {
        void mo259a(GroupSections groupSections, boolean z);
    }

    void mo276a();

    void mo277a(int i, int i2);

    void mo278a(int i, SectionTailLoadListener sectionTailLoadListener);

    void mo279a(FilteredGroupsSectionOrdering filteredGroupsSectionOrdering);

    void mo280a(FilteredGroupsSectionOrdering filteredGroupsSectionOrdering, int i, SectionRequeryListener sectionRequeryListener);

    void mo281a(GroupSections groupSections, boolean z);

    void mo282a(ImmutableList<GroupSections> immutableList);

    void mo283a(String str, boolean z, boolean z2);
}

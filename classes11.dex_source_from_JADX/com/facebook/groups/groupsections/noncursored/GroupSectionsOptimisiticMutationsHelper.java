package com.facebook.groups.groupsections.noncursored;

import com.facebook.debug.log.BLog;
import com.facebook.groups.groupsections.Enums.GroupSections;
import com.facebook.groups.groupsections.GroupsSectionInterface;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import javax.annotation.Nullable;

/* compiled from: \( */
public class GroupSectionsOptimisiticMutationsHelper {
    private static final String f10235a = GroupSectionsOptimisiticMutationsHelper.class.getName();

    public static HashMap<GroupSections, GroupsSectionInterface> m10618a(HashMap<GroupSections, GroupsSectionInterface> hashMap, String str, boolean z, boolean z2) {
        GroupPogGridData b = m10619b(hashMap, str);
        if (b != null) {
            GroupSections a = m10617a(b);
            GroupPogGridData groupPogGridData = new GroupPogGridData(b);
            groupPogGridData.f10229g = z;
            groupPogGridData.f10230h = z2;
            GroupSections a2 = m10617a(groupPogGridData);
            if (a != a2) {
                AbstractGraphQLBackedSection abstractGraphQLBackedSection;
                if (a != null) {
                    abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) hashMap.get(a);
                    if (abstractGraphQLBackedSection != null && (abstractGraphQLBackedSection instanceof AbstractGraphQLBackedSection)) {
                        abstractGraphQLBackedSection.m10606a(b);
                    }
                }
                if (a2 != null) {
                    abstractGraphQLBackedSection = (AbstractGraphQLBackedSection) hashMap.get(a2);
                    if (abstractGraphQLBackedSection != null && (abstractGraphQLBackedSection instanceof AbstractGraphQLBackedSection)) {
                        abstractGraphQLBackedSection = abstractGraphQLBackedSection;
                        if (groupPogGridData == null || abstractGraphQLBackedSection.f10218b == null || abstractGraphQLBackedSection.f10222f == null || !abstractGraphQLBackedSection.f10222f.containsKey(groupPogGridData.f10223a)) {
                            abstractGraphQLBackedSection.m10607a(ImmutableList.of(groupPogGridData), abstractGraphQLBackedSection.f10217a);
                        }
                    }
                }
            } else {
                BLog.a(f10235a, "Favorite/Hidden status changed, but group section did not change.");
            }
        }
        return hashMap;
    }

    @Nullable
    public static GroupSections m10617a(GroupPogGridData groupPogGridData) {
        if (!groupPogGridData.f10232j) {
            return null;
        }
        if (groupPogGridData.f10229g) {
            return GroupSections.FAVORITES_SECTION;
        }
        if (groupPogGridData.f10231i) {
            return GroupSections.RECENTLY_JOINED_SECTION;
        }
        if (groupPogGridData.f10230h) {
            return GroupSections.HIDDEN_GROUPS_SECTION;
        }
        return GroupSections.FILTERED_GROUPS_SECTION;
    }

    @Nullable
    public static GroupPogGridData m10619b(HashMap<GroupSections, GroupsSectionInterface> hashMap, String str) {
        for (AbstractGraphQLBackedSection abstractGraphQLBackedSection : hashMap.values()) {
            AbstractGraphQLBackedSection abstractGraphQLBackedSection2;
            if (abstractGraphQLBackedSection2 instanceof AbstractGraphQLBackedSection) {
                GroupPogGridData groupPogGridData;
                abstractGraphQLBackedSection2 = abstractGraphQLBackedSection2;
                if (abstractGraphQLBackedSection2.f10218b == null || abstractGraphQLBackedSection2.f10222f == null || !abstractGraphQLBackedSection2.f10222f.containsKey(str)) {
                    groupPogGridData = null;
                } else {
                    groupPogGridData = (GroupPogGridData) abstractGraphQLBackedSection2.f10218b.get(((Integer) abstractGraphQLBackedSection2.f10222f.get(str)).intValue());
                }
                GroupPogGridData groupPogGridData2 = groupPogGridData;
                if (groupPogGridData2 != null) {
                    return groupPogGridData2;
                }
            }
        }
        return null;
    }
}

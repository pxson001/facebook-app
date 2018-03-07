package com.facebook.groups.groupsgrid.adapter;

import com.facebook.groups.groupsections.Enums.FilteredGroupsSectionOrdering;
import com.facebook.groups.groupsections.noncursored.AbstractGraphQLBackedSection;

/* compiled from: X-Edge-Hit */
public class Helper {
    static int m10755a(FilteredGroupsSectionOrdering filteredGroupsSectionOrdering) {
        switch (filteredGroupsSectionOrdering) {
            case ALPHABETICAL:
                return 2130837633;
            case LATEST_ACTIVITY:
                return 2130841022;
            case RECENTLY_VISITED:
                return 2130842961;
            default:
                return 0;
        }
    }

    static int m10756a(FilteredGroupsSectionOrdering filteredGroupsSectionOrdering, boolean z) {
        switch (filteredGroupsSectionOrdering) {
            case ALPHABETICAL:
                return z ? 2131242536 : 2131242537;
            case LATEST_ACTIVITY:
                return z ? 2131242532 : 2131242533;
            case RECENTLY_VISITED:
                return z ? 2131242534 : 2131242535;
            default:
                return 0;
        }
    }

    static boolean m10757a(AbstractGraphQLBackedSection abstractGraphQLBackedSection) {
        return (abstractGraphQLBackedSection == null || !abstractGraphQLBackedSection.m10614f() || abstractGraphQLBackedSection.m10613e()) ? false : true;
    }
}

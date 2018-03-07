package com.facebook.saved.data;

import com.facebook.saved.adapter.SavedDashboardListItemType;

/* compiled from: isDialogLoadingUI */
public class SavedDashboardListSectionHeader implements SavedDashboardListItem {
    public final String f9120a;

    public SavedDashboardListSectionHeader(String str) {
        this.f9120a = str;
    }

    public final SavedDashboardListItemType mo423a() {
        return SavedDashboardListItemType.SAVED_DASHBOARD_LIST_SECTION_HEADER;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SavedDashboardListSectionHeader)) {
            return false;
        }
        return this.f9120a.equals(((SavedDashboardListSectionHeader) obj).f9120a);
    }

    public int hashCode() {
        return this.f9120a.hashCode();
    }
}

package com.facebook.saved.adapter;

/* compiled from: items_drawn */
public enum SavedDashboardListItemType {
    SAVED_DASHBOARD_LIST_SECTION_HEADER,
    SAVED_DASHBOARD_SAVED_ITEM,
    SAVED_DASHBOARD_LOAD_MORE,
    SAVED_DASHBOARD_LOAD_MORE_FAILED;

    public static SavedDashboardListItemType fromOrdinal(int i) {
        if (i >= 0 && i < values().length) {
            return values()[i];
        }
        throw new IllegalArgumentException("Ordinal does not match any SavedDashboardListItemType");
    }
}

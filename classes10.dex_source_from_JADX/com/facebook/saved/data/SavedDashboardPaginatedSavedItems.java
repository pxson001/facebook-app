package com.facebook.saved.data;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

/* compiled from: isComingFromInitMediaOperation */
public class SavedDashboardPaginatedSavedItems {
    public final Optional<ImmutableList<SavedDashboardListItem>> f9121a;
    public final boolean f9122b;
    public final Long f9123c;

    public SavedDashboardPaginatedSavedItems(Optional<ImmutableList<SavedDashboardListItem>> optional, boolean z, Long l) {
        this.f9121a = optional;
        this.f9122b = z;
        this.f9123c = l;
    }
}

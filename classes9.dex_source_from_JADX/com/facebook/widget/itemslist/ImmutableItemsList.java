package com.facebook.widget.itemslist;

import com.facebook.widget.itemslist.ItemsList.ContentItem;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.RegularImmutableList;

/* compiled from: sharer.php?u={share_link}&app_id={#app_id 0}&in_app={in_app false} */
public class ImmutableItemsList implements ItemsList {
    public static final ImmutableItemsList f3558a = new ImmutableItemsList(RegularImmutableList.a, false);
    public final ImmutableSet<ContentItem> f3559b;
    public final ImmutableList<Object> f3560c;
    public final boolean f3561d;

    public ImmutableItemsList(ImmutableList<Object> immutableList, boolean z) {
        this.f3560c = immutableList;
        this.f3561d = z;
        Builder builder = ImmutableSet.builder();
        int size = this.f3560c.size();
        for (int i = 0; i < size; i++) {
            Object obj = this.f3560c.get(i);
            if (obj instanceof ContentItem) {
                builder.c((ContentItem) obj);
            }
        }
        this.f3559b = builder.b();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("items", this.f3560c).add("hasHeaderRow", this.f3561d).toString();
    }

    public final Object m3351a(int i) {
        return this.f3560c.get(i);
    }

    public final int m3350a() {
        return this.f3560c.size();
    }
}

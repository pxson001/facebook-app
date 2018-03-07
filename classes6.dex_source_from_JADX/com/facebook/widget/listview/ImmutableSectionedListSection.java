package com.facebook.widget.listview;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.Nonnull;

/* compiled from: regularOpenHours */
public class ImmutableSectionedListSection<T> implements SectionedListSection<T> {
    private final String f6040a;
    private final List<T> f6041b;
    public boolean f6042c;

    public ImmutableSectionedListSection() {
        this(null, RegularImmutableList.a);
    }

    public ImmutableSectionedListSection(String str, ImmutableList<T> immutableList) {
        this.f6040a = str;
        this.f6041b = (List) Preconditions.checkNotNull(immutableList);
    }

    public ImmutableSectionedListSection(String str, ImmutableList<T> immutableList, boolean z) {
        this.f6040a = str;
        this.f6041b = (List) Preconditions.checkNotNull(immutableList);
        this.f6042c = z;
    }

    public final String mo432a() {
        return this.f6040a;
    }

    @Nonnull
    public final List<T> mo434b() {
        return this.f6041b;
    }

    public final boolean mo435c() {
        return false;
    }

    public final void mo433a(boolean z) {
    }

    public final boolean mo436f() {
        return false;
    }
}

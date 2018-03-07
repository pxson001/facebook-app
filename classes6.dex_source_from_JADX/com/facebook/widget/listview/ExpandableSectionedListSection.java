package com.facebook.widget.listview;

import java.util.List;
import javax.annotation.Nonnull;

/* compiled from: regular_pymk_imp */
public abstract class ExpandableSectionedListSection<T> implements SectionedListSection<T> {
    private final String f6038a;
    private boolean f6039b;

    protected abstract List<T> mo1211d();

    public abstract List<T> mo1212e();

    public ExpandableSectionedListSection(String str) {
        this.f6038a = str;
    }

    public final String mo432a() {
        return this.f6038a;
    }

    @Nonnull
    public final List<T> mo434b() {
        return this.f6039b ? mo1212e() : mo1211d();
    }

    public final boolean mo435c() {
        return !this.f6039b && mo1212e().size() > mo1211d().size();
    }

    public final void mo433a(boolean z) {
        this.f6039b = z;
    }

    public final boolean mo436f() {
        return false;
    }
}

package com.facebook.reviews.adapter;

import com.facebook.widget.listview.SectionedListSection;
import javax.annotation.Nullable;

/* compiled from: USER_ACTION */
public abstract class UserReviewsListBaseSection<T> implements SectionedListSection<T> {

    /* compiled from: USER_ACTION */
    public interface SectionChangedListener {
        void mo1169f();
    }

    protected abstract UserReviewsListViewTypes mo1162a(int i);

    protected abstract T mo1163b(int i);

    protected abstract int mo1166k();

    protected UserReviewsListViewTypes mo1164i() {
        return UserReviewsListViewTypes.DEFAULT_HEADER;
    }

    protected boolean mo1165j() {
        return false;
    }

    @Nullable
    protected UserReviewsListBaseFooter mo1167l() {
        return null;
    }

    public final boolean m24967c() {
        return false;
    }

    public final void m24965a(boolean z) {
    }

    public final boolean m24968f() {
        return false;
    }
}

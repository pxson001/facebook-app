package com.facebook.reviews.adapter;

import com.facebook.reviews.adapter.UserReviewsListBaseSection.SectionChangedListener;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: URL_IMAGE_OLD */
public abstract class UserReviewsListBaseFooter {
    public boolean f21364a;
    private Optional<SectionChangedListener> f21365b;

    abstract UserReviewsListViewTypes mo1168a();

    public final void m24991a(@Nullable SectionChangedListener sectionChangedListener) {
        this.f21365b = Optional.fromNullable(sectionChangedListener);
    }

    public final void m24992b() {
        this.f21364a = true;
        if (this.f21365b.isPresent()) {
            ((SectionChangedListener) this.f21365b.get()).mo1169f();
        }
    }

    public final void m24993c() {
        this.f21364a = false;
        if (this.f21365b.isPresent()) {
            ((SectionChangedListener) this.f21365b.get()).mo1169f();
        }
    }
}

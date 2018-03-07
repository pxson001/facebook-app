package com.facebook.feed.rows.sections.hscrollrecyclerview;

import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView.OnPageChangedListener;

/* compiled from: device_free_space */
class PersistentRecyclerPartDefinition$3 implements OnPageChangedListener {
    final /* synthetic */ PagerPersistentState f14174a;
    final /* synthetic */ PagerBinderDelegate f14175b;
    final /* synthetic */ PersistentRecyclerPartDefinition f14176c;

    PersistentRecyclerPartDefinition$3(PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, PagerPersistentState pagerPersistentState, PagerBinderDelegate pagerBinderDelegate) {
        this.f14176c = persistentRecyclerPartDefinition;
        this.f14174a = pagerPersistentState;
        this.f14175b = pagerBinderDelegate;
    }

    public final void mo1013a(int i, int i2) {
        if (this.f14174a != null) {
            if (this.f14174a.f13930a != i || this.f14174a.f13931b != i2) {
                this.f14174a.f13930a = i;
                this.f14174a.f13931b = i2;
            } else {
                return;
            }
        }
        this.f14175b.m14712b(i);
    }
}

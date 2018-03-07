package com.facebook.friending.immersive;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import javax.inject.Inject;

/* compiled from: add_contact_by_phone_number */
public class CardSpacingItemDecoration extends ItemDecoration {
    private final int f20174a;

    @Inject
    public CardSpacingItemDecoration(Resources resources) {
        this.f20174a = resources.getDimensionPixelSize(2131434224);
    }

    public final void m20492a(Rect rect, View view, RecyclerView recyclerView, State state) {
        Object obj;
        int i;
        if (RecyclerView.d(view) == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i = 0;
        } else {
            i = this.f20174a;
        }
        rect.top = i;
    }
}

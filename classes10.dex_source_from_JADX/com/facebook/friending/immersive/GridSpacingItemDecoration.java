package com.facebook.friending.immersive;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: add_account_api */
public class GridSpacingItemDecoration extends ItemDecoration {
    public final RTLUtil f20175a;
    public final int f20176b;
    private final int f20177c;
    private final int f20178d;

    @Inject
    public GridSpacingItemDecoration(Resources resources, RTLUtil rTLUtil, @Assisted int i) {
        this.f20177c = resources.getDimensionPixelSize(2131434223);
        this.f20178d = resources.getDimensionPixelSize(2131434222);
        this.f20175a = rTLUtil;
        this.f20176b = i;
    }

    public final void m20493a(Rect rect, View view, RecyclerView recyclerView, State state) {
        int i;
        int i2 = 0;
        int d = RecyclerView.d(view);
        int i3 = d % this.f20176b;
        Object obj = ((this.f20175a.a() || i3 != 0) && !(this.f20175a.a() && i3 == this.f20176b - 1)) ? null : 1;
        if (obj != null) {
            i = 0;
        } else {
            i = this.f20177c;
        }
        rect.left = i;
        if ((this.f20175a.a() || i3 != this.f20176b - 1) && !(this.f20175a.a() && i3 == 0)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            i = 0;
        } else {
            i = this.f20177c;
        }
        rect.right = i;
        if (d >= this.f20176b) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i2 = this.f20178d;
        }
        rect.top = i2;
    }
}

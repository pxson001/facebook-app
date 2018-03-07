package com.facebook.feed.inlinecomposer.multirow.work;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.facebook.widget.recyclerview.HScrollDividerDecorator;
import javax.inject.Inject;

/* compiled from: mutation_query_class */
public class WorkPogHScrollDividerDecorator extends ItemDecoration {
    private final HScrollDividerDecorator f13100a = new HScrollDividerDecorator(17170445, this.f13101b);
    private int f13101b;

    @Inject
    public WorkPogHScrollDividerDecorator(Resources resources) {
        this.f13101b = resources.getDimensionPixelSize(2131430511);
    }

    public final void mo2585a(Canvas canvas, RecyclerView recyclerView, State state) {
        this.f13100a.mo2585a(canvas, recyclerView, state);
    }

    public final void mo2586a(Rect rect, View view, RecyclerView recyclerView, State state) {
        Object obj;
        int i;
        rect.left = this.f13101b;
        if (RecyclerView.m17093d(view) == recyclerView.f11831o.aZ_() - 1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i = this.f13101b;
        } else {
            i = 0;
        }
        rect.right = i;
    }
}

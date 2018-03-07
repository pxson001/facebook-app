package com.facebook.instantshopping;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.facebook.common.util.SizeUtil;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.instantshopping.model.data.HasElementDescriptor;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.view.RichDocumentAdapter;
import com.facebook.richdocument.view.viewholder.BlockViewHolder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Starting ANR report */
public class InstantShoppingItemDecorator extends ItemDecoration implements InjectableComponentWithoutContext {
    public final Map<Integer, Paddings> f23456a;
    public int f23457b = -1;
    public Context f23458c;

    /* compiled from: Starting ANR report */
    class Paddings {
        final int f23451a;
        final int f23452b;
        final int f23453c;
        final int f23454d;
        final /* synthetic */ InstantShoppingItemDecorator f23455e;

        public Paddings(InstantShoppingItemDecorator instantShoppingItemDecorator, int i, int i2, int i3, int i4) {
            this.f23455e = instantShoppingItemDecorator;
            this.f23451a = i;
            this.f23452b = i2;
            this.f23453c = i3;
            this.f23454d = i4;
        }

        public Paddings(InstantShoppingItemDecorator instantShoppingItemDecorator, HasElementDescriptor hasElementDescriptor, int i) {
            int b;
            int i2 = 0;
            this.f23455e = instantShoppingItemDecorator;
            this.f23451a = hasElementDescriptor.mo1004u() != null ? InstantShoppingItemDecorator.m24781b(instantShoppingItemDecorator.f23458c, Integer.parseInt(hasElementDescriptor.mo1004u())) : 0;
            if (hasElementDescriptor.nB_() != null) {
                b = InstantShoppingItemDecorator.m24781b(instantShoppingItemDecorator.f23458c, Integer.parseInt(hasElementDescriptor.nB_()));
            } else {
                b = 0;
            }
            this.f23453c = b;
            if (hasElementDescriptor.mo1005w() != null) {
                i2 = InstantShoppingItemDecorator.m24781b(instantShoppingItemDecorator.f23458c, Integer.parseInt(hasElementDescriptor.mo1005w()));
            }
            this.f23452b = i2;
            if (hasElementDescriptor.nC_() != null) {
                i = InstantShoppingItemDecorator.m24781b(instantShoppingItemDecorator.f23458c, Integer.parseInt(hasElementDescriptor.nC_()));
            }
            this.f23454d = i;
        }
    }

    public InstantShoppingItemDecorator(Context context) {
        this.f23458c = context;
        this.f23456a = new HashMap();
    }

    public final void m24783a(Rect rect, View view, RecyclerView recyclerView, State state) {
        int d = RecyclerView.d(view);
        Paddings paddings = (Paddings) this.f23456a.get(Integer.valueOf(d));
        if (paddings != null) {
            rect.set(paddings.f23451a, paddings.f23452b, paddings.f23453c, paddings.f23454d);
            return;
        }
        BlockData a = m24780a((RichDocumentAdapter) recyclerView.o, d);
        paddings = (a == null || !(a instanceof HasElementDescriptor)) ? new Paddings(this, 0, 0, 0, 0) : new Paddings(this, (HasElementDescriptor) a, 0);
        this.f23456a.put(Integer.valueOf(d), paddings);
        rect.set(paddings.f23451a, paddings.f23452b, paddings.f23453c, paddings.f23454d);
    }

    public final void m24782a(Canvas canvas, RecyclerView recyclerView, State state) {
        int childCount = recyclerView.getChildCount();
        Paint paint = new Paint();
        for (int i = 0; i < childCount; i++) {
            int i2;
            View childAt = recyclerView.getChildAt(i);
            BlockViewHolder blockViewHolder = (BlockViewHolder) recyclerView.a(childAt);
            BlockData a = m24780a((RichDocumentAdapter) recyclerView.o, blockViewHolder.e());
            int i3 = this.f23457b;
            if (a == null || !(a instanceof HasElementDescriptor) || ((HasElementDescriptor) a).mo1006y() == null) {
                i2 = i3;
            } else {
                i2 = Color.parseColor(((HasElementDescriptor) a).mo1006y());
            }
            if (i2 != -1) {
                paint.setColor(i2);
                paint.setStyle(Style.FILL);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Paddings paddings = (Paddings) this.f23456a.get(Integer.valueOf(blockViewHolder.e()));
                int left = (childAt.getLeft() - paddings.f23451a) - layoutParams.leftMargin;
                i3 = childAt.getTop() - paddings.f23452b;
                int right = (childAt.getRight() + paddings.f23453c) + layoutParams.rightMargin;
                float bottom = (float) (paddings.f23454d + childAt.getBottom());
                canvas.drawRect((float) left, (float) i3, (float) right, bottom, paint);
            }
        }
    }

    private static BlockData m24780a(RichDocumentAdapter richDocumentAdapter, int i) {
        if (i < 0 || i >= richDocumentAdapter.aZ_()) {
            return null;
        }
        return richDocumentAdapter.e(i);
    }

    public static int m24781b(Context context, int i) {
        return SizeUtil.a(context, (float) i);
    }
}

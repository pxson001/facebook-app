package com.facebook.messaging.threadlist;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxItemType;

/* compiled from: possible_notification_subscription_levels */
public class InboxUnitCardDecoration extends ItemDecoration {
    public final Paint f4708a = new Paint();
    private final Paint f4709b;
    private final Drawable f4710c;
    private final Drawable f4711d;
    private final int f4712e;
    private final int f4713f;
    public final InboxAdapter f4714g;
    public boolean f4715h;

    /* compiled from: possible_notification_subscription_levels */
    public /* synthetic */ class C06531 {
        public static final /* synthetic */ int[] f4707a = new int[InboxItemType.values().length];

        static {
            try {
                f4707a[InboxItemType.V2_SECTION_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4707a[InboxItemType.V2_LOAD_MORE_THREADS_PLACEHOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4707a[InboxItemType.V2_MORE_FOOTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public InboxUnitCardDecoration(Context context, InboxAdapter inboxAdapter) {
        this.f4714g = inboxAdapter;
        this.f4708a.setColor(-1);
        this.f4708a.setStyle(Style.FILL);
        Resources resources = context.getResources();
        this.f4710c = resources.getDrawable(2131362279);
        this.f4711d = resources.getDrawable(2130840945);
        this.f4712e = resources.getDimensionPixelSize(2131427887);
        this.f4713f = resources.getDimensionPixelSize(2131427888);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{2130772803});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        int color = context.getResources().getColor(2131361863);
        this.f4709b = new Paint();
        this.f4709b.setColor(color);
        this.f4709b.setAntiAlias(true);
        this.f4709b.setStrokeWidth((float) dimensionPixelSize);
        this.f4709b.setDither(true);
    }

    public final void m4270a(Rect rect, View view, RecyclerView recyclerView, State state) {
        if (this.f4715h) {
            int f = ((LayoutParams) view.getLayoutParams()).f();
            f = m4266a(f) ? this.f4712e : m4267b(f) ? this.f4713f : 0;
            rect.set(0, f, 0, 0);
        }
    }

    public final void m4269a(Canvas canvas, RecyclerView recyclerView, State state) {
        if (this.f4715h) {
            m4264a(canvas, recyclerView);
        }
    }

    private void m4264a(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int f = ((LayoutParams) childAt.getLayoutParams()).f();
            m4265a(canvas, recyclerView, childAt, f);
            Object obj = null;
            if (f != -1) {
                switch (C06531.f4707a[this.f4714g.b(f).a().ordinal()]) {
                    case 1:
                        break;
                    default:
                        obj = 1;
                        break;
                }
            }
            if (obj != null) {
                int y = (int) childAt.getY();
                int height = y + childAt.getHeight();
                Canvas canvas2 = canvas;
                canvas2.drawRect((float) recyclerView.getPaddingLeft(), (float) y, (float) (recyclerView.getWidth() - recyclerView.getPaddingRight()), (float) height, this.f4708a);
            }
            m4268c(canvas, recyclerView, childAt, f);
        }
    }

    private void m4265a(Canvas canvas, RecyclerView recyclerView, View view, int i) {
        int y;
        int i2;
        if (m4266a(i)) {
            y = (int) view.getY();
            i2 = y - this.f4712e;
            this.f4710c.setBounds(recyclerView.getPaddingLeft(), i2, recyclerView.getWidth() - recyclerView.getPaddingRight(), y);
            this.f4710c.draw(canvas);
        } else if (m4267b(i)) {
            y = recyclerView.getPaddingLeft();
            i2 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int y2 = (int) (view.getY() - ((float) this.f4713f));
            int i3 = this.f4712e + y2;
            this.f4710c.setBounds(y, y2, i2, i3);
            this.f4710c.draw(canvas);
            this.f4711d.setBounds(y, y2, i2, i3 + (this.f4713f - this.f4712e));
            this.f4711d.draw(canvas);
        }
    }

    private boolean m4266a(int i) {
        if (i == -1 || i == 0) {
            return false;
        }
        switch (C06531.f4707a[this.f4714g.b(i - 1).a().ordinal()]) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    private boolean m4267b(int i) {
        if (i == -1 || i == 0) {
            return false;
        }
        switch (C06531.f4707a[this.f4714g.b(i).a().ordinal()]) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    private void m4268c(Canvas canvas, RecyclerView recyclerView, View view, int i) {
        if (i != -1) {
            Object obj = null;
            if (i != -1) {
                switch (C06531.f4707a[this.f4714g.b(i).a().ordinal()]) {
                    case 2:
                    case 3:
                        obj = 1;
                        break;
                    default:
                        break;
                }
            }
            if (obj != null) {
                int y = (int) view.getY();
                Canvas canvas2 = canvas;
                canvas2.drawLine((float) recyclerView.getPaddingLeft(), (float) y, (float) (recyclerView.getWidth() - recyclerView.getPaddingRight()), (float) y, this.f4709b);
            }
        }
    }
}

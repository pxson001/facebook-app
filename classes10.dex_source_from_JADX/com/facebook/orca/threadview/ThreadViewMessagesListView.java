package com.facebook.orca.threadview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.listview.BetterListView;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: missed_memories */
public class ThreadViewMessagesListView extends BetterListView {
    private final Set<Decoration> f7915a = Sets.a();
    private int f7916b;
    private boolean f7917c;

    /* compiled from: missed_memories */
    public interface Decoration {
        void mo244a();

        void mo245a(Canvas canvas);

        boolean mo246a(Drawable drawable);

        boolean mo247a(MotionEvent motionEvent);

        void mo248c();

        void mo249d();
    }

    /* compiled from: missed_memories */
    class C11991 implements OnScrollListener {
        final /* synthetic */ ThreadViewMessagesListView f7914a;

        C11991(ThreadViewMessagesListView threadViewMessagesListView) {
            this.f7914a = threadViewMessagesListView;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ThreadViewMessagesListView.m7865h(this.f7914a);
        }
    }

    public ThreadViewMessagesListView(Context context) {
        super(context);
        m7864g();
    }

    public ThreadViewMessagesListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7864g();
    }

    public ThreadViewMessagesListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7864g();
    }

    private void m7864g() {
        a(new C11991(this));
    }

    public final void m7866a(Decoration decoration) {
        this.f7915a.add(decoration);
    }

    public final void m7867b(Decoration decoration) {
        this.f7915a.remove(decoration);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        invalidateViews();
    }

    public int getPaddingBottom() {
        return this.f7916b;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f7916b = super.getPaddingBottom();
    }

    public static void m7865h(ThreadViewMessagesListView threadViewMessagesListView) {
        threadViewMessagesListView.f7917c = false;
        for (Decoration a : threadViewMessagesListView.f7915a) {
            a.mo244a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1425706363);
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f7917c = true;
                break;
            case 1:
                if (this.f7917c) {
                    for (Decoration a2 : this.f7915a) {
                        if (a2.mo247a(motionEvent)) {
                            LogUtils.a(1218634007, a);
                            return true;
                        }
                    }
                    break;
                }
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(81206039, a);
        return onTouchEvent;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        for (Decoration a : this.f7915a) {
            a.mo245a(canvas);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable)) {
            return true;
        }
        for (Decoration a : this.f7915a) {
            if (a.mo246a(drawable)) {
                return true;
            }
        }
        return false;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1095257972);
        super.onAttachedToWindow();
        for (Decoration c : this.f7915a) {
            c.mo248c();
        }
        LogUtils.g(578421984, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -317986430);
        super.onDetachedFromWindow();
        for (Decoration d : this.f7915a) {
            d.mo249d();
        }
        LogUtils.g(81603741, a);
    }
}

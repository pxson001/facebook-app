package com.facebook.orca.threadview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.orca.threadview.ThreadViewMessagesListView.Decoration;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: media_tray_offset */
public class ThreadViewMessagesRecyclerView extends BetterRecyclerView {
    public final Set<Decoration> f7919l = Sets.a();

    /* compiled from: media_tray_offset */
    class C12001 extends OnScrollListener {
        final /* synthetic */ ThreadViewMessagesRecyclerView f7918a;

        C12001(ThreadViewMessagesRecyclerView threadViewMessagesRecyclerView) {
            this.f7918a = threadViewMessagesRecyclerView;
        }

        public final void m7868a(RecyclerView recyclerView, int i, int i2) {
            for (Decoration a : this.f7918a.f7919l) {
                a.mo244a();
            }
        }
    }

    public ThreadViewMessagesRecyclerView(Context context) {
        super(context);
        m7870o();
    }

    public ThreadViewMessagesRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7870o();
    }

    public ThreadViewMessagesRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7870o();
    }

    private void m7870o() {
        a(new C12001(this));
    }

    public final void m7871a(Decoration decoration) {
        this.f7919l.add(decoration);
    }

    public final void m7872b(Decoration decoration) {
        this.f7919l.remove(decoration);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -695244494);
        if (motionEvent.getActionMasked() == 1) {
            for (Decoration a2 : this.f7919l) {
                if (a2.mo247a(motionEvent)) {
                    Logger.a(2, EntryType.UI_INPUT_END, -2065731160, a);
                    return true;
                }
            }
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(-1582434599, a);
        return onTouchEvent;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        for (Decoration a : this.f7919l) {
            a.mo245a(canvas);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable)) {
            return true;
        }
        for (Decoration a : this.f7919l) {
            if (a.mo246a(drawable)) {
                return true;
            }
        }
        return false;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -570462638);
        super.onAttachedToWindow();
        for (Decoration c : this.f7919l) {
            c.mo248c();
        }
        LogUtils.g(219187568, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1318685854);
        super.onDetachedFromWindow();
        for (Decoration d : this.f7919l) {
            d.mo249d();
        }
        LogUtils.g(-789555788, a);
    }
}

package com.facebook.feed.rows.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.ShimmerFrameLayout;

/* compiled from: UI_VOD */
public class HScrollLoadingCardView extends ShimmerFrameLayout implements RecyclableView {
    public boolean f21592c;
    public int f21593d = getResources().getDimensionPixelSize(2131428854);
    public RelativeLayout f21594e = ((RelativeLayout) findViewById(2131562959));

    /* compiled from: UI_VOD */
    public class C18101 implements OnGlobalLayoutListener {
        final /* synthetic */ HScrollLoadingCardView f21591a;

        public C18101(HScrollLoadingCardView hScrollLoadingCardView) {
            this.f21591a = hScrollLoadingCardView;
        }

        public void onGlobalLayout() {
            CustomViewUtils.a(this.f21591a, this);
            HScrollLoadingCardView hScrollLoadingCardView = this.f21591a;
            hScrollLoadingCardView.f21594e.setLayoutParams(new LayoutParams(-1, hScrollLoadingCardView.getParent() != null ? ((View) hScrollLoadingCardView.getParent()).getHeight() : 0));
            hScrollLoadingCardView.setPadding(hScrollLoadingCardView.f21593d, 0, hScrollLoadingCardView.f21593d, 0);
            hScrollLoadingCardView.invalidate();
        }
    }

    public HScrollLoadingCardView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(2130904809, this);
        getViewTreeObserver().addOnGlobalLayoutListener(new C18101(this));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, 0);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1466491378);
        super.onAttachedToWindow();
        this.f21592c = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1438398976, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 529449304);
        super.onDetachedFromWindow();
        this.f21592c = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1194014442, a);
    }

    public final boolean m24207a() {
        return this.f21592c;
    }
}

package com.facebook.feedplugins.multishare.ui;

import android.content.Context;
import android.widget.FrameLayout;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: confirmation_open */
public class MultiShareMapItemView extends PagerItemWrapperLayout implements RecyclableView {
    public boolean f8032a;
    public final FrameLayout f8033b = ((FrameLayout) c(2131559301));
    private final FbDraweeView f8034c = ((FbDraweeView) c(2131559122));

    public MultiShareMapItemView(Context context) {
        super(context);
        setContentView(2130905361);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 808748475);
        super.onAttachedToWindow();
        this.f8032a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1909228121, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1985465271);
        super.onDetachedFromWindow();
        this.f8032a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 844124861, a);
    }

    public final boolean m9088a() {
        return this.f8032a;
    }

    public void setController(DraweeController draweeController) {
        this.f8034c.setController(draweeController);
    }
}

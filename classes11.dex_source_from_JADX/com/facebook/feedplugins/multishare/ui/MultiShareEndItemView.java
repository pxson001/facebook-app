package com.facebook.feedplugins.multishare.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: conncls_bandwidth_bps */
public class MultiShareEndItemView extends MultiSharePagerItemView {
    @VisibleForTesting
    public FbDraweeView f8029a = ((FbDraweeView) c(2131564013));
    public boolean f8030b;
    public TextView f8031c = ((TextView) c(2131564017));

    public MultiShareEndItemView(Context context) {
        super(context);
        setContentView(2130905360);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1955523731);
        super.onAttachedToWindow();
        this.f8030b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1241443795, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -930123788);
        super.onDetachedFromWindow();
        this.f8030b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1257907122, a);
    }

    public final boolean m9087a() {
        return this.f8030b;
    }

    public View getCallToActionView() {
        return null;
    }
}

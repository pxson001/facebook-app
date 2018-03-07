package com.facebook.react.uimanager;

import android.content.Context;
import android.widget.FrameLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;

/* compiled from: handle_deltas_perf */
public class SizeMonitoringFrameLayout extends FrameLayout {
    @Nullable
    public OnSizeChangedListener f11409a;

    /* compiled from: handle_deltas_perf */
    public interface OnSizeChangedListener {
        void mo747a(int i, int i2);
    }

    public SizeMonitoringFrameLayout(Context context) {
        super(context);
    }

    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.f11409a = onSizeChangedListener;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1375118391);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f11409a != null) {
            this.f11409a.mo747a(i, i2);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 448959743, a);
    }
}

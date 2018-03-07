package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.internal.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: unified_message */
public class FitWindowsFrameLayout extends FrameLayout implements FitWindowsViewGroup {
    private OnFitSystemWindowsListener f1100a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(OnFitSystemWindowsListener onFitSystemWindowsListener) {
        this.f1100a = onFitSystemWindowsListener;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.f1100a != null) {
            this.f1100a.mo227a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}

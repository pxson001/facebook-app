package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.internal.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* compiled from: unfriend_tool */
public class FitWindowsLinearLayout extends LinearLayout implements FitWindowsViewGroup {
    private OnFitSystemWindowsListener f1101a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(OnFitSystemWindowsListener onFitSystemWindowsListener) {
        this.f1101a = onFitSystemWindowsListener;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.f1101a != null) {
            this.f1101a.mo227a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}

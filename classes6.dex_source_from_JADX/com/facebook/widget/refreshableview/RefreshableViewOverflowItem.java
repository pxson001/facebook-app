package com.facebook.widget.refreshableview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: reactions_dock_select_1 */
public class RefreshableViewOverflowItem extends View {
    public RefreshableViewOverflowItem(Context context) {
        super(context);
        m8767a();
    }

    public RefreshableViewOverflowItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8767a();
    }

    public RefreshableViewOverflowItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8767a();
    }

    private void m8767a() {
        setMinimumHeight((int) (500.0f * getContext().getResources().getDisplayMetrics().density));
    }
}

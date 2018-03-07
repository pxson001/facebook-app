package com.facebook.orca.compose.classic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.ui.util.CompoundTouchDelegate;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.touch.TouchDelegateUtils;

/* compiled from: openGraphActionDialogActionExecutor */
public class ClassicComposeEditContainerView extends LinearLayout {
    private View f5720a;

    public ClassicComposeEditContainerView(Context context) {
        super(context);
    }

    public ClassicComposeEditContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2027685048);
        super.onFinishInflate();
        this.f5720a = findViewById(2131564521);
        setAddStatesFromChildren(true);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1949987696, a);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m5403a(i2, i4);
        }
    }

    private void m5403a(int i, int i2) {
        setTouchDelegate(new CompoundTouchDelegate(this, new TouchDelegate[]{TouchDelegateUtils.a(this.f5720a, i, i2)}));
    }
}

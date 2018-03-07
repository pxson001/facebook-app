package com.facebook.ui.compat.fbrelativelayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import javax.annotation.Nullable;

/* compiled from: null gap feed edge */
public class FbRelativeLayout extends RelativeLayout {
    public FbRelativeLayout(Context context) {
        super(context);
    }

    public FbRelativeLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FbRelativeLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        m17744b();
        super.onMeasure(i, i2);
    }

    @TargetApi(17)
    private void m17744b() {
        if (VERSION.SDK_INT == 17 && getLayoutDirection() == 1) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int[] rules = layoutParams.getRules();
                if (m17743a(layoutParams, rules) || m17745b(layoutParams, rules) || m17746c(layoutParams, rules)) {
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @TargetApi(17)
    private static boolean m17743a(LayoutParams layoutParams, int[] iArr) {
        if (iArr[18] == 0 && iArr[19] == 0) {
            return false;
        }
        if (iArr[5] == 0 && iArr[7] == 0) {
            return false;
        }
        layoutParams.addRule(5, 0);
        layoutParams.addRule(7, 0);
        return true;
    }

    @TargetApi(17)
    private static boolean m17745b(LayoutParams layoutParams, int[] iArr) {
        if (iArr[20] == 0 && iArr[21] == 0) {
            return false;
        }
        if (iArr[9] == 0 && iArr[11] == 0) {
            return false;
        }
        layoutParams.addRule(9, 0);
        layoutParams.addRule(11, 0);
        return true;
    }

    @TargetApi(17)
    private static boolean m17746c(LayoutParams layoutParams, int[] iArr) {
        if (iArr[16] == 0 && iArr[17] == 0) {
            return false;
        }
        if (iArr[0] == 0 && iArr[1] == 0) {
            return false;
        }
        layoutParams.addRule(0, 0);
        layoutParams.addRule(1, 0);
        return true;
    }
}

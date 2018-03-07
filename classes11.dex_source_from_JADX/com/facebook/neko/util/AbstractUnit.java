package com.facebook.neko.util;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.ads.NativeAd;

/* compiled from: topDrawerStateChanged */
public abstract class AbstractUnit extends LinearLayout {
    public AbstractUnit(Context context) {
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    protected final void m1111a(View view) {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        view.setLayoutParams(new LayoutParams(-1, (int) (((double) ((int) (((float) point.x) * 0.8f))) / 2.11d)));
    }

    public void mo11a(NativeAd nativeAd) {
    }

    public void mo12a(AppUnitState appUnitState, boolean z, boolean z2) {
    }
}

package com.facebook.photos.simplepicker.nux;

import android.content.Context;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.facebook.fbui.tooltip.Tooltip;

/* compiled from: set_notify_me_fail */
class SimplePickerMultimediaInterstitialController$NoArrowTooltip extends Tooltip {
    public SimplePickerMultimediaInterstitialController$NoArrowTooltip(Context context, int i) {
        super(context, i);
    }

    protected final void m3182a(View view, boolean z, LayoutParams layoutParams) {
        super.a(view, z, layoutParams);
        View findViewById = this.f.findViewById(2131561861);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }
}

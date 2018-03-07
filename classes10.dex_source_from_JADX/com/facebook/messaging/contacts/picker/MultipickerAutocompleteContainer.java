package com.facebook.messaging.contacts.picker;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* compiled from: tap_camera_roll_item */
public class MultipickerAutocompleteContainer extends LinearLayout {
    public MultipickerAutocompleteContainer(Context context) {
        super(context);
    }

    public MultipickerAutocompleteContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void getWindowVisibleDisplayFrame(Rect rect) {
        super.getWindowVisibleDisplayFrame(rect);
        rect.bottom = getResources().getDisplayMetrics().heightPixels;
    }
}

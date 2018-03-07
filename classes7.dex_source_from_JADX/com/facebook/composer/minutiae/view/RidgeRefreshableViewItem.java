package com.facebook.composer.minutiae.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.audiofingerprinting.AudioFingerprintingSession.ErrorCode;
import com.facebook.widget.refreshableview.RefreshableViewItem;

/* compiled from: tertiary_message */
public class RidgeRefreshableViewItem extends RefreshableViewItem {
    public RidgeRefreshableViewItem(Context context) {
        super(context);
    }

    public RidgeRefreshableViewItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RidgeRefreshableViewItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final String m1860a(ErrorCode errorCode) {
        switch (errorCode) {
            case COMMERCIAL:
                return getResources().getString(2131234690);
            case NO_MATCH:
                return getResources().getString(2131234689);
            default:
                return getResources().getString(2131234691);
        }
    }

    public final String m1861e() {
        return getResources().getString(2131234692);
    }
}

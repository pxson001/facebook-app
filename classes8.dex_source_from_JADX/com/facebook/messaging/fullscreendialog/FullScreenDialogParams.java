package com.facebook.messaging.fullscreendialog;

import android.app.Service;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.facebook.common.ui.util.ViewDimensions;
import com.facebook.common.util.ContextUtils;

/* compiled from: tos_privacy_url */
public class FullScreenDialogParams {
    private int f1531a;
    private int f1532b;

    public final void m1690a(Bundle bundle) {
        bundle.putInt("arg_dialog_width", this.f1531a);
        bundle.putInt("arg_dialog_height", this.f1532b);
    }

    public static FullScreenDialogParams m1688a() {
        return new FullScreenDialogParams(-1, -1);
    }

    public static FullScreenDialogParams m1689a(Fragment fragment) {
        if ((ContextUtils.a(fragment.getContext(), Service.class) != null ? 1 : null) == null) {
            return m1688a();
        }
        Resources jW_ = fragment.jW_();
        View findViewById = fragment.T.getRootView().findViewById(16908290);
        ViewDimensions viewDimensions = new ViewDimensions(findViewById.getWidth() - jW_.getDimensionPixelSize(2131427728), ((findViewById.getHeight() - findViewById.getPaddingTop()) - findViewById.getPaddingBottom()) - jW_.getDimensionPixelSize(2131427763));
        return new FullScreenDialogParams(viewDimensions.a, viewDimensions.b);
    }

    private FullScreenDialogParams(int i, int i2) {
        this.f1531a = i;
        this.f1532b = i2;
    }
}

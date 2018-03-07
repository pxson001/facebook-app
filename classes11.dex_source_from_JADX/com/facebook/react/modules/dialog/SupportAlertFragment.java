package com.facebook.react.modules.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import javax.annotation.Nullable;

/* compiled from: SHOW_AD_PREFERENCES */
public class SupportAlertFragment extends DialogFragment implements OnClickListener {
    @Nullable
    private final AlertFragmentListener al;

    public SupportAlertFragment() {
        this.al = null;
    }

    public SupportAlertFragment(@Nullable AlertFragmentListener alertFragmentListener, Bundle bundle) {
        this.al = alertFragmentListener;
        g(bundle);
    }

    public final Dialog m11746c(Bundle bundle) {
        return AlertFragment.m11736a(o(), this.s, this);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.al != null) {
            this.al.onClick(dialogInterface, i);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.al != null) {
            this.al.onDismiss(dialogInterface);
        }
    }
}

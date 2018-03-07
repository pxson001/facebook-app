package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class SupportErrorDialogFragment extends DialogFragment {
    public Dialog al = null;
    public OnCancelListener am = null;

    public final Dialog mo13c(Bundle bundle) {
        if (this.al == null) {
            this.f89d = false;
        }
        return this.al;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.am != null) {
            this.am.onCancel(dialogInterface);
        }
    }
}

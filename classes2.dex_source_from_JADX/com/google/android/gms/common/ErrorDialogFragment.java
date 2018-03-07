package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;

public class ErrorDialogFragment extends DialogFragment {
    public Dialog f139a = null;
    public OnCancelListener f140b = null;

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f140b != null) {
            this.f140b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f139a == null) {
            setShowsDialog(false);
        }
        return this.f139a;
    }
}

package com.facebook.ui.errordialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: commerce */
class ErrorDialogs$1 implements OnClickListener {
    final /* synthetic */ ErrorDialogParams f5467a;
    final /* synthetic */ ErrorDialogs f5468b;

    ErrorDialogs$1(ErrorDialogs errorDialogs, ErrorDialogParams errorDialogParams) {
        this.f5468b = errorDialogs;
        this.f5467a = errorDialogParams;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f5467a.f5451h != null) {
            this.f5467a.f5451h.finish();
        }
        if (this.f5467a.f5452i != null) {
            this.f5467a.f5452i.a();
        }
    }
}

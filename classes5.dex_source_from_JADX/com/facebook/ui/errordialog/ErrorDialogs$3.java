package com.facebook.ui.errordialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

/* compiled from: commerce */
class ErrorDialogs$3 implements OnClickListener {
    final /* synthetic */ ErrorDialogParams f5471a;
    final /* synthetic */ ErrorDialogs f5472b;

    ErrorDialogs$3(ErrorDialogs errorDialogs, ErrorDialogParams errorDialogParams) {
        this.f5472b = errorDialogs;
        this.f5471a = errorDialogParams;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.VIEW", this.f5471a.f5447d);
        intent.putExtra("force_in_app_browser", true);
        this.f5472b.e.b(intent, this.f5472b.a);
    }
}

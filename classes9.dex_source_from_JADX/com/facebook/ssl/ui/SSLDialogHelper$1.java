package com.facebook.ssl.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

/* compiled from: userCredential */
class SSLDialogHelper$1 implements OnClickListener {
    final /* synthetic */ Context f765a;
    final /* synthetic */ SSLDialogHelper f766b;

    SSLDialogHelper$1(SSLDialogHelper sSLDialogHelper, Context context) {
        this.f766b = sSLDialogHelper;
        this.f765a = context;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f766b.a.b(new Intent("android.settings.DATE_SETTINGS"), this.f765a);
    }
}

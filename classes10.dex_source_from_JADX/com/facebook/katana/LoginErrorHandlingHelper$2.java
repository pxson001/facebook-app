package com.facebook.katana;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: SECRET */
class LoginErrorHandlingHelper$2 implements OnClickListener {
    final /* synthetic */ LoginErrorHandlingHelper f24206a;

    LoginErrorHandlingHelper$2(LoginErrorHandlingHelper loginErrorHandlingHelper) {
        this.f24206a = loginErrorHandlingHelper;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}

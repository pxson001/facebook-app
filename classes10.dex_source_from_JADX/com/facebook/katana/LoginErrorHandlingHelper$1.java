package com.facebook.katana;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.facebook.katana.view.LoggedOutWebViewActivity;

/* compiled from: SECRET */
class LoginErrorHandlingHelper$1 implements OnClickListener {
    final /* synthetic */ String f24202a;
    final /* synthetic */ boolean f24203b;
    final /* synthetic */ boolean f24204c;
    final /* synthetic */ LoginErrorHandlingHelper f24205d;

    LoginErrorHandlingHelper$1(LoginErrorHandlingHelper loginErrorHandlingHelper, String str, boolean z, boolean z2) {
        this.f24205d = loginErrorHandlingHelper;
        this.f24202a = str;
        this.f24203b = z;
        this.f24204c = z2;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        LoginErrorHandlingHelper loginErrorHandlingHelper = this.f24205d;
        String str = this.f24202a;
        boolean z = this.f24203b;
        boolean z2 = this.f24204c;
        loginErrorHandlingHelper.a();
        if (z) {
            loginErrorHandlingHelper.c.a(new Intent(loginErrorHandlingHelper.b, LoggedOutWebViewActivity.class).setData(Uri.parse(str)), loginErrorHandlingHelper.b);
        } else {
            Intent data = new Intent("android.intent.action.VIEW").setData(Uri.parse(str));
            data.addFlags(268435456);
            loginErrorHandlingHelper.c.b(data, loginErrorHandlingHelper.b);
        }
        if (z2) {
            loginErrorHandlingHelper.b.finish();
        }
    }
}

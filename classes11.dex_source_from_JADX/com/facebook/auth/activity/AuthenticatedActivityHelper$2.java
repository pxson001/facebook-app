package com.facebook.auth.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.katana.dbl.FbAndroidAuthActivityUtil;

/* compiled from: media_error_unknown */
class AuthenticatedActivityHelper$2 implements OnClickListener {
    final /* synthetic */ Activity f5475a;
    final /* synthetic */ AuthenticatedActivityHelper f5476b;

    AuthenticatedActivityHelper$2(AuthenticatedActivityHelper authenticatedActivityHelper, Activity activity) {
        this.f5476b = authenticatedActivityHelper;
        this.f5475a = activity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        ((FbAndroidAuthActivityUtil) this.f5476b.f.get()).a(this.f5475a);
        this.f5475a.finish();
    }
}

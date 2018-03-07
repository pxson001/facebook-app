package com.facebook.katana.dbl;

import android.app.Activity;
import com.facebook.katana.service.AppSession;
import com.facebook.katana.service.AppSessionListener;

/* compiled from: update_favorites */
class FbAndroidAuthActivityUtil$1 extends AppSessionListener {
    final /* synthetic */ AppSession f912a;
    final /* synthetic */ Activity f913b;
    final /* synthetic */ FbAndroidAuthActivityUtil f914c;

    FbAndroidAuthActivityUtil$1(FbAndroidAuthActivityUtil fbAndroidAuthActivityUtil, AppSession appSession, Activity activity) {
        this.f914c = fbAndroidAuthActivityUtil;
        this.f912a = appSession;
        this.f913b = activity;
    }

    public final void m938b(Throwable th) {
        this.f912a.b(this);
        this.f914c.b(this.f913b);
    }
}

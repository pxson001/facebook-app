package com.facebook.katana.activity;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.facebook.content.SecureContextHelper;
import com.facebook.katana.InternSettingsActivity;

/* compiled from: SDK_VERSION */
class FbMainTabActivity$30 implements OnLongClickListener {
    final /* synthetic */ FbMainTabActivity f24218a;

    FbMainTabActivity$30(FbMainTabActivity fbMainTabActivity) {
        this.f24218a = fbMainTabActivity;
    }

    public boolean onLongClick(View view) {
        ((SecureContextHelper) this.f24218a.C.get()).a(InternSettingsActivity.m638a(this.f24218a.ba), this.f24218a.ba);
        return true;
    }
}

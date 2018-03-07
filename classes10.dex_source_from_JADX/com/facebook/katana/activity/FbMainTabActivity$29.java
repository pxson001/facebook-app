package com.facebook.katana.activity;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.facebook.abtest.qe.settings.QuickExperimentListActivity;
import com.facebook.content.SecureContextHelper;

/* compiled from: SDK_VERSION */
class FbMainTabActivity$29 implements OnLongClickListener {
    final /* synthetic */ FbMainTabActivity f24217a;

    FbMainTabActivity$29(FbMainTabActivity fbMainTabActivity) {
        this.f24217a = fbMainTabActivity;
    }

    public boolean onLongClick(View view) {
        ((SecureContextHelper) this.f24217a.C.get()).a(QuickExperimentListActivity.a(this.f24217a.ba), this.f24217a.ba);
        return true;
    }
}

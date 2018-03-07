package com.facebook.katana.activity;

import android.content.Intent;
import com.facebook.backstage.consumption.BackstagePrefetchService;
import com.facebook.content.SecureContextHelper;

/* compiled from: SDK_VERSION */
class FbMainTabActivity$12 implements Runnable {
    final /* synthetic */ FbMainTabActivity f24210a;

    FbMainTabActivity$12(FbMainTabActivity fbMainTabActivity) {
        this.f24210a = fbMainTabActivity;
    }

    public void run() {
        Intent intent = new Intent(this.f24210a.ba, BackstagePrefetchService.class);
        intent.setAction("PREFETCH_GRAPHQL");
        ((SecureContextHelper) this.f24210a.C.get()).c(intent, this.f24210a);
    }
}

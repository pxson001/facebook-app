package com.facebook.dialtone;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.SecureContextHelper;
import com.facebook.dialtone.activity.DialtoneModeTransitionInterstitialActivity;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;

/* compiled from: ] */
class DialtoneControllerImpl$2 implements Listener {
    final /* synthetic */ DialtoneControllerImpl f11800a;

    DialtoneControllerImpl$2(DialtoneControllerImpl dialtoneControllerImpl) {
        this.f11800a = dialtoneControllerImpl;
    }

    public final void m19822a(Object obj) {
        if (((Boolean) this.f11800a.p.get()).booleanValue()) {
            this.f11800a.a("dialtone_upgrade_dialog");
            return;
        }
        Context f = this.f11800a.f();
        if (f == null) {
            DialtoneControllerImpl.t(this.f11800a);
            return;
        }
        Intent intent = new Intent(f, DialtoneModeTransitionInterstitialActivity.class);
        intent.addFlags(65536);
        ((SecureContextHelper) this.f11800a.e.get()).a(intent, f);
    }

    public final void m19821a() {
    }
}

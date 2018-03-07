package com.facebook.dialtone.automode;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.SecureContextHelper;
import com.facebook.dialtone.DialtoneController;

/* compiled from: The field 'receiverStatus' has been assigned the invalid value  */
class DialtoneAutoModeController$2 implements Runnable {
    final /* synthetic */ Intent f24207a;
    final /* synthetic */ DialtoneAutoModeController f24208b;

    DialtoneAutoModeController$2(DialtoneAutoModeController dialtoneAutoModeController, Intent intent) {
        this.f24208b = dialtoneAutoModeController;
        this.f24207a = intent;
    }

    public void run() {
        Context f = ((DialtoneController) this.f24208b.e.get()).f();
        if (f != null) {
            ((SecureContextHelper) this.f24208b.f.get()).a(this.f24207a, f);
        }
    }
}

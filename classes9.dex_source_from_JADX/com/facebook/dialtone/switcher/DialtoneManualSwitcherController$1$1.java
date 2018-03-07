package com.facebook.dialtone.switcher;

import android.widget.CompoundButton;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.switcher.DialtoneManualSwitcherController.1;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;

/* compiled from: permissions_email_header */
class DialtoneManualSwitcherController$1$1 implements Listener {
    final /* synthetic */ CompoundButton f6697a;
    final /* synthetic */ 1 f6698b;

    DialtoneManualSwitcherController$1$1(1 1, CompoundButton compoundButton) {
        this.f6698b = 1;
        this.f6697a = compoundButton;
    }

    public final void m6991a(Object obj) {
        ((DialtoneController) this.f6698b.a.h.get()).a("dialtone_switcher_enter_full_fb_upsell_dialog_confirm");
        DialtoneManualSwitcherController.a(this.f6698b.a, "dialtone_switcher_enter_full_fb_upsell_dialog_confirm");
        this.f6697a.setChecked(true);
        DialtoneManualSwitcherController.p(this.f6698b.a);
        this.f6698b.a.f();
    }

    public final void m6990a() {
        DialtoneManualSwitcherController.a(this.f6698b.a, "dialtone_switcher_enter_full_fb_upsell_dialog_canceled");
    }
}

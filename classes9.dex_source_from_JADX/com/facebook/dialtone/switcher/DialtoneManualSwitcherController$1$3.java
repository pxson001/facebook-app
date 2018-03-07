package com.facebook.dialtone.switcher;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.switcher.DialtoneManualSwitcherController.1;

/* compiled from: permissions_email_header */
class DialtoneManualSwitcherController$1$3 implements OnClickListener {
    final /* synthetic */ CompoundButton f6700a;
    final /* synthetic */ 1 f6701b;

    DialtoneManualSwitcherController$1$3(1 1, CompoundButton compoundButton) {
        this.f6701b = 1;
        this.f6700a = compoundButton;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        ((DialtoneController) this.f6701b.a.h.get()).a("dialtone_switcher_enter_full_fb_dialog_confirm");
        DialtoneManualSwitcherController.a(this.f6701b.a, "dialtone_switcher_enter_full_fb_dialog_confirm");
        this.f6700a.setChecked(true);
        DialtoneManualSwitcherController.p(this.f6701b.a);
        this.f6701b.a.f();
    }
}

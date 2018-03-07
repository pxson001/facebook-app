package com.facebook.dialtone.switcher;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: permissions_avatar */
class DialtoneManualSwitcherNuxActivity$1 implements OnClickListener {
    final /* synthetic */ DialtoneManualSwitcherNuxActivity f6702a;

    DialtoneManualSwitcherNuxActivity$1(DialtoneManualSwitcherNuxActivity dialtoneManualSwitcherNuxActivity) {
        this.f6702a = dialtoneManualSwitcherNuxActivity;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 287483376);
        DialtoneManualSwitcherNuxActivity.b(this.f6702a, "dialtone_switcher_nux_interstitial_ok_button_click");
        this.f6702a.finish();
        Logger.a(2, EntryType.UI_INPUT_END, 1729481340, a);
    }
}

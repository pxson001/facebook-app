package com.facebook.dialtone.switcher;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: permissions_avatar */
class DialtoneManualSwitcherNuxActivity$3 implements OnClickListener {
    final /* synthetic */ Uri f6706a;
    final /* synthetic */ DialtoneManualSwitcherNuxActivity f6707b;

    DialtoneManualSwitcherNuxActivity$3(DialtoneManualSwitcherNuxActivity dialtoneManualSwitcherNuxActivity, Uri uri) {
        this.f6707b = dialtoneManualSwitcherNuxActivity;
        this.f6706a = uri;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1370147572);
        this.f6707b.s.b(DialtoneManualSwitcherNuxActivity.b(this.f6707b, this.f6706a), this.f6707b.getApplicationContext());
        DialtoneManualSwitcherNuxActivity.b(this.f6707b, "dialtone_switcher_nux_interstitial_terms_link_click");
        Logger.a(2, EntryType.UI_INPUT_END, 1600818199, a);
    }
}

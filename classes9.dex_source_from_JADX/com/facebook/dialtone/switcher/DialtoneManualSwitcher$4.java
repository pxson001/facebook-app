package com.facebook.dialtone.switcher;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: permissions_email_text */
class DialtoneManualSwitcher$4 implements OnClickListener {
    final /* synthetic */ DialtoneManualSwitcher f6681a;

    DialtoneManualSwitcher$4(DialtoneManualSwitcher dialtoneManualSwitcher) {
        this.f6681a = dialtoneManualSwitcher;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1604108890);
        if (this.f6681a.d != null) {
            this.f6681a.d.a(this.f6681a.getContext());
        }
        Logger.a(2, EntryType.UI_INPUT_END, -248232128, a);
    }
}

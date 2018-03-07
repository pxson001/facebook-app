package com.facebook.dialtone.switcher;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: permissions_email_text */
class DialtoneManualSwitcher$2 implements OnClickListener {
    final /* synthetic */ DialtoneManualSwitcher f6679a;

    DialtoneManualSwitcher$2(DialtoneManualSwitcher dialtoneManualSwitcher) {
        this.f6679a = dialtoneManualSwitcher;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -865911219);
        if (this.f6679a.d != null) {
            DialtoneManualSwitcher.OnClickListener onClickListener = this.f6679a.d;
            this.f6679a.getContext();
            onClickListener.a();
        }
        Logger.a(2, EntryType.UI_INPUT_END, 2089524536, a);
    }
}

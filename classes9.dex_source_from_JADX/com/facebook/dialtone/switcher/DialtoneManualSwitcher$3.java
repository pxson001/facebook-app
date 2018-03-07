package com.facebook.dialtone.switcher;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: permissions_email_text */
class DialtoneManualSwitcher$3 implements OnClickListener {
    final /* synthetic */ DialtoneManualSwitcher f6680a;

    DialtoneManualSwitcher$3(DialtoneManualSwitcher dialtoneManualSwitcher) {
        this.f6680a = dialtoneManualSwitcher;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 2057790888);
        if (this.f6680a.d != null) {
            this.f6680a.d.a((CompoundButton) view, this.f6680a.getContext());
        }
        Logger.a(2, EntryType.UI_INPUT_END, -900691439, a);
    }
}

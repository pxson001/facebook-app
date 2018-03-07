package com.facebook.dialtone.switcher;

import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.zero.common.constants.DialtonePrefKeys;

/* compiled from: permissions_email_text */
class DialtoneManualSwitcher$5 implements OnDismissListener {
    final /* synthetic */ Lazy f6682a;
    final /* synthetic */ DialtoneManualSwitcher f6683b;

    DialtoneManualSwitcher$5(DialtoneManualSwitcher dialtoneManualSwitcher, Lazy lazy) {
        this.f6683b = dialtoneManualSwitcher;
        this.f6682a = lazy;
    }

    public final boolean m6988a(PopoverWindow popoverWindow) {
        ((FbSharedPreferences) this.f6682a.get()).edit().putBoolean(DialtonePrefKeys.C, false).commit();
        return false;
    }
}

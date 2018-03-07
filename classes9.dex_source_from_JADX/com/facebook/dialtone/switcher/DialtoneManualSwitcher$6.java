package com.facebook.dialtone.switcher;

import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.zero.common.constants.DialtonePrefKeys;

/* compiled from: permissions_email_text */
class DialtoneManualSwitcher$6 implements OnDismissListener {
    final /* synthetic */ Lazy f6684a;
    final /* synthetic */ DialtoneManualSwitcher f6685b;

    DialtoneManualSwitcher$6(DialtoneManualSwitcher dialtoneManualSwitcher, Lazy lazy) {
        this.f6685b = dialtoneManualSwitcher;
        this.f6684a = lazy;
    }

    public final boolean m6989a(PopoverWindow popoverWindow) {
        ((FbSharedPreferences) this.f6684a.get()).edit().putBoolean(DialtonePrefKeys.G, false).commit();
        return false;
    }
}

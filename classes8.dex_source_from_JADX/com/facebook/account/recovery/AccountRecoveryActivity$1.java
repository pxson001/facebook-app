package com.facebook.account.recovery;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: location_info */
class AccountRecoveryActivity$1 implements OnClickListener {
    final /* synthetic */ FragmentManager f10207a;
    final /* synthetic */ AccountRecoveryActivity f10208b;

    AccountRecoveryActivity$1(AccountRecoveryActivity accountRecoveryActivity, FragmentManager fragmentManager) {
        this.f10208b = accountRecoveryActivity;
        this.f10207a = fragmentManager;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1096963543);
        if (this.f10207a.e()) {
            Logger.a(2, EntryType.UI_INPUT_END, 1193997156, a);
            return;
        }
        this.f10208b.finish();
        LogUtils.a(-1802405218, a);
    }
}

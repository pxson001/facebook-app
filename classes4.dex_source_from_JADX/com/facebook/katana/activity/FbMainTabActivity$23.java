package com.facebook.katana.activity;

import android.content.Context;
import android.content.Intent;
import com.facebook.apptab.state.TabTag;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: voicemail_recorded */
class FbMainTabActivity$23 implements ActionReceiver {
    final /* synthetic */ FbMainTabActivity f221a;

    FbMainTabActivity$23(FbMainTabActivity fbMainTabActivity) {
        this.f221a = fbMainTabActivity;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        boolean z = false;
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 867176467);
        int intExtra = intent.getIntExtra("new_story_count", 0);
        if (!intent.getBooleanExtra("use_large_count", false)) {
            z = true;
        }
        this.f221a.bN = intExtra;
        FbMainTabActivity.a(this.f221a, TabTag.Feed, this.f221a.bN, true, Boolean.valueOf(z));
        LogUtils.e(871553477, a);
    }
}

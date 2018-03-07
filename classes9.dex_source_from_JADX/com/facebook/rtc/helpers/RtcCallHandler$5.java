package com.facebook.rtc.helpers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: application/vnd.wap.wmlscriptc */
class RtcCallHandler$5 implements OnDismissListener {
    final /* synthetic */ RtcCallHandler f19765a;

    RtcCallHandler$5(RtcCallHandler rtcCallHandler) {
        this.f19765a = rtcCallHandler;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f19765a.D = null;
    }
}

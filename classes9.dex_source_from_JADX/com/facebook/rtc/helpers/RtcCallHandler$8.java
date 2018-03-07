package com.facebook.rtc.helpers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: application/vnd.wap.wmlscriptc */
class RtcCallHandler$8 implements OnDismissListener {
    final /* synthetic */ RtcCallHandler f19775a;

    RtcCallHandler$8(RtcCallHandler rtcCallHandler) {
        this.f19775a = rtcCallHandler;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f19775a.D = null;
    }
}

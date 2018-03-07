package com.facebook.rtc.helpers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: application/vnd.wap.wmlscriptc */
class RtcCallHandler$4 implements OnClickListener {
    final /* synthetic */ RtcCallHandler f19764a;

    RtcCallHandler$4(RtcCallHandler rtcCallHandler) {
        this.f19764a = rtcCallHandler;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f19764a.D = null;
    }
}

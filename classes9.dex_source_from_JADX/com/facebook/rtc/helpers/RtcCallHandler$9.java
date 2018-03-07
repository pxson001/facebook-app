package com.facebook.rtc.helpers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: application/vnd.wap.wmlscriptc */
class RtcCallHandler$9 implements OnClickListener {
    final /* synthetic */ RtcCallHandler f19776a;

    RtcCallHandler$9(RtcCallHandler rtcCallHandler) {
        this.f19776a = rtcCallHandler;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}

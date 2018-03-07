package com.facebook.rtc.helpers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.rtcpresence.RtcAbortedCallReasonIds;
import com.facebook.user.model.UserKey;

/* compiled from: application/vnd.wap.wmlscriptc */
class RtcCallHandler$6 implements OnClickListener {
    final /* synthetic */ UserKey f19766a;
    final /* synthetic */ String f19767b;
    final /* synthetic */ RtcCallHandler f19768c;

    RtcCallHandler$6(RtcCallHandler rtcCallHandler, UserKey userKey, String str) {
        this.f19768c = rtcCallHandler;
        this.f19766a = userKey;
        this.f19767b = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19768c.o.a(this.f19766a.b(), this.f19767b, false, RtcAbortedCallReasonIds.k);
        dialogInterface.dismiss();
    }
}

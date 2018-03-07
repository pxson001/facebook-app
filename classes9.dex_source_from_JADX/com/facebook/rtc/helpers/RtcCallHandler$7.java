package com.facebook.rtc.helpers;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.user.model.UserKey;

/* compiled from: application/vnd.wap.wmlscriptc */
class RtcCallHandler$7 implements OnClickListener {
    final /* synthetic */ Context f19769a;
    final /* synthetic */ UserKey f19770b;
    final /* synthetic */ String f19771c;
    final /* synthetic */ String f19772d;
    final /* synthetic */ String f19773e;
    final /* synthetic */ RtcCallHandler f19774f;

    RtcCallHandler$7(RtcCallHandler rtcCallHandler, Context context, UserKey userKey, String str, String str2, String str3) {
        this.f19774f = rtcCallHandler;
        this.f19769a = context;
        this.f19770b = userKey;
        this.f19771c = str;
        this.f19772d = str2;
        this.f19773e = str3;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f19774f.a(this.f19769a, this.f19770b, true, this.f19771c, this.f19772d, this.f19773e, 0);
    }
}

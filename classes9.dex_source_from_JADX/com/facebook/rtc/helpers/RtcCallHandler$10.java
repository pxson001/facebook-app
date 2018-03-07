package com.facebook.rtc.helpers;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.messaging.model.threads.ThreadSummary;

/* compiled from: application/vnd.wap.wmlscriptc */
class RtcCallHandler$10 implements OnClickListener {
    final /* synthetic */ ThreadSummary f19753a;
    final /* synthetic */ String[] f19754b;
    final /* synthetic */ boolean f19755c;
    final /* synthetic */ String f19756d;
    final /* synthetic */ Context f19757e;
    final /* synthetic */ RtcCallHandler f19758f;

    RtcCallHandler$10(RtcCallHandler rtcCallHandler, ThreadSummary threadSummary, String[] strArr, boolean z, String str, Context context) {
        this.f19758f = rtcCallHandler;
        this.f19753a = threadSummary;
        this.f19754b = strArr;
        this.f19755c = z;
        this.f19756d = str;
        this.f19757e = context;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19758f.a(Long.toString(this.f19753a.a.i()), this.f19754b, this.f19754b, this.f19755c, this.f19756d, this.f19757e);
    }
}

package com.facebook.katana.urimap.fetchable;

import android.content.Context;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.diagnostics.TraceLogger;
import com.facebook.manageddatastore.NetworkRequestCallback;

/* compiled from: timeline_section_after */
class UriMapClient$1 implements NetworkRequestCallback<String, String> {
    final /* synthetic */ NetworkRequestCallback f1241a;
    final /* synthetic */ UriMapClient f1242b;

    UriMapClient$1(UriMapClient uriMapClient, NetworkRequestCallback networkRequestCallback) {
        this.f1242b = uriMapClient;
        this.f1241a = networkRequestCallback;
    }

    public final void m1278a(Context context, boolean z, Object obj, String str, Object obj2) {
        String str2;
        String str3 = (String) obj;
        String str4 = (String) obj2;
        Object obj3 = null;
        if (z) {
            if (BuildConstants.j && str4 != null) {
                str4 = str4.replace("fb:\\/\\/", "fb-work:\\/\\/");
            }
            obj3 = this.f1242b.b(str4);
            str2 = str4;
        } else {
            str2 = str4;
        }
        this.f1241a.b().a("passing callback up from shim layer");
        this.f1241a.a(context, z, str3, str2, obj3);
    }

    public final TraceLogger m1279b() {
        return this.f1241a.b();
    }
}

package com.facebook.http.protocol;

import android.content.SharedPreferences.Editor;
import com.facebook.common.udppriming.client.ColdStartPrimingInformation;

/* compiled from: dialtone_mode_selection_interstitial_back_pressed */
public class UDPPrimingHelper$2 implements Runnable {
    final /* synthetic */ String f5097a;
    final /* synthetic */ String f5098b;
    final /* synthetic */ UDPPrimingHelper f5099c;

    public UDPPrimingHelper$2(UDPPrimingHelper uDPPrimingHelper, String str, String str2) {
        this.f5099c = uDPPrimingHelper;
        this.f5097a = str;
        this.f5098b = str2;
    }

    public void run() {
        UDPPrimingHelper.g(this.f5099c);
        UDPPrimingHelper uDPPrimingHelper = this.f5099c;
        String str = this.f5097a;
        String str2 = this.f5098b;
        ColdStartPrimingInformation coldStartPrimingInformation = ColdStartPrimingInformation.a;
        String str3 = uDPPrimingHelper.b;
        if (str != null && str2 != null && str3 != null) {
            coldStartPrimingInformation.n = true;
            if (!str.equals(coldStartPrimingInformation.d) || !str2.equals(coldStartPrimingInformation.j) || !str3.equals(coldStartPrimingInformation.i)) {
                coldStartPrimingInformation.d = str;
                coldStartPrimingInformation.i = str3;
                coldStartPrimingInformation.j = str2;
                if (coldStartPrimingInformation.c != null) {
                    Editor edit = coldStartPrimingInformation.c.edit();
                    edit.putString("COLD_START_PRIME_INFO/FIRST_FETCH_STRING", coldStartPrimingInformation.d);
                    edit.putString("COLD_START_PRIME_INFO/USER_AGENT", coldStartPrimingInformation.i);
                    edit.putString("COLD_START_PRIME_INFO/USER_ID", coldStartPrimingInformation.j);
                    edit.commit();
                }
            }
        }
    }
}

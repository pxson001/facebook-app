package com.facebook.zero.sdk.util;

import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.zero.sdk.util.CarrierAndSimMccMnc.MccMncPair;
import javax.inject.Inject;

/* compiled from: mHost= */
public class ZeroNetworkAndTelephonyHelper {
    private final TelephonyManager f15548a;
    private final FbNetworkManager f15549b;

    public static ZeroNetworkAndTelephonyHelper m22187b(InjectorLike injectorLike) {
        return new ZeroNetworkAndTelephonyHelper(TelephonyManagerMethodAutoProvider.m3851b(injectorLike), FbNetworkManager.m3811a(injectorLike));
    }

    @Inject
    public ZeroNetworkAndTelephonyHelper(TelephonyManager telephonyManager, FbNetworkManager fbNetworkManager) {
        this.f15548a = telephonyManager;
        this.f15549b = fbNetworkManager;
    }

    public final CarrierAndSimMccMnc m22188a() {
        return new CarrierAndSimMccMnc(m22186a(this.f15548a.getNetworkOperator()), m22186a(this.f15548a.getSimOperator()));
    }

    private static MccMncPair m22186a(String str) {
        if (str == null || str.length() <= 3) {
            return new MccMncPair("0", "0");
        }
        return new MccMncPair(str.substring(0, 3), str.substring(3));
    }

    public final String m22189b() {
        String str;
        NetworkInfo i = this.f15549b.m3833i();
        int i2 = 8;
        if (i != null) {
            i2 = i.getType();
        }
        switch (i2) {
            case 0:
                str = "mobile";
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                str = "wifi";
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                str = "mobile_mms";
                break;
            case 3:
                str = "mobile_supl";
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                str = "mobile_dun";
                break;
            case 5:
                str = "mobile_hipri";
                break;
            case 6:
                str = "wimax";
                break;
            case 7:
                str = "bluetooth";
                break;
            case 9:
                str = "ethernet";
                break;
            default:
                str = "none";
                break;
        }
        return str;
    }
}
